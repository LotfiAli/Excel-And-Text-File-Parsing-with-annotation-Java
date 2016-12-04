package ir.bmi.api.excelParser.annotation.column;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by alotfi on 12/4/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface StartColumn {
    int Start() default 1;
}
