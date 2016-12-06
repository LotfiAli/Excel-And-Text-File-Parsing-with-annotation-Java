package ir.bmi.api.WrapperFile.excel.excel;


import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperHeader;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserHeader;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Iterator;
import java.util.List;

/**
 * Created by alotfi on 6/7/2016.
 */
public class ExcelParserHeader implements ParserHeader {
    private Row row;
    private XSSFWorkbook xssfWorkbook;
    private XSSFSheet sheet;
    private List<MetaDataObject> metaDataObjects;
    private int indexRow;

    public ExcelParserHeader(XSSFWorkbook xssfWorkbook, XSSFSheet sheet, List<MetaDataObject> metaDataObjects, int indexRow) {
        this.xssfWorkbook = xssfWorkbook;
        this.sheet = sheet;
        this.metaDataObjects = metaDataObjects;
        this.indexRow = indexRow;
    }

    public ExcelParserHeader(Row row) {
        this.row = row;
    }

    public WrapperHeader getHeader() {
        Iterator<Row> rowIterator = sheet.iterator();
        if (rowIterator == null) {
            throw new IllegalArgumentException();
        }
        ExcelParserRow excelParserRow = new ExcelParserRow(rowIterator.next());
        return new WrapperHeader(excelParserRow);
    }

    public void create() {
        Row row = sheet.createRow(indexRow);
        int indexColumn = 0;
        List<MetaDataObject> metaDataObjects = this.metaDataObjects.get(0).getMetaDataObjects();
        for (MetaDataObject metaDataObject : metaDataObjects) {
            ExcelParseCell cell = new ExcelParseCell(sheet, xssfWorkbook, row, metaDataObject, true, indexColumn++,true);
            cell.create();
        }
    }
}
