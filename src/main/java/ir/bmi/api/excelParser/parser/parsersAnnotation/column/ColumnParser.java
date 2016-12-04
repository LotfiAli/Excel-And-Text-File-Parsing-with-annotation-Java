package ir.bmi.api.excelParser.parser.parsersAnnotation.column;

import ir.bmi.api.excelParser.annotation.column.Column;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 5/24/2016.
 */
public class ColumnParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        Column column = getAnnotation(Column.class, field);
        if (column != null)
            metaDataObject.setColumn(column.Index());
    }
}
