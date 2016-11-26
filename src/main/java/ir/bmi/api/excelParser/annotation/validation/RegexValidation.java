package ir.bmi.api.excelParser.annotation.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by alotfi on 11/7/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RegexValidation {
    String RegularExpression() default "";
}
