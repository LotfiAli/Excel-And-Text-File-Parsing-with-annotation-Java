package ir.bmi.api.excelParser.base.templateComponent.wrapperFile;

import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.exception.IOExcelException;
import ir.bmi.api.excelParser.parserWrapper.ParserSheet;

import java.io.IOException;

/**
 * Created by alotfi on 5/25/2016.
 */
public class WrapperSheet {

    private ParserSheet parserSheet;

    public WrapperSheet(ParserSheet parserSheet) {
        this.parserSheet = parserSheet;
    }

    public WrapperBody getBodyRows() throws IOExcelException {
        return parserSheet.getBody();
    }

    public String getSheetName() {
        return parserSheet.getName();
    }

    public void write() throws IOExcelException {
        parserSheet.create();
    }

    public WrapperHeader getHeaderRows() throws IOExcelException {
        return parserSheet.getHeader();
    }
}
