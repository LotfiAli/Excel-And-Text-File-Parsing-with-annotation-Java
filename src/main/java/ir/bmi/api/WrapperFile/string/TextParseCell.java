package ir.bmi.api.WrapperFile.string;

import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserCell;

/**
 * Created by alotfi on 6/6/2016.
 */
public class TextParseCell implements ParserCell {
    private String value;
    private StringBuilder row;
    private MetaDataObject metaDataObject;

    public TextParseCell(String cell) {
        this.value = cell;
    }

    public TextParseCell(StringBuilder row, MetaDataObject metaDataObject) {
        this.row = row;
        this.metaDataObject = metaDataObject;
    }

    public Object getCellValue() {
        return value;
    }

    public void create() {
        row.append(metaDataObject.getValuePrimitive());
    }
}
