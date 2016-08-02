package ir.bmi.api.excelParser.parserWrapper;

import ir.bmi.api.excelParser.exception.IOExcelException;

/**
 * Created by alotfi on 6/6/2016.
 */
public interface ParserSheet extends ParserComponent {
    //    WrapperHeader getHeader() throws IOExcelException;
    ParserBody getBody() throws IOExcelException;

    String getName();

//    void create() throws IOExcelException;

    String getSheetName();


}
