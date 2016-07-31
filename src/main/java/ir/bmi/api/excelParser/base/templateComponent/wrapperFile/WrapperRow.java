package ir.bmi.api.excelParser.base.templateComponent.wrapperFile;

import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.parserWrapper.ParserRow;

import java.util.List;

/**
 * Created by alotfi on 5/25/2016.
 */
public class WrapperRow {
    //    private Row row;
    private List<WrapperCell> cellWrappers;
    private ParserRow parserRow;

    public WrapperRow(ParserRow parserRow) {
        this.parserRow = parserRow;
        cellWrappers = this.parserRow.getCells();
    }

    public WrapperCell getCellOfRowById(int index) {
        return cellWrappers.get(index);
    }

    public void read() throws BaseExcelParserException {
    }

    public int getRowNumber() {
        return this.parserRow.rowNumber();
    }

    public String getRowData() {
        return parserRow.getRowValueString().toString();
    }

}
