package ir.bmi.api.excelParser.parserWrapper;

import ir.bmi.api.WrapperFile.excel.excel.ExcelParserSheet;
import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.parser.MetaDataObject;

/**
 * Created by alotfi on 6/5/2016.
 */
public interface ParserFile extends ParserComponent {
    ParserSheet getSheetByName(String sheetName);
}
