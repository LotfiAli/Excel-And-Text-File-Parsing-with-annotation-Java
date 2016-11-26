package ir.bmi.api.excelParser.ioExcel.readExcelFile;


import ir.bmi.api.excelParser.base.templateComponent.converter.Converter;
import ir.bmi.api.excelParser.base.templateComponent.validation.ExecuteValidation;
import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.*;
import ir.bmi.api.excelParser.exception.*;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.reflection.Utility;
import ir.bmi.api.excelParser.validation.ValidationResult;
import ir.bmi.api.excelParser.validation.ValidationResultItem;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by alotfi on 5/28/2016.
 */
public abstract class CreateObjectFromMetaData {

    public static final int NO_VALIDATION = 0;
    private WrapperFileImpl wrapperExcel;
    private WrapperSheet sheet;
    private WrapperBody rows;
    private Object instance;
    protected ValidationResult validationResult;
    private boolean isError = false;


    public CreateObjectFromMetaData(Object instance, WrapperFileImpl wrapperFile, ValidationResult validationResult) {
        this.wrapperExcel = wrapperFile;
        this.instance = instance;
        this.validationResult = validationResult;
    }

    public static CreateObjectFromMetaData createReaderField(Object instance, MetaDataObject metaData, WrapperFileImpl wrapperExcel, ValidationResult validationResult) throws BaseExcelParserException {
        if (metaData.getComplex() && metaData.getArray())
            return new CreateComplexListField(instance, wrapperExcel, validationResult);
        if (metaData.getComplex() && !metaData.getArray())
            return new CreateComplexField(instance, wrapperExcel, validationResult);
        throw new IOExcelException("can not parse this filed" + metaData.getName(), new IllegalArgumentException());
    }

    protected abstract void writeField(MetaDataObject metaDataObject, Object obj) throws BaseExcelParserException;

    protected abstract void readField(WrapperBody body, MetaDataObject metaDate) throws BaseExcelParserException;

    public void read(MetaDataObject metaDate) throws BaseExcelParserException {
        sheet = getSheet(metaDate);
        rows = sheet.getBodyRows();
        if (rows == null)
            return;
        readField(rows, metaDate);
    }

    private WrapperSheet getSheet(MetaDataObject metaDate) throws ParserException {
        return wrapperExcel.getSheetByName(metaDate.getSheetName());
    }

    protected void createRowFromMeatData(Object targetObject, WrapperRow row, MetaDataObject metaDate) {
        int i = 0;
        int rowNumber = 0;
        StringBuilder errorMessage = new StringBuilder();
//        errorMessage.append(row.getRowData());
        errorMessage.append(System.getProperty("line.separator"));
        for (MetaDataObject meta : metaDate.getMetaDataObjects()) {
            try {
                Field filed = Utility.getFieldByName(targetObject, meta.getName());
                WrapperCell cellOfRowById = row.getCellOfRowById(i);
                rowNumber = row.getRowNumber();
                Object value = getCellValue(cellOfRowById);
                checkValidation(value, meta, row, errorMessage);
                Utility.setFieldValue(filed, targetObject, checkConverter(value, meta, row, errorMessage));
                i++;

            } catch (Exception e) {
                errorMessage.append(" مشکل در خوانایی فایل " + meta.getDescriptionColumn() + " " + rowNumber + " " + row.getRowData());
//                break;
            }
//            errorMessage.append(errorMessage.toString());
        }
        if (isError) {
            errorMessage.append(System.getProperty("line.separator"));
            validationResult.addItem(new ValidationResultItem(errorMessage.toString()));
        }

    }

    private Object getCellValue(WrapperCell cellOfRowById) {
        return cellOfRowById.getCellValue();
    }

    private Object checkConverter(Object value, MetaDataObject meta, WrapperRow row, StringBuilder errorMessage) throws ConverterParserException {
        Converter converter = meta.getConverters();
        if (converter == null)
            return value;
        try {
            return converter.convertTo(value);
        } catch (Exception e) {
            isError = true;
            errorMessage.append("problem in convert data " + meta.getDescriptionColumn() + " " + row.getRowNumber());
        }
        return null;
    }

    private String checkValidation(Object value, MetaDataObject meta, WrapperRow row, StringBuilder errorMessage) throws ValidationParserException {
        List<ExecuteValidation> aBooleen = meta.getaBooleen();
//        StringBuilder errorMessage = new StringBuilder();
        if (aBooleen.size() == NO_VALIDATION)
            return null;
        for (ExecuteValidation aBoolean : aBooleen) {
            String valid = aBoolean.isValid(value);
            if (valid != null && !"".equals(valid)) {
                isError = true;
                errorMessage.append(valid);
                errorMessage.append(" ");
                errorMessage.append(meta.getDescriptionColumn());
                errorMessage.append("-");
//                errorMessage.append(row.getRowNumber());
//                errorMessage.append(" ");
//                errorMessage.append(row.getRowData());
            }
        }
//        if (!"".equals(errorMessage))
//            validationResult.addItem(new ValidationResultItem(errorMessage.toString(), meta.getDescriptionColumn(), row.getRowNumber(), row.getRowData()));
        return errorMessage.toString();
    }

    public Object getInstance() {
        return instance;
    }
}


