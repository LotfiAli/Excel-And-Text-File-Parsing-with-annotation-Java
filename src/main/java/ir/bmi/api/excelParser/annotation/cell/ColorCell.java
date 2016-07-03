package ir.bmi.api.excelParser.annotation.cell;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Color;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by alotfi on 6/8/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ColorCell {
    int blue() default 250;

    int green() default  250;

    int red() default 250;
}
