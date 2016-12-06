package ir.bmi.api.excelParser.parser.parsersAnnotation.cell;

import ir.bmi.api.excelParser.annotation.cell.ColorHeader;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 12/6/2016.
 */
public class ColorHeaderParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        ColorHeader column = getAnnotation(ColorHeader.class, field);
        if (column != null) {
            metaDataObject.setRedHeader(column.red());
            metaDataObject.setBlueHeader(column.blue());
            metaDataObject.setGreenHeader(column.green());
        }
    }
}
