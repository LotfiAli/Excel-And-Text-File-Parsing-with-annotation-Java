package ir.bmi.api.excelParser.parser.parsersAnnotation.cell;

import ir.bmi.api.excelParser.annotation.cell.BorderRight;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 12/7/2016.
 */
public class BoredrRightParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        BorderRight column = getAnnotation(BorderRight.class, field);
        if (column != null) {
            metaDataObject.setBorderCellRight(column.BOrderCell());
        }
    }
}
