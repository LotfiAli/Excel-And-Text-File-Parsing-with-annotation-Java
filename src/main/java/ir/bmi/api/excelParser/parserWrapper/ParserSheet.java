package ir.bmi.api.excelParser.parserWrapper;


import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperBody;
import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperHeader;
import ir.bmi.api.excelParser.exception.IOExcelException;

/**
 * Created by alotfi on 6/6/2016.
 */
public interface ParserSheet {
    WrapperHeader getHeader() throws IOExcelException;
    WrapperBody getBody() throws IOExcelException;
    String getName();
    void create() throws IOExcelException;


}
