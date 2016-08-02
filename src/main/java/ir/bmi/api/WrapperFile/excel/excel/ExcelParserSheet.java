package ir.bmi.api.WrapperFile.excel.excel;

import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.exception.IOExcelException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created by alotfi on 6/6/2016.
 */
public class ExcelParserSheet implements ParserSheet {

    private XSSFSheet sheet;
    private XSSFWorkbook xssfWorkbook;
    private MetaDataObject metaDataObject;
    private String sheetName;
    private ExcelParserBody wrapperBody;

    public ExcelParserSheet(XSSFWorkbook xssfWorkbook, MetaDataObject metaDataObject) {
        this.xssfWorkbook = xssfWorkbook;
        this.metaDataObject = metaDataObject;
        this.sheetName = metaDataObject.getSheetName();
    }

    public ExcelParserSheet(XSSFSheet sheet) {
        this.sheet = sheet;
    }

//    public WrapperBody getBody() throws IOExcelException {
//
//        wrapperBody = new WrapperBody(new ExcelParserBody(sheet));
//        return wrapperBody;
//    }

    public ExcelParserBody getBody() throws IOExcelException {
        return wrapperBody;
    }

    public String getName() {
        return sheet.getSheetName();
    }

//    public void create() throws IOExcelException {
//        sheet = xssfWorkbook.createSheet(this.sheetName);
//        createHeader();
//        ExcelParserBody parserBody = createBody();
//        wrapperBody = new WrapperBody(parserBody);
//    }

    public String getSheetName() {
        return sheet.getSheetName();
    }

//    private ExcelParserBody createBody() {
//        ExcelParserBody parserBody = new ExcelParserBody(xssfWorkbook, sheet, metaDataObject.getMetaDataObjects());
//        parserBody.create();
//        return parserBody;
//    }

    private void createHeader() {
        ExcelParserHeader parserRow = new ExcelParserHeader(xssfWorkbook, sheet, metaDataObject.getMetaDataObjects());
        parserRow.create();
//        wrapperHeader = new WrapperRow(parserRow);
    }

//    public WrapperHeader getHeader() {
//        Iterator<Row> rowIterator = sheet.iterator();
//        if (rowIterator == null) {
//            throw new IllegalArgumentException();
//        }
//        return new WrapperHeader(new ExcelParserRow(rowIterator.next()));
//    }


    public void parse(MetaDataObject metaDataObject) throws BaseExcelParserException {
        wrapperBody = new ExcelParserBody(sheet);
        wrapperBody.parse(metaDataObject);
    }

    public void create(MetaDataObject metaDataObject) throws BaseExcelParserException {
        sheet = xssfWorkbook.createSheet(this.sheetName);

        ExcelParserHeader parserRow = new ExcelParserHeader(xssfWorkbook, sheet, metaDataObject.getMetaDataObjects());
        parserRow.create(metaDataObject);

        wrapperBody = new ExcelParserBody(xssfWorkbook, sheet, metaDataObject.getMetaDataObjects());
        wrapperBody.create(metaDataObject);

//        sheet = xssfWorkbook.createSheet(this.getSheetName());
//        wrapperBody.setSheet(sheet);
//        wrapperBody.create(metaDataObject);
    }

    public XSSFWorkbook getXssfWorkbook() {
        return xssfWorkbook;
    }

    public void setXssfWorkbook(XSSFWorkbook xssfWorkbook) {
        this.xssfWorkbook = xssfWorkbook;
    }
}
