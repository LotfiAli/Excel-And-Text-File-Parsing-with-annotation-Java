package ir.bmi.api.excelParser.parser.parsersAnnotation.cell;

import ir.bmi.api.excelParser.annotation.cell.BoredrBottom;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 12/7/2016.
 */
public class BoredrBottomParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        BoredrBottom column = getAnnotation(BoredrBottom.class, field);
        if (column != null) {
            metaDataObject.setBorderCellBottom(column.BOrderCell());
        }
    }
}
