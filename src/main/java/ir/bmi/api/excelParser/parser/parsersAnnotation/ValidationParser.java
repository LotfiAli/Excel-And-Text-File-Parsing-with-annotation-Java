package ir.bmi.api.excelParser.parser.parsersAnnotation;

import ir.bmi.api.excelParser.base.templateComponent.validation.Validation;
import ir.bmi.api.excelParser.base.templateComponent.validation.NotNullValidation;
import ir.bmi.api.excelParser.parser.MetaDataObject;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * Created by alotfi on 5/24/2016.
 */
public class ValidationParser extends CollectionValidationBase<Validation> {

    private static final String VALIDATION = "Validation";

    @Override
    protected void addToMetaDataObject(List<Validation> parsers, MetaDataObject metaDataObject) {
        metaDataObject.setValidations(parsers);
    }

    @Override
    protected Validation createParseForAnnotation(Annotation annotation) {
//        String annotationName = annotation.annotationType().getAccNum();
        if (checkConstraint(annotation))
            return createValidation(annotation);
        return null;
    }

    @Override
    protected Boolean checkConstraintAnnotation(Annotation annotation) {
        return checkConstraint(annotation);
    }

    private Boolean checkConstraint(Annotation annotation) {
        String annotationName = getNameAnnotation(annotation);
        return (annotationName.contains(VALIDATION));
    }

    //Must Be Dynamic No Hard Code
    private Validation createValidation(Annotation annotation) {
        String annotationName = getNameAnnotation(annotation);
        if (annotationName.contains("NotNullValidation"))
            return new NotNullValidation();
        return null;
    }
}
