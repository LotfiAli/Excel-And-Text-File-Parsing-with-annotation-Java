package ir.bmi.api.excelParser.parser.parsersAnnotation.column;

import ir.bmi.api.excelParser.annotation.column.DescriptionColumn;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 7/16/2016.
 */
public class DescriptionColumnParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        DescriptionColumn column = getAnnotation(DescriptionColumn.class, field);
        if (column != null) {
            String description = column.description();
            metaDataObject.setDescriptionColumn(description);
        }
    }
}
