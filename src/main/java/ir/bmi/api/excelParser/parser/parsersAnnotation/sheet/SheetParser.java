package ir.bmi.api.excelParser.parser.parsersAnnotation.sheet;

import ir.bmi.api.excelParser.annotation.sheet.Sheet;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 5/24/2016.
 */
public class SheetParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        Sheet sheet = getAnnotation(Sheet.class, field);
        if (sheet != null)
            metaDataObject.setSheetName(sheet.name());
    }
}
