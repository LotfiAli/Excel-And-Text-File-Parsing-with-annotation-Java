package ir.bmi.api.excelParser.parser.metaDataParser;

import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parser.parsersAnnotation.*;
import ir.bmi.api.excelParser.parser.parsersAnnotation.cell.AlignCellParser;
import ir.bmi.api.excelParser.parser.parsersAnnotation.cell.ColorHeaderParser;
import ir.bmi.api.excelParser.parser.parsersAnnotation.cell.ColorParser;
import ir.bmi.api.excelParser.parser.parsersAnnotation.cell.SpamCellParser;
import ir.bmi.api.excelParser.parser.parsersAnnotation.column.ColumnParser;
import ir.bmi.api.excelParser.parser.parsersAnnotation.column.CountColumnParser;
import ir.bmi.api.excelParser.parser.parsersAnnotation.column.DescriptionColumnParser;
import ir.bmi.api.excelParser.parser.parsersAnnotation.column.StartColumnParser;
import ir.bmi.api.excelParser.parser.parsersAnnotation.converter.ConverterParser;
import ir.bmi.api.excelParser.parser.parsersAnnotation.row.IndexRowParse;
import ir.bmi.api.excelParser.parser.parsersAnnotation.row.TitleHolderParser;
import ir.bmi.api.excelParser.parser.parsersAnnotation.sheet.SheetParser;
import ir.bmi.api.excelParser.parser.parsersAnnotation.validation.ValidationParser;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 6/5/2016.
 */
public abstract class BaseMetaDataParserImpl implements BaseMetaDataParser {

    private static BaseMetaDataParser primitiveParse = new PrimitiveTypeParser();
    private static BaseMetaDataParser complexParse = new ComplexTypeParser();
    private static BaseMetaDataParser complexListParser = new ComplexListTypeParser();
    private static List<ParsersElement> parsersElements = new ArrayList<ParsersElement>();

    static {
        parsersElements.add(new ColumnParser());
        parsersElements.add(new ConverterParser());
        parsersElements.add(new ValidationParser());
        parsersElements.add(new SheetParser());
        parsersElements.add(new ColorParser());
        parsersElements.add(new CountColumnParser());
        parsersElements.add(new DescriptionColumnParser());
        parsersElements.add(new IndexRowParse());
        parsersElements.add(new TitleHolderParser());
        parsersElements.add(new StartColumnParser());
        parsersElements.add(new SpamCellParser());
        parsersElements.add(new AlignCellParser());
        parsersElements.add(new ColorHeaderParser());

    }

    public static MetaDataObject getMetaData(Class value, Object targetObject) throws BaseExcelParserException {
        MetaDataObject metaDataObject = new MetaDataObject();
        Field[] fields = value.getDeclaredFields();
        for (Field field : fields) {
            BaseMetaDataParser parserElement = getParser(field);
            parserElement.parse(metaDataObject, field, targetObject);
        }
        return metaDataObject;
    }

    protected static BaseMetaDataParser getParser(Field field) throws IllegalArgumentException {
        if (field != null) {
            if (field.getType().isPrimitive() || field.getType() == String.class || field.getType()==Long.class) {
                return primitiveParse;
            } else {
                if (checkIsGenericType(field))
                    return complexListParser;
                return complexParse;
            }
        }
        throw new IllegalArgumentException("Filed Not Support", null);
    }

    protected MetaDataObject parseElement(Field field) {
        MetaDataObject metadataobject = new MetaDataObject();
        for (ParsersElement parsersElement : parsersElements) {
            parsersElement.parse(metadataobject, field);
        }
        metadataobject.setName(field.getName());
        metadataobject.setField(field);
        return metadataobject;
    }

    public void parse(MetaDataObject metaDataObject, Field field, Object targetObject) throws BaseExcelParserException {
        ParserElement(metaDataObject, field, targetObject);
    }

    protected abstract void ParserElement(MetaDataObject metaDataObject, Field field, Object targetObject) throws BaseExcelParserException;

    protected void createMetaDataFromField(Field[] fields, MetaDataObject metaDataObject, Object targetObject) throws BaseExcelParserException {
        for (Field field : fields) {
            if (field != null) {
                BaseMetaDataParser baseMetaDataParser = getParser(field);
                baseMetaDataParser.parse(metaDataObject, field, targetObject);
            }
        }
    }

    private static Boolean checkIsGenericType(Field field) {
        return field.getType() == List.class;
    }
}
