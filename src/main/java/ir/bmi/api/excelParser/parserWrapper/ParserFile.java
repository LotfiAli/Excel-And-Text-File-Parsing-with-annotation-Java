package ir.bmi.api.excelParser.parserWrapper;


import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperSheet;
import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.parser.MetaDataObject;

import java.util.List;

/**
 * Created by alotfi on 6/5/2016.
 */
public interface ParserFile {
    List<WrapperSheet> parse(MetaDataObject metaDataObject) throws BaseExcelParserException;
    void create(MetaDataObject metaDataObject) throws BaseExcelParserException;
}
