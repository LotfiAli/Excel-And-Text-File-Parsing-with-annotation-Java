package ir.bmi.api.WrapperFile.excel;

import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperCell;
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

    List<WrapperCell> cellWrappers;
    private Row row;
    private MetaDataObject metaDataObject;
    private XSSFWorkbook xssfWorkbook;
    private XSSFSheet spreadsheet;
    private int index;

    public ExcelParserRow(Row row) {
        this.row = row;
    }

    public ExcelParserRow(XSSFWorkbook xssfWorkbook, XSSFSheet spreadsheet, MetaDataObject metaDataObject, int index) {
        this.xssfWorkbook = xssfWorkbook;
        this.spreadsheet = spreadsheet;
        this.index = index;
        this.metaDataObject = metaDataObject;
    }

    public List<WrapperCell> getCells() {
        cellWrappers = new ArrayList<WrapperCell>();
        Iterator<Cell> cellIterator = row.iterator();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            cellWrappers.add(new WrapperCell(new ExcelParseCell(cell)));
        }
        return cellWrappers;
    }

    public void create() {
        cellWrappers = new ArrayList<WrapperCell>();
        Row row = this.spreadsheet.createRow(this.index);
        int point = 0;
        for (MetaDataObject cellValue : metaDataObject.getMetaDataObjects()) {
            ExcelParseCell cell = new ExcelParseCell(xssfWorkbook,row, cellValue, false, point++);
            cell.create();
//            cellWrappers.add(new WrapperCell(cell));
        }

    }
}
