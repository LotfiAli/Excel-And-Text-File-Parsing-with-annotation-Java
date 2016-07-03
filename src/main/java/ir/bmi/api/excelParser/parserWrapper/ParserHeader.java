package ir.bmi.api.excelParser.parserWrapper;

import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperHeader;

/**
 * Created by alotfi on 6/7/2016.
 */
public interface ParserHeader {
    WrapperHeader getHeader();
    void create();
}
