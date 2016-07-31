package ir.bmi.api.excelParser.base;

import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.ioExcel.readExcelFile.DefaultSerializeDeserialize;
import ir.bmi.api.excelParser.model.ResultModel;
import ir.bmi.api.excelParser.parserWrapper.ParserFile;
import ir.bmi.api.excelParser.ioExcel.readExcelFile.DeSerializeFile;
import ir.bmi.api.excelParser.ioExcel.readExcelFile.SerializeFile;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parser.metaDataParser.BaseMetaDataParserImpl;

/**
 * Created by alotfi on 5/24/2016.
 */
public class ParserManagerImpl implements ParserManager {

    private String pathFile;
    private Class typeClass;
    private ParserFile parserFile;

    public ParserManagerImpl(Class typeClass, String pathFile) {
//        this(typeClass, new ExcelParser(pathFile));
//        this.pathFile = pathFile;
    }

    public ParserManagerImpl(Class typeClass, ParserFile parserFile) {
        this.typeClass = typeClass;
        this.parserFile = parserFile;
    }

    public  ResultModel deSerialize() throws BaseExcelParserException {
        return deSerialize(new DefaultSerializeDeserialize());
    }

    public  ResultModel deSerialize(DeSerializeFile deSerializeFile) throws BaseExcelParserException {
        MetaDataObject metaDataObject = BaseMetaDataParserImpl.getMetaData(this.typeClass, null);
        return deSerializeFile.deserializeFile(metaDataObject, typeClass, parserFile);
    }

    public void serialize(Object value) throws BaseExcelParserException {
        serialize(value, new DefaultSerializeDeserialize());
    }

    public void serialize(Object value, SerializeFile serializeFile) throws BaseExcelParserException {
        MetaDataObject metaDataObject = BaseMetaDataParserImpl.getMetaData(this.typeClass, value);
        serializeFile.serializeFile(metaDataObject, parserFile);
    }

}
