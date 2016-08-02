package ir.bmi.api.WrapperFile.string;

//import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperRow;

import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserBody;
import ir.bmi.api.excelParser.parserWrapper.ParserRow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 6/6/2016.
 */
public class TextParserBody implements ParserBody {

    private List<MetaDataObject> metaDataObjects;
    private List<ParserRow> bodyRows = new ArrayList<ParserRow>();
    private List<String> contentFile;
    private int index;
    private StringBuilder result;


    public TextParserBody(List<String> contentFile, int indx) {
        this.contentFile = contentFile;
        this.index = indx;
    }

    public TextParserBody(StringBuilder contentFile, List<MetaDataObject> metaDataObjects) {
        this.result = contentFile;
        this.metaDataObjects = metaDataObjects;
    }

//    public List<WrapperRow> getBody() throws IOExcelException {

//        int rowNumber = this.index;
////            contentFile.readLine();
//        for (String sCurrentLine : contentFile) {
//            rowNumber++;
//            bodyRows.add(new WrapperRow(new TextParserRow(sCurrentLine, rowNumber)));
//        }
//        return bodyRows;
//    }

//    public void create() {
////        for (MetaDataObject rows : metaDataObjects) {
////            TextParserRow parserRow = new TextParserRow(result, rows);
////            parserRow.create();
////            result.append(System.getProperty("line.separator"));
////        }
//    }

    public ParserRow getRowBodyByIndex(int i) {
        return bodyRows.get(i);
    }

    public List<ParserRow> getAllRows() {
        return bodyRows;
    }

    public void parse(MetaDataObject metaDataObject) throws BaseExcelParserException {
        int rowNumber = this.index;
        int i = 0;
//            contentFile.readLine();
        for (String sCurrentLine : contentFile) {
            rowNumber++;
            TextParserRow parserRow = new TextParserRow(sCurrentLine, rowNumber);
            parserRow.parse(metaDataObject.getWithIndex(i));
            bodyRows.add(parserRow);
            i++;
        }
//        return bodyRows;

    }

    public void create(MetaDataObject metaDataObject) throws BaseExcelParserException {
        for (MetaDataObject rows : metaDataObjects) {
            TextParserRow parserRow = new TextParserRow(result, rows);
            parserRow.create(rows);
            bodyRows.add(parserRow);
            result.append(System.getProperty("line.separator"));
        }
    }
}
