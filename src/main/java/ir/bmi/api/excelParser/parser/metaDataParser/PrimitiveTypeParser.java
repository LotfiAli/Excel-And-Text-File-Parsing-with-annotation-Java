package ir.bmi.api.excelParser.parser.metaDataParser;



import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.reflection.Utility;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 6/5/2016.
 */
public class PrimitiveTypeParser extends BaseMetaDataParserImpl {

    @Override
    public void ParserElement(MetaDataObject metaDataObject, Field field, Object targetObject) throws BaseExcelParserException {
        MetaDataObject e = parseElement(field);
        e.setType(field.getType());
        e.setComplex(false);
        e.setField(field);
        if (targetObject != null) {
            Object value = Utility.getObjectFromField(field, targetObject);
            e.setValuePrimitive(value);
        }
        metaDataObject.getMetaDataObjects().add(e);
    }
}