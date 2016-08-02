package ir.bmi.api.WrapperFile.excel.excel;

import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by alotfi on 6/6/2016.
 */
public class ExcelParserRow implements ParserRow {

    private List<ExcelParseCell> cellWrappers = new ArrayList<ExcelParseCell>();
    private Row row;
    private MetaDataObject metaDataObject;
    private XSSFWorkbook xssfWorkbook;
    private XSSFSheet sheet;
    private int index;

    public ExcelParserRow(Row row) {
        this.row = row;
    }

    public ExcelParserRow(XSSFWorkbook xssfWorkbook, XSSFSheet spreadsheet, MetaDataObject metaDataObject, int index) {
        this.xssfWorkbook = xssfWorkbook;
        this.sheet = spreadsheet;
        this.index = index;
        this.metaDataObject = metaDataObject;
    }

//    public List<WrapperCell> getCells() {
//        cellWrappers = new ArrayList<WrapperCell>();
//        Iterator<Cell> cellIterator = row.iterator();
//        while (cellIterator.hasNext()) {
//            Cell cell = cellIterator.next();
//            cellWrappers.add(new WrapperCell(new ir.bmi.api.WrapperFile.excel.ExcelParseCell(cell)));
//        }
//        return cellWrappers;
//    }

//    public void create() {
//        cellWrappers = new ArrayList<WrapperCell>();
//        Row row = this.spreadsheet.createRow(this.index);
//        int point = 0;
//        for (MetaDataObject cellValue : metaDataObject.getMetaDataObjects()) {
//            ir.bmi.api.WrapperFile.excel.ExcelParseCell cell = new ir.bmi.api.WrapperFile.excel.ExcelParseCell(xssfWorkbook, row, cellValue, false, point++);
//            cell.create();
//        }

//    }

    //    @Override
    public int rowNumber() {
        return 0;
    }

    //    @Override
    public Object getRowValueString() {
        String result = "";
        for (ExcelParseCell wrapperCell : cellWrappers) {
            result += wrapperCell.getCellValue().toString();
            result += ",";
        }
        return result;
    }

    public ExcelParseCell getCellOfRowById(int i) {
        return cellWrappers.get(index);
    }

    public int getRowNumber() {
        return 0;
    }

    public String getRowData() {
        return "";
    }

    public void parse(MetaDataObject metaDataObject) throws BaseExcelParserException {
        Iterator<Cell> cellIterator = row.iterator();
        int i = 0;
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            ExcelParseCell excelParseCell = new ExcelParseCell(cell);
            excelParseCell.parse(metaDataObject.getWithIndex(i));
            cellWrappers.add(excelParseCell);
            i++;
        }
    }

    public void create(MetaDataObject metaDataObject) throws BaseExcelParserException {

//        cellWrappers = new ArrayList<WrapperCell>();
        Row row = this.sheet.createRow(this.index);
        int point = 0;
        for (MetaDataObject metaObject : metaDataObject.getMetaDataObjects()) {
            ExcelParseCell cell = new ExcelParseCell(xssfWorkbook, row, metaObject, false, point++);
            cell.create(metaObject);
            cellWrappers.add(cell);

        }
    }

//    public XSSFSheet getSheet() {
//        return sheet;
//    }
//
//    public void setSheet(XSSFSheet sheet) {
//        this.sheet = sheet;
//    }
}
