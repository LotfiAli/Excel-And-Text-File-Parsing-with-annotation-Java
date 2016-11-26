package ir.bmi.api.excelParser.ioExcel.readExcelFile;


import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserFile;

/**
 * Created by alotfi on 6/7/2016.
 */
public interface SerializeFile {
    void serializeFile(MetaDataObject metaDataObject, ParserFile parserFile) throws BaseExcelParserException;
}
