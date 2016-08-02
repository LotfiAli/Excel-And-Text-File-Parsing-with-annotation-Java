package ir.bmi.api.WrapperFile.string;

import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserCell;

/**
 * Created by alotfi on 6/6/2016.
 */
public class TextParseCell implements ParserCell {
    private String value;
    private StringBuilder row;

    public TextParseCell(String cell) {
        this.value = cell;
    }

    public TextParseCell(StringBuilder row) {
        this.row = row;

    }

    public Object getCellValue() {
        return value;
    }


    public void parse(MetaDataObject metaDataObject) throws BaseExcelParserException {

    }

    public void create(MetaDataObject metaDataObject) throws BaseExcelParserException {
        row.append(metaDataObject.getValuePrimitive());
    }
}
