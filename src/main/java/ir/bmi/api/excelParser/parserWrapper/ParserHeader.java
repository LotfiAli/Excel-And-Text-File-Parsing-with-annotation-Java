package ir.bmi.api.excelParser.parserWrapper;


import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperHeader;
import ir.bmi.api.excelParser.exception.IOExcelException;

/**
 * Created by alotfi on 6/7/2016.
 */
public interface ParserHeader {
    WrapperHeader getHeader() throws IOExcelException;
    void create();
}
