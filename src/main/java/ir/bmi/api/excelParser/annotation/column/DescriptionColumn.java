package ir.bmi.api.excelParser.annotation.column;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by alotfi on 7/16/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DescriptionColumn {
    String description();
}
