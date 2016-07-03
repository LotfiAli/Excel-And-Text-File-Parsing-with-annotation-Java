package ir.bmi.api.excelParser.ioExcel.readExcelFile;

import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperBody;
import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperFileImpl;
import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperRow;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.reflection.Utility;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 5/28/2016.
 */
public class CreateComplexField extends CreateObjectFromMetaData {


    public CreateComplexField(Object instance,WrapperFileImpl wrapperExcel) {
        super(instance,wrapperExcel);
    }

    @Override
    protected void writeField(MetaDataObject metaDataObject, Object obj) {

    }

    @Override
    protected void readField(WrapperBody body, MetaDataObject metaDate) throws BaseExcelParserException {
        WrapperRow bodyRow = body.getRowBodyByIndex(0);
        Field objectField = metaDate.getField();
        objectField.setAccessible(true);
        Object selectObject = null;
        selectObject = Utility.getObjectFromField(objectField, getInstance());
        createCompositeObject(selectObject, bodyRow, metaDate);
    }



}
