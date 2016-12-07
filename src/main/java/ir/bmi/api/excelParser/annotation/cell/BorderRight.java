package ir.bmi.api.excelParser.annotation.cell;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by alotfi on 12/7/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface BorderRight {
    BORDER_CELL BOrderCell() default BORDER_CELL.BORDER_NONE;
}
