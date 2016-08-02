package ir.bmi.api.WrapperFile.string;

import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.exception.IOExcelException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserBody;
import ir.bmi.api.excelParser.parserWrapper.ParserSheet;

import java.util.List;

/**
 * Created by alotfi on 6/6/2016.
 */
public class TextParserSheet implements ParserSheet {

    private List<String> sheet;
    private int index;
    private StringBuilder contentFile;
    private MetaDataObject metaDataObject;
    private String sheetName;
    private ParserBody wrapperBody;

    public TextParserSheet(StringBuilder contentFile, MetaDataObject metaDataObject) {
        this.contentFile = contentFile;
        this.metaDataObject = metaDataObject;
        this.sheetName = metaDataObject.getSheetName();
    }

    public TextParserSheet(StringBuilder contentFile) {
        this.contentFile = contentFile;
        this.metaDataObject = metaDataObject;
        this.sheetName = metaDataObject.getSheetName();
    }

    public TextParserSheet(List<String> sheet, int index) {
        this.sheet = sheet;
        this.index = index;
    }

    public TextParserSheet(TextParserSheet parserSheet) {

    }

    public ParserBody getBody() throws IOExcelException {
        return wrapperBody;
    }

    public String getName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void parse(MetaDataObject metaDataObject) throws BaseExcelParserException {
        wrapperBody = new TextParserBody(sheet, index);
        wrapperBody.parse(metaDataObject);
    }

    public void create(MetaDataObject metaDataObject) throws BaseExcelParserException {
        TextParserBody parserBody = new TextParserBody(contentFile, metaDataObject.getMetaDataObjects());
        parserBody.create(metaDataObject);

    }
}



