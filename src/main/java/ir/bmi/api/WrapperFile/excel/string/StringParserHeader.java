package ir.bmi.api.WrapperFile.excel.string;


import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperHeader;
import ir.bmi.api.excelParser.exception.IOExcelException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserHeader;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by alotfi on 6/7/2016.
 */
public class StringParserHeader implements ParserHeader {

    private MetaDataObject metaDataObjects;
    private BufferedReader contentFile;
    private StringBuilder result;

    public StringParserHeader(BufferedReader contentFile) {
        this.contentFile = contentFile;
    }

    public StringParserHeader(StringBuilder contentFile, MetaDataObject metaDataObjects) {
        this.result = contentFile;
        this.metaDataObjects = metaDataObjects;
    }

    public WrapperHeader getHeader() throws IOExcelException {
        try {
            return new WrapperHeader(new StringParserRow(contentFile.readLine(), 0));
        } catch (IOException e) {
            throw new IOExcelException("error in parse body", e);
        }
    }

    public void create() {
        StringParserRow parserRow = new StringParserRow(result, this.metaDataObjects);
        parserRow.create();
        result.append(System.getProperty("line.separator"));
    }
}
