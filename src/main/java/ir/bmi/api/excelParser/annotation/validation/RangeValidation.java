package ir.bmi.api.excelParser.annotation.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by alotfi on 11/7/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RangeValidation {

    long Min() default Long.MIN_VALUE;

    long Max() default Long.MAX_VALUE;
}
