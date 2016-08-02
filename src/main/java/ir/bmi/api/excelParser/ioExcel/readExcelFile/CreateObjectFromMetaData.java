package ir.bmi.api.excelParser.ioExcel.readExcelFile;

import ir.bmi.api.WrapperFile.excel.excel.ExcelParseCell;
import ir.bmi.api.excelParser.base.templateComponent.converter.Converter;
import ir.bmi.api.excelParser.base.templateComponent.validation.Validation;
import ir.bmi.api.excelParser.enumParser.StateValidationItem;
import ir.bmi.api.excelParser.exception.*;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.*;
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
    private ParserFile wrapperExcel;
    private ParserSheet sheet;
    private ParserBody rows;
    private Object instance;
    protected ValidationResult validationResult;


    public CreateObjectFromMetaData(Object instance, ParserFile wrapperFile, ValidationResult validationResult) {
        this.wrapperExcel = wrapperFile;
        this.instance = instance;
        this.validationResult = validationResult;
    }

    public static CreateObjectFromMetaData createReaderField(Object instance, MetaDataObject metaData, ParserFile wrapperExcel, ValidationResult validationResult) throws BaseExcelParserException {
        if (metaData.getComplex() && metaData.getArray())
            return new CreateComplexListField(instance, wrapperExcel, validationResult);
        if (metaData.getComplex() && !metaData.getArray())
            return new CreateComplexField(instance, wrapperExcel, validationResult);
        throw new IOExcelException("can not parse this filed" + metaData.getName(), new IllegalArgumentException());
    }

    protected abstract void writeField(MetaDataObject metaDataObject, Object obj) throws BaseExcelParserException;

    protected abstract void readField(ParserBody body, MetaDataObject metaDate) throws BaseExcelParserException;

    public void read(MetaDataObject metaDate) throws BaseExcelParserException {
        sheet = getSheet(metaDate);
        rows = sheet.getBody();
        if (rows == null)
            return;
        readField(rows, metaDate);
    }

    private ParserSheet getSheet(MetaDataObject metaDate) throws ParserException {
        return wrapperExcel.getSheetByName(metaDate.getSheetName());
    }

    protected void createRowFromMeatData(Object targetObject, ParserRow row, MetaDataObject metaDate) {
        int i = 0;
        int rowNumber = 0;
        for (MetaDataObject meta : metaDate.getMetaDataObjects()) {
            try {
                Field filed = Utility.getFieldByName(targetObject, meta.getName());
                ParserCell cellOfRowById = row.getCellOfRowById(i);
                rowNumber = row.getRowNumber();
                Object value = getCellValue(cellOfRowById);
                checkValidation(value, meta, rowNumber);
                Utility.setFieldValue(filed, targetObject, checkConverter(value, meta, rowNumber));
                i++;

            } catch (ConverterParserException e) {
                validationResult.addItem(new ValidationResultItem(StateValidationItem.VALIDATION_ERROR, meta.getDescriptionColumn(), rowNumber, row.getRowData()));
                break;
            } catch (ValidationParserException e) {
                validationResult.addItem(new ValidationResultItem(StateValidationItem.CONVERTER_ERROR, meta.getDescriptionColumn(), rowNumber, row.getRowData()));
                break;
            } catch (ReadCellErrorException e) {
                validationResult.addItem(new ValidationResultItem(StateValidationItem.READ_FIELD_ERROR, meta.getDescriptionColumn(), rowNumber, row.getRowData()));
                break;
            } catch (IOExcelException e) {
                validationResult.addItem(new ValidationResultItem(StateValidationItem.READ_FIELD_ERROR, meta.getDescriptionColumn(), rowNumber, row.getRowData()));
                break;
            } catch (ParserException e) {
                validationResult.addItem(new ValidationResultItem(StateValidationItem.READ_FIELD_ERROR, meta.getDescriptionColumn(), rowNumber, row.getRowData()));
                break;
            } catch (Exception e) {
                validationResult.addItem(new ValidationResultItem(StateValidationItem.READ_FIELD_ERROR, meta.getDescriptionColumn(), rowNumber, row.getRowData()));
                break;
            }
        }
    }

    private Object getCellValue(ParserCell cellOfRowById) {
        return cellOfRowById.getCellValue();
    }

    private Object checkConverter(Object value, MetaDataObject metaDataObject, int rowNumber) throws ConverterParserException {
        Converter converter = metaDataObject.getConverters();
        if (converter == null)
            return value;
        try {
            return converter.convertTo(value);
        } catch (Exception e) {
            throw new ConverterParserException();
        }
    }

    private void checkValidation(Object value, MetaDataObject metaDataObject, int rowNumber) throws ValidationParserException {
        List<Validation> validations = metaDataObject.getValidations();
        if (validations.size() == NO_VALIDATION)
            return;
        for (Validation validation : validations) {
            if (!validation.isValid(value))
                throw new ValidationParserException();
        }
    }

    public Object getInstance() {
        return instance;
    }
}


