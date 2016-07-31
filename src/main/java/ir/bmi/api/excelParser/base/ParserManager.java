package ir.bmi.api.excelParser.base;

import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.ioExcel.readExcelFile.DeSerializeFile;
import ir.bmi.api.excelParser.ioExcel.readExcelFile.SerializeFile;
import ir.bmi.api.excelParser.model.ResultModel;

/**
 * Created by alotfi on 5/24/2016.
 */
public interface ParserManager {

     ResultModel deSerialize() throws Exception;

     ResultModel deSerialize(DeSerializeFile deSerializeFile) throws BaseExcelParserException;

    void serialize(Object value, SerializeFile serializeFile) throws BaseExcelParserException;

    void serialize(Object value) throws Exception;
}
