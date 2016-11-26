package ir.bmi.api.excelParser.base.templateComponent.validation;

import java.lang.annotation.Annotation;

/**
 * Created by alotfi on 5/24/2016.
 */
public abstract class ValidationBase<T extends Annotation> implements ExecuteValidation, CanExecuteValidation {

    private Class typeClass;

    public ValidationBase(Class typeClass) {
        this.typeClass = typeClass;
    }

    public ValidationBase() {
    }

    protected abstract String execute(Object value);

    public String isValid(Object value) {
        return execute(value);
    }


    public final boolean canExecuteValidation(Annotation annotation) {
        Class annotationType = annotation.annotationType();
        return annotationType==typeClass;
//            return parseValidation(annotation);
//        return null;
    }

//    protected abstract ExecuteValidation parseValidation(Annotation annotation);
}
