package ir.bmi.api.excelParser.ioExcel.readExcelFile;

import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperFileImpl;
import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.model.ResultModel;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserFile;
import ir.bmi.api.excelParser.reflection.Utility;
import ir.bmi.api.excelParser.validation.ValidationResult;

/**
 * Created by alotfi on 5/25/2016.
 */

//May Be Must Use Decorator Pattern
public final class DefaultSerializeDeserialize implements SerializeFile, DeSerializeFile {

    private WrapperFileImpl wrapperExcel;
    private ValidationResult validationResult;

    public DefaultSerializeDeserialize() throws BaseExcelParserException {
        validationResult = new ValidationResult();
    }

    public ResultModel deserializeFile(MetaDataObject metaDataObject, Class typeResult, ParserFile parserFile) throws BaseExcelParserException {
        Object targetObject = null;
        this.wrapperExcel = new WrapperFileImpl(parserFile);
        this.wrapperExcel.read(metaDataObject);
        targetObject = createObjectFromMetaData(metaDataObject, typeResult);
        ResultModel resultModel = new ResultModel();
        resultModel.setValidationResult(validationResult);
        resultModel.setResultModel(targetObject);
        return resultModel;
    }

    public void serializeFile(MetaDataObject metaDataObject, ParserFile parserFile) throws BaseExcelParserException {
        this.wrapperExcel = new WrapperFileImpl(parserFile, metaDataObject);
        wrapperExcel.write();
    }

    private Object createObjectFromMetaData(MetaDataObject metaDataObject, Class typeResult) throws BaseExcelParserException {
        Object targetObject;
        targetObject = Utility.newInstanceFromType(typeResult);
        for (MetaDataObject metaData : metaDataObject.getMetaDataObjects()) {
            CreateObjectFromMetaData readerField = CreateObjectFromMetaData.createReaderField(targetObject, metaData, wrapperExcel, validationResult);
            readerField.read(metaData);
        }
        return targetObject;
    }
}
