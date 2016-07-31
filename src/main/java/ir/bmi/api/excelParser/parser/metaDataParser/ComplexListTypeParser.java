package ir.bmi.api.excelParser.parser.metaDataParser;

import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.reflection.Utility;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alotfi on 6/8/2016.
 */
public class ComplexListTypeParser extends BaseComplexParser {
    @Override
    protected void ParserElement(MetaDataObject metaDataObject, Field field, Object targetObject) throws BaseExcelParserException {

        Class<?> type = getType(field);
        MetaDataObject metaDataObjectComposite = parseElement(field);
        metaDataObjectComposite.setComplex(true);
        metaDataObjectComposite.setTypeGeneric(field.getType());
        metaDataObjectComposite.setArray(true);
        metaDataObjectComposite.setField(field);
        metaDataObjectComposite.setType(type);
        if (metaDataObjectComposite.getSheetName() == null) {
            metaDataObjectComposite.setSheetName(field.getName());
        }

        metaDataObject.getMetaDataObjects().add(metaDataObjectComposite);
        parseComplexObject(type, metaDataObjectComposite, targetObject, field);
    }

    private Class<?> getType(Field field) {
        ParameterizedType genericType = (ParameterizedType) field.getGenericType();
        return (Class<?>) genericType.getActualTypeArguments()[0];
    }

    @Override
    protected ArrayList<Object> getValueObject(Object targetObject, Field parentFiled) throws BaseExcelParserException {

        Object listObject = Utility.getObjectFromField(parentFiled, targetObject);
        try {
            Method toArrayMethod = List.class.getMethod("toArray");
            Object[] result = (Object[]) toArrayMethod.invoke(listObject);
            return new ArrayList<Object>(Arrays.asList(result));
        } catch (Exception e) {
            throw new BaseExcelParserException("error new Complex object", null);
        }
    }

}