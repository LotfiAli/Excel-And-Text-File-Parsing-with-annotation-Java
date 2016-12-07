package ir.bmi.api.excelParser.annotation.column;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by alotfi on 12/7/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ColumnTitel {
    String TitelName() default "";
}
