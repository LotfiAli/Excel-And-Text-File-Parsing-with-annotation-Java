package ir.bmi.api.excelParser.parser.parsersAnnotation.column;

import ir.bmi.api.excelParser.annotation.column.ColumnTitel;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 12/7/2016.
 */
public class ColumnTitelParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        ColumnTitel column = getAnnotation(ColumnTitel.class, field);
        if (column != null)
            metaDataObject.setColumnTitel(column.TitelName());
    }
}
