package ir.bmi.api.excelParser.parser.parsersAnnotation;

import ir.bmi.api.excelParser.parser.MetaDataObject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 5/28/2016.
 */
public abstract class CollectionValidationBase<T> extends BaseParser {

    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        List<T> parsers = new ArrayList<T>();
        Annotation[] annotations = field.getDeclaredAnnotations();
        if (annotations == null)
            return;
        for (Annotation annotation : annotations) {
            if (checkConstraintAnnotation(annotation)) {
                T parser = createParseForAnnotation(annotation);
                if (parser != null)
                    parsers.add(parser);
            }
        }
        addToMetaDataObject(parsers, metaDataObject);
    }


    protected abstract void addToMetaDataObject(List<T> parsers, MetaDataObject metaDataObject);

    protected abstract T createParseForAnnotation(Annotation annotation);

    protected abstract Boolean checkConstraintAnnotation(Annotation annotation);
}
