package ir.bmi.api.excelParser.parser.parsersAnnotation.cell;

import ir.bmi.api.excelParser.annotation.cell.SpamCell;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 12/5/2016.
 */
public class SpamCellParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        SpamCell column = getAnnotation(SpamCell.class, field);
        if (column != null) {
            metaDataObject.setSpamCell(column.SpamCell());
        }
    }
}
