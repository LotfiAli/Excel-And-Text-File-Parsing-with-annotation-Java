package ir.bmi.api.excelParser.parser.parsersAnnotation;

import ir.bmi.api.excelParser.parser.MetaDataObject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by alotfi on 5/24/2016.
 */
public abstract class BaseParser implements ParsersElement {
    public abstract void parse(MetaDataObject metaDataObject, Field field);

    protected <T> T getAnnotation(Class aclass, Field field) {
        Annotation annotation = field.getAnnotation(aclass);
        if (annotation != null) {
            T result = (T) annotation;
            return result;
        }
        return null;
    }

    protected String getNameAnnotation(Annotation annotation) {
        return annotation.annotationType().getName();
    }
}