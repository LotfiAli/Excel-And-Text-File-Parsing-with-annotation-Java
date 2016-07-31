package ir.bmi.api.excelParser.annotation.column;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by alotfi on 7/12/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CountColumn {
    int count() default 0;
}
