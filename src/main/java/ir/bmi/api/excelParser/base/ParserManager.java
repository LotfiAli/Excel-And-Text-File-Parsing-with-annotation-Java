package ir.bmi.api.excelParser.base;

import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.ioExcel.readExcelFile.DeSerializeFile;
import ir.bmi.api.excelParser.ioExcel.readExcelFile.SerializeFile;

import java.io.IOException;

/**
 * Created by alotfi on 5/24/2016.
 */
public interface ParserManager {

    <T> T deSerialize() throws Exception;

    <T> T deSerialize(DeSerializeFile deSerializeFile) throws BaseExcelParserException;

    void serialize(Object value, SerializeFile serializeFile) throws BaseExcelParserException;

    void serialize(Object value) throws Exception;
}
