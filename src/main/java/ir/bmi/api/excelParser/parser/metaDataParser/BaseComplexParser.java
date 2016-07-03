package ir.bmi.api.excelParser.parser.metaDataParser;

import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.parser.MetaDataObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 6/8/2016.
 */
public abstract class BaseComplexParser extends BaseMetaDataParserImpl {
    protected void parseComplexObject(Class<?> type, MetaDataObject metaDataObject, Object targetObject, Field parentFiled) throws BaseExcelParserException {
        if (targetObject != null) {
            List<Object> result = getValueObject(targetObject, parentFiled);
            for (Object item : result) {
                Field[] filed = item.getClass().getDeclaredFields();
                MetaDataObject metaData = new MetaDataObject();
                metaDataObject.getMetaDataObjects().add(metaData);
                createMetaDataFromField(filed, metaData, item);
            }
        } else {
            Field[] field = type.getDeclaredFields();
            createMetaDataFromField(field, metaDataObject, null);
        }
    }

    protected abstract ArrayList<Object> getValueObject(Object targetObject, Field parentFiled) throws BaseExcelParserException;


}
