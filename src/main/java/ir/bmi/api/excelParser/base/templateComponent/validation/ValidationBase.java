package ir.bmi.api.excelParser.base.templateComponent.validation;

import ir.bmi.api.excelParser.base.templateComponent.validation.Validation;

/**
 * Created by alotfi on 5/24/2016.
 */
public abstract class ValidationBase implements Validation {

    protected abstract Boolean execute(Object value);

    public Boolean executeValidation(Object value) {
       return execute(value);
    }
}
