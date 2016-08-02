package ir.bmi.api.WrapperFile.excel.excel;


import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserHeader;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

/**
 * Created by alotfi on 6/7/2016.
 */
public class ExcelParserHeader implements ParserHeader {
    private Row row;
    private XSSFWorkbook xssfWorkbook;
    private XSSFSheet sheet;
    private List<MetaDataObject> metaDataObjects;

    public ExcelParserHeader(XSSFWorkbook xssfWorkbook, XSSFSheet sheet, List<MetaDataObject> metaDataObjects) {
        this.xssfWorkbook = xssfWorkbook;
        this.sheet = sheet;
        this.metaDataObjects = metaDataObjects;
    }

    public ParserHeader getHeader() {
//        Iterator<Row> rowIterator = sheet.iterator();
//        if (rowIterator == null) {
//            throw new IllegalArgumentException();
//        }
//        ExcelParserRow excelParserRow = new ExcelParserRow(rowIterator.next());
//        return new ParserHeader(excelParserRow);
        return null;
    }

    public void create() {
//        Row row = sheet.createRow(0);
//        int index = 0;
//        List<MetaDataObject> metaDataObjects = this.metaDataObjects.get(0).getMetaDataObjects();
//        for (MetaDataObject metaDataObject : metaDataObjects) {
//            ir.bmi.api.WrapperFile.excel.ExcelParseCell cell = new ir.bmi.api.WrapperFile.excel.ExcelParseCell(xssfWorkbook,row,metaDataObject, true, index++);
//            cell.create();
//        }
    }

    public void parse(MetaDataObject metaDataObject) throws BaseExcelParserException {

    }

    public void create(MetaDataObject metaDataObject) throws BaseExcelParserException {
        Row row = sheet.createRow(0);
        int index = 0;
        List<MetaDataObject> metaDataObjects = this.metaDataObjects.get(0).getMetaDataObjects();
        for (MetaDataObject metaDataO : metaDataObjects) {
            ExcelParseCell cell = new ExcelParseCell(xssfWorkbook, row, metaDataObject, true, index++);
            cell.create(metaDataO);
        }
    }
}
