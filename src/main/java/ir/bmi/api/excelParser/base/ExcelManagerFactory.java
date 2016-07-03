package ir.bmi.api.excelParser.base;

import ir.bmi.api.WrapperFile.excel.ExcelParser;
import ir.bmi.api.WrapperFile.text.TextParser;
import ir.bmi.api.excelParser.parserWrapper.ParserFile;

/**
 * Created by alotfi on 5/24/2016.
 */
public final class ExcelManagerFactory {
    public static ParserManager getExcelParserManager(String pathFile, Class typeClass) {
        return new ParserManagerImpl(typeClass, new ExcelParser(pathFile));
    }

    public static ParserManager getFileParserManager(String pathFile, Class typeClass) {
        return new ParserManagerImpl(typeClass, new TextParser(pathFile));
    }


    public static ParserManager getParserManager(Class typeClass, ParserFile parserFile) {
        return new ParserManagerImpl(typeClass, parserFile);
    }


}
