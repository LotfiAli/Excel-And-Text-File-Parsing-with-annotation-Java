package ir.bmi.api.excelParser.parser.parsersAnnotation;

import ir.bmi.api.excelParser.annotation.column.CountColumn;
import ir.bmi.api.excelParser.parser.MetaDataObject;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 7/12/2016.
 */
public class CountColumnParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        CountColumn column = getAnnotation(CountColumn.class, field);
        if (column != null) {
            int count = column.count();
            metaDataObject.setCountColumn(count);
        }
    }
}
