package ir.bmi.api.excelParser.annotation.cell;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by alotfi on 12/6/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AlignCell {
    ALIGN_CELL Align() default ALIGN_CELL.ALIGN_CENTER;
}
