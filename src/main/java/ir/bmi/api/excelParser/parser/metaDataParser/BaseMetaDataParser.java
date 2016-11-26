package ir.bmi.api.excelParser.parser.metaDataParser;



import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.parser.MetaDataObject;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 6/5/2016.
 */
public interface BaseMetaDataParser {
    void parse(MetaDataObject metaDataObject, Field field, Object targetObject) throws BaseExcelParserException;
}
