package ir.bmi.api.excelParser.parserWrapper;

import ir.bmi.api.WrapperFile.excel.excel.ExcelParseCell;

/**
 * Created by alotfi on 6/6/2016.
 */
public interface ParserRow extends ParserComponent {
    //    List<WrapperCell> getCells();
//    void create();
    int rowNumber();

    Object getRowValueString();

    ParserCell getCellOfRowById(int i);

    int getRowNumber();

    String getRowData();
}
