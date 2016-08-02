package ir.bmi.api.WrapperFile.string;


import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.exception.IOExcelException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserHeader;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by alotfi on 6/7/2016.
 */
public class TextParserHeader implements ParserHeader {

    private MetaDataObject metaDataObjects;
    private BufferedReader contentFile;
    private StringBuilder result;

    public TextParserHeader(BufferedReader contentFile) {
        this.contentFile = contentFile;
    }

    public TextParserHeader(StringBuilder contentFile, MetaDataObject metaDataObjects) {
        this.result = contentFile;
        this.metaDataObjects = metaDataObjects;
    }

    public ParserHeader getHeader() throws IOExcelException {
//        try {
//            return new WrapperHeader(new TextParserRow(contentFile.readLine(), 0));
//        } catch (IOException e) {
//            throw new IOExcelException("error in parse body", e);
//        }
        return null;
    }

    public void create() {
//        TextParserRow parserRow = new TextParserRow(result, this.metaDataObjects);
//        parserRow.create();
//        result.append(System.getProperty("line.separator"));
    }

    public void parse(MetaDataObject metaDataObject) throws BaseExcelParserException {

    }

    public void create(MetaDataObject metaDataObject) throws BaseExcelParserException {

    }
}
