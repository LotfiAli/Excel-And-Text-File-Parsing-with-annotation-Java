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
 * Created by alotfi on 6/5/2016.
 */
//TODO must be to class
public class ComplexTypeParser extends BaseComplexParser {

    @Override
    public void ParserElement(MetaDataObject metaDataObject, Field field, Object targetObject) throws BaseExcelParserException {
        Class<?> type = field.getType();
        ;
//        Field[] fieldComplexObject = type.getDeclaredFields();

        MetaDataObject metaDataObjectComposite = parseElement(field);
        metaDataObjectComposite.setComplex(true);
        metaDataObjectComposite.setTypeGeneric(field.getType());
        metaDataObjectComposite.setArray(false);
        metaDataObjectComposite.setField(field);
        metaDataObjectComposite.setType(type);
        if (metaDataObjectComposite.getSheetName() == null)
            metaDataObjectComposite.setSheetName("file");

        metaDataObject.getMetaDataObjects().add(metaDataObjectComposite);
        parseComplexObject(type, metaDataObjectComposite, targetObject, field);

    }

    @Override
    protected ArrayList<Object> getValueObject(Object targetObject, Field parentFiled) throws BaseExcelParserException {

        Object listObject = Utility.getObjectFromField(parentFiled, targetObject);
        try {
            ArrayList<Object> objectArray = new ArrayList<Object>();
            objectArray.add(listObject);
            return objectArray;
        } catch (Exception e) {
            throw new BaseExcelParserException("error new Complex object", null);
        }

    }



}
