package ir.bmi.api.excelParser.ioExcel.readExcelFile;

import ir.bmi.api.excelParser.base.templateComponent.converter.Converter;
import ir.bmi.api.excelParser.base.templateComponent.validation.Validation;
import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.*;
import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.exception.ParserExcelException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.reflection.Utility;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by alotfi on 5/28/2016.
 */
public abstract class CreateObjectFromMetaData {
    private WrapperFileImpl wrapperExcel;
    private WrapperSheet sheet;
    private WrapperBody rows;
    private Object instance;

    public CreateObjectFromMetaData(Object instance,WrapperFileImpl wrapperFile) {
        this.wrapperExcel = wrapperFile;
        this.instance = instance;
    }

    public static CreateObjectFromMetaData createReaderField(Object instance, MetaDataObject metaData,WrapperFileImpl wrapperExcel) throws BaseExcelParserException {
        if (metaData.getComplex() && metaData.getArray())
            return new CreateComplexListField(instance,wrapperExcel);
        if (metaData.getComplex() && !metaData.getArray())
            return new CreateComplexField(instance,wrapperExcel);
        throw new ParserExcelException("can not parse this filed" + metaData.getName(), new IllegalArgumentException());
    }

    protected abstract void writeField(MetaDataObject metaDataObject,Object obj) throws BaseExcelParserException;
    protected abstract void readField(WrapperBody body, MetaDataObject metaDate) throws BaseExcelParserException;

    public void read(MetaDataObject metaDate) throws BaseExcelParserException {
        sheet = getSheet(metaDate);
//        headerRows = sheet.getHeaderRows().get;
        rows = sheet.getBodyRows();
        if (rows == null)
            return;
        readField( rows, metaDate);
    }

    private WrapperSheet getSheet(MetaDataObject metaDate) throws ParserExcelException {
        return wrapperExcel.getSheetByName(metaDate.getSheetName());
    }

    protected void createCompositeObject(Object targetObject, WrapperRow row, MetaDataObject metaDate) throws BaseExcelParserException {
        int i = 0;
        for (MetaDataObject meta : metaDate.getMetaDataObjects()) {
            Field filed = getFieldByMetaData(targetObject, meta);
            WrapperCell cellOfRowById = row.getCellOfRowById(i);
            Object value = getCellValue(cellOfRowById);
            checkValidation(value, meta.getValidations());
            Utility.setFieldValue(filed, targetObject,  checkConverter(value, meta.getConverters()));
            i++;
        }
    }

    private Object getCellValue(WrapperCell cellOfRowById) {
        return cellOfRowById.getCellValue();
    }

    private Field getFieldByMetaData(Object targetObject, MetaDataObject meta) throws BaseExcelParserException {
        Field filed = null;
        filed = getTargetFiled(targetObject, meta.getName());
        filed.setAccessible(true);
        return filed;
    }

    private Object checkConverter(Object value, Converter converter) throws ParserExcelException {
        if (converter == null)
            return value;
        return converter.convertTo(value);
    }

    private void checkValidation(Object value, List<Validation> validations) throws ParserExcelException {
        if (validations.size() == 0)
            return;

        for (Validation validation : validations) {
            if (!validation.executeValidation(value))
                throw new ParserExcelException("value Con not be null.Validation Erroe", new IllegalArgumentException());
        }
    }

    private Field getTargetFiled(Object targetObject, Object filedName) throws BaseExcelParserException {
        try {
            return targetObject.getClass().getDeclaredField(filedName.toString());
        } catch (NoSuchFieldException e) {
            throw new ParserExcelException("error in create instance object" + filedName.getClass().getName(), e);
        }
    }

    public Object getInstance() {
        return instance;
    }

}
