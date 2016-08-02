package ir.bmi.api.WrapperFile.excel.excel;

import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserBody;
import ir.bmi.api.excelParser.parserWrapper.ParserRow;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by alotfi on 6/6/2016.
 */
public class ExcelParserBody implements ParserBody {

    private XSSFWorkbook xssfWorkbook;
    private XSSFSheet sheet;
    private List<MetaDataObject> metaDataObjects;
    private List<ParserRow> bodyRows = new ArrayList<ParserRow>();

    public ExcelParserBody(XSSFSheet sheet) {
        this.sheet = sheet;
    }

    public ExcelParserBody(XSSFWorkbook xssfWorkbook, XSSFSheet sheet, List<MetaDataObject> metaDataObjects) {
        this.xssfWorkbook = xssfWorkbook;
        this.sheet = sheet;
        this.metaDataObjects = metaDataObjects;
    }

//    public List<WrapperRow> getBody() {
//        List<WrapperRow> bodyRows = new ArrayList<WrapperRow>();
//        Iterator<Row> rowIterator = sheet.iterator();
//        rowIterator.next();//For Header Sheet
//        while (rowIterator.hasNext())
//            bodyRows.add(new WrapperRow(new ExcelParserRow(rowIterator.next())));
//        return bodyRows;
//    }

//    public void create() {
////        List<WrapperRow> bodyRows = new ArrayList<WrapperRow>();
//        int index = 1;
//        for (MetaDataObject rows : metaDataObjects) {
//            ExcelParserRow parserRow = new ExcelParserRow(xssfWorkbook, sheet, rows, index++);
//            parserRow.create();
////            bodyRows.add(new WrapperRow(parserRow));
//        }
//    }

    public void parse(MetaDataObject metaDataObject) throws BaseExcelParserException {
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();//For Header Sheet
        int i = 0;
        while (rowIterator.hasNext()) {
            ExcelParserRow excelParserRow = new ExcelParserRow(rowIterator.next());
            excelParserRow.parse(metaDataObject);
            bodyRows.add(excelParserRow);
            i++;
        }

    }

    public void create(MetaDataObject metaDataObject) throws BaseExcelParserException {

        int index = 1;
        for (MetaDataObject metaData : metaDataObjects) {
            ExcelParserRow parserRow = new ExcelParserRow(xssfWorkbook, sheet, metaData, index++);
            parserRow.create(metaData);
            bodyRows.add(parserRow);
        }

//        for (ParserRow rows : bodyRows) {
//            ExcelParserRow rowCast=(ExcelParserRow)rows;
//            rowCast.setSheet(sheet);
//            rowCast.create(metaDataObject);
//        }
    }

    public ParserRow getRowBodyByIndex(int i) {
        return bodyRows.get(i);
    }

    public List<ParserRow> getAllRows() {
        return bodyRows;
    }

//    public XSSFSheet getSheet() {
//        return sheet;
//    }
//
//    public void setSheet(XSSFSheet sheet) {
//        this.sheet = sheet;
//    }
}
