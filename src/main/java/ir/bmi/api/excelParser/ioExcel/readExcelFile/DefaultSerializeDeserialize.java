package ir.bmi.api.excelParser.ioExcel.readExcelFile;

import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperFileImpl;
import ir.bmi.api.excelParser.parserWrapper.ParserFile;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.reflection.Utility;

/**
 * Created by alotfi on 5/25/2016.
 */

//May Be Must Use Decorator Pattern
public final class DefaultSerializeDeserialize implements SerializeFile, DeSerializeFile {

    private WrapperFileImpl wrapperExcel;

    public DefaultSerializeDeserialize() throws BaseExcelParserException {

    }

    public <T> T deserializeFile(MetaDataObject metaDataObject, Class typeResult, ParserFile parserFile) throws BaseExcelParserException {
        Object targetObject = null;
//        new TextParser(this.pathFile)
        this.wrapperExcel = new WrapperFileImpl(parserFile);
        this.wrapperExcel.read();
        targetObject = createObjectFromMetaData(metaDataObject, typeResult);
        return (T) targetObject;
    }

    public void serializeFile(MetaDataObject metaDataObject, ParserFile parserFile) throws BaseExcelParserException {
//        (new TextParser(this.pathFile
        this.wrapperExcel = new WrapperFileImpl(parserFile, metaDataObject);
        wrapperExcel.write();
    }

    private Object createObjectFromMetaData(MetaDataObject metaDataObject, Class typeResult) throws BaseExcelParserException {
        Object targetObject;
        targetObject = Utility.newInstanceFromType(typeResult);
        for (MetaDataObject metaData : metaDataObject.getMetaDataObjects()) {
            CreateObjectFromMetaData readerField = CreateObjectFromMetaData.createReaderField(targetObject, metaData, wrapperExcel);
            readerField.read(metaData);
        }
        return targetObject;
    }
}
