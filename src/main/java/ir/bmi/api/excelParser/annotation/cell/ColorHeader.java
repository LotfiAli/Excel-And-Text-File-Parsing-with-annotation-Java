package ir.bmi.api.excelParser.annotation.cell;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by alotfi on 12/6/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ColorHeader {
    int blue() default 250;

    int green() default  250;

    int red() default 250;
}
