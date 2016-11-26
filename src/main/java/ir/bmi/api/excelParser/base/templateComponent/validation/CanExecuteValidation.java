package ir.bmi.api.excelParser.base.templateComponent.validation;

import java.lang.annotation.Annotation;

/**
 * Created by alotfi on 11/8/2016.
 */
public interface CanExecuteValidation {
    //Must be true or false
    boolean canExecuteValidation(Annotation annotation);

    ExecuteValidation executeValidation(Annotation annotation);

}
