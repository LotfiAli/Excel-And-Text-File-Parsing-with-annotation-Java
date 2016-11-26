package ir.bmi.api.WrapperFile.excel.text;


import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperBody;
import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperHeader;
import ir.bmi.api.excelParser.exception.IOExcelException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserSheet;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by alotfi on 6/6/2016.
 */
public class TextParserSheet implements ParserSheet {
    private BufferedReader sheet;
    private StringBuilder contentFile;
    private MetaDataObject metaDataObject;
    private String sheetName;
    private WrapperBody wrapperBody;

    public TextParserSheet(StringBuilder contentFile, MetaDataObject metaDataObject) {
        this.contentFile = contentFile;
        this.metaDataObject = metaDataObject;
        this.sheetName = metaDataObject.getSheetName();
    }

    public TextParserSheet(BufferedReader sheet) {
        this.sheet = sheet;
        this.sheetName = "file";
    }

    public WrapperHeader getHeader() throws IOExcelException {
        try {
            return new WrapperHeader(new TextParserRow(sheet.readLine()));
        } catch (IOException e) {
            throw new IOExcelException("error in read text File", e);
        }
    }

    public WrapperBody getBody() throws IOExcelException {
        wrapperBody = new WrapperBody(new TextParserBody(sheet));
        return wrapperBody;
    }

    public String getName() {

        return sheetName;
    }

    public void create() {
        TextParserBody parserBody = new TextParserBody(contentFile, metaDataObject.getMetaDataObjects());
        parserBody.create();

//        StringParserHeader textParserHeader=new StringParserHeader(contentFile,metaDataObject.getMetaDataObjects().get(0));
//        textParserHeader.create();
    }
}



