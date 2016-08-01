package ir.bmi.api.WrapperFile.string;

import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperBody;
import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperHeader;
import ir.bmi.api.excelParser.exception.IOExcelException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
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
    private WrapperBody wrapperBody;

    public TextParserSheet(StringBuilder contentFile, MetaDataObject metaDataObject) {
        this.contentFile = contentFile;
        this.metaDataObject = metaDataObject;
        this.sheetName = metaDataObject.getSheetName();
    }

    public TextParserSheet(List<String> sheet, int index) {
        this.sheet = sheet;
        this.index = index;
    }

    public WrapperHeader getHeader() throws IOExcelException {
//        try {
//            return new WrapperHeader(new TextParserRow(sheet.readLine()));
//        } catch (IOException e) {
//            throw new IOExcelException("error in read text File", e);
//        }
        return null;
    }

    public WrapperBody getBody() throws IOExcelException {
        wrapperBody = new WrapperBody(new TextParserBody(sheet,index));
        return wrapperBody;
    }

    public String getName() {

        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public void create() {
        TextParserBody parserBody = new TextParserBody(contentFile, metaDataObject.getMetaDataObjects());
        parserBody.create();

//        TextParserHeader textParserHeader=new TextParserHeader(contentFile,metaDataObject.getMetaDataObjects().get(0));
//        textParserHeader.create();
    }
}



