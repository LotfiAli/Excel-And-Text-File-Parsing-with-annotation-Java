package ir.bmi.api.WrapperFile.text;

import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperRow;
import ir.bmi.api.excelParser.exception.IOExcelException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserBody;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by alotfi on 6/6/2016.
 */
public class TextParserBody implements ParserBody {

    private List<MetaDataObject> metaDataObjects;
    private BufferedReader contentFile;
    private StringBuilder result;


    public TextParserBody(BufferedReader contentFile) {
        this.contentFile = contentFile;
    }

    public TextParserBody(StringBuilder contentFile, List<MetaDataObject> metaDataObjects) {
        this.result = contentFile;
        this.metaDataObjects = metaDataObjects;
    }

    public List<WrapperRow> getBody() throws IOExcelException {
        List<WrapperRow> bodyRows = new ArrayList<WrapperRow>();
        String sCurrentLine;

        try {
            while ((sCurrentLine = contentFile.readLine()) != null) {
                bodyRows.add(new WrapperRow(new TextParserRow(sCurrentLine)));
            }
        } catch (IOException e) {
            throw new IOExcelException("error in parse body", e);
        }
        return bodyRows;
    }

    public void create() {
        for (MetaDataObject rows : metaDataObjects) {
            TextParserRow parserRow = new TextParserRow(result, rows);
            parserRow.create();
            result.append(System.getProperty("line.separator"));
        }
    }
}
