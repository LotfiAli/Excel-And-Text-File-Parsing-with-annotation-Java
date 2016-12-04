package ir.bmi.api.excelParser.parser.parsersAnnotation.column;

import ir.bmi.api.excelParser.annotation.column.StartColumn;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 12/4/2016.
 */
public class StartColumnParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        StartColumn column = getAnnotation(StartColumn.class, field);
        if (column != null) {
            int start = column.Start();
            metaDataObject.setStartColumn(start);
        }
    }
}
