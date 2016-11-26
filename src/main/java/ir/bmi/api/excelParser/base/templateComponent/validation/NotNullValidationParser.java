package ir.bmi.api.excelParser.base.templateComponent.validation;

import ir.bmi.api.excelParser.annotation.validation.NotNullValidation;

import java.lang.annotation.Annotation;

/**
 * Created by alotfi on 5/24/2016.
 */
public class NotNullValidationParser extends ValidationBase {

    public NotNullValidationParser() {
        super(NotNullValidation.class);
    }

    @Override
    protected String execute(Object value) {
        if (value == null || "".equals(value.toString()))
            return "value can not be null";
        return null;
    }


    public ExecuteValidation executeValidation(Annotation annotation) {
        return new NotNullValidationParser();
    }
}
