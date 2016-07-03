package ir.bmi.api.excelParser.reflection;

import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.exception.IOExcelException;
import ir.bmi.api.excelParser.exception.ParserExcelException;


import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * Created by alotfi on 5/24/2016.
 */
public final class Utility {
    private Utility() {
    }

//    public static Object getValueFromFiled(Field field,Object object){
//
//    }
    public static Object getObjectFromField(Field field, Object object) throws BaseExcelParserException {
        try {
            field.setAccessible(true);
            return field.get(object);
        } catch (IllegalAccessException e) {
            throw new IOExcelException("error in create instance " + field.getName(), e);
        }
    }

    public static Object newInstanceFromType(Class<?> type) throws BaseExcelParserException {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new IOExcelException("error in create instance " + type.getName(), e);
        }
    }

    public static void setFieldValue(Field field, Object targetObject, Object value) throws BaseExcelParserException {
        try {
            field.setAccessible(true);
            field.set(targetObject, value);
        } catch (IllegalAccessException e) {
            throw new ParserExcelException("error in set field value" + field.getName(), e);
        }
    }

}
