package ir.bmi.api.excelParser.parser.parsersAnnotation.cell;

import ir.bmi.api.excelParser.annotation.cell.AlignCell;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 12/6/2016.
 */
public class AlignCellParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        AlignCell column = getAnnotation(AlignCell.class, field);
        if (column != null) {
            metaDataObject.setAlign_cell(column.Align());
        }
    }
}
