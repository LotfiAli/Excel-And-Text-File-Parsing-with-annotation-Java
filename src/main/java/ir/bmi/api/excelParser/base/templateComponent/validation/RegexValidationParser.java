package ir.bmi.api.excelParser.base.templateComponent.validation;



import ir.bmi.api.excelParser.annotation.validation.RegexValidation;

import java.lang.annotation.Annotation;

/**
 * Created by alotfi on 11/8/2016.
 */
public class RegexValidationParser extends ValidationBase {

    public RegexValidationParser() {
        super(RegexValidation.class);
    }

    @Override
    protected String execute(Object value) {
        return null;
    }


    public ExecuteValidation executeValidation(Annotation annotation)
    {
        return null;
    }
}
