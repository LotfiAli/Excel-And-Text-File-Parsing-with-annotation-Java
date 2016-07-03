package ir.bmi.api.excelParser.ioExcel.readExcelFile;

import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.exception.ParserExcelException;
import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperBody;
import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperFileImpl;
import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperRow;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.reflection.Utility;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by alotfi on 5/28/2016.
 */
public class CreateComplexListField extends CreateObjectFromMetaData {

    public static final String ADD = "add";

    public CreateComplexListField(Object instance,WrapperFileImpl wrapperExcel) {
        super(instance,wrapperExcel);
    }

    @Override
    protected void writeField(MetaDataObject metaDataObject, Object obj) throws BaseExcelParserException {
      Object targetObject=Utility.getObjectFromField(metaDataObject.getField(),obj);

    }

    @Override
    protected void readField(WrapperBody body, MetaDataObject metaDate) throws BaseExcelParserException {
        Object objectInstance = null;
        Field field = metaDate.getField();
        field.setAccessible(true);
        Object listObject = null;
        listObject = Utility.getObjectFromField(field, getInstance());
        for (WrapperRow row : body.getAllRows()) {
            objectInstance = Utility.newInstanceFromType(metaDate.getType());
            createCompositeObject( objectInstance, row, metaDate);
            addItemToToList(listObject, objectInstance);
        }
    }
    protected void addItemToToList(Object list, Object value) throws BaseExcelParserException {
        Method add = null;
        try {
            add = List.class.getDeclaredMethod(ADD, Object.class);
            add.invoke(list, value);
        } catch (Exception e) {
            throw new ParserExcelException("error in create instance object" + list.getClass().getName(), e);
        }
    }
}
