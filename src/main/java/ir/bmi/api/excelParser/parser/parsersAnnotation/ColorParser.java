package ir.bmi.api.excelParser.parser.parsersAnnotation;

import ir.bmi.api.excelParser.annotation.cell.ColorCell;
import ir.bmi.api.excelParser.parser.MetaDataObject;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 6/8/2016.
 */
public class ColorParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        ColorCell column = getAnnotation(ColorCell.class, field);
        if (column != null) {
            metaDataObject.setRed(column.red());
            metaDataObject.setBlue(column.blue());
            metaDataObject.setGreen(column.green());
        }
    }
}
