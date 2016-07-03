package ir.bmi.api.excelParser.annotation.column;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by alotfi on 5/24/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    int Index() default 0;
}
