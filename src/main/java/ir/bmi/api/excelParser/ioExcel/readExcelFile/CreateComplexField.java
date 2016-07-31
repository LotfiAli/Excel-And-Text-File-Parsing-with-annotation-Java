package ir.bmi.api.excelParser.ioExcel.readExcelFile;

import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperBody;
import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperFileImpl;
import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperRow;
import ir.bmi.api.excelParser.enumParser.StateValidationItem;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.reflection.Utility;
import ir.bmi.api.excelParser.validation.ValidationResult;
import ir.bmi.api.excelParser.validation.ValidationResultItem;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 5/28/2016.
 */
public class CreateComplexField extends CreateObjectFromMetaData {


    public CreateComplexField(Object instance, WrapperFileImpl wrapperExcel, ValidationResult validationResult) {
        super(instance, wrapperExcel, validationResult);
    }

    @Override
    protected void writeField(MetaDataObject metaDataObject, Object obj) {

    }

    @Override
    protected void readField(WrapperBody body, MetaDataObject metaDate) {
        WrapperRow bodyRow = body.getRowBodyByIndex(0);
        Field objectField = metaDate.getField();
        objectField.setAccessible(true);
        Object selectObject = null;
        try {
            selectObject = Utility.getObjectFromField(objectField, getInstance());
            createRowFromMeatData(selectObject, bodyRow, metaDate);
        } catch (Exception e) {
            validationResult.addItem(new ValidationResultItem(StateValidationItem.READ_FIELD_ERROR, metaDate.getDescriptionColumn(), bodyRow.getRowNumber()));
        }

    }


}
