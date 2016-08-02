package ir.bmi.api.WrapperFile.excel.excel;

import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;

/**
 * Created by alotfi on 6/6/2016.
 */
public class ExcelParseCell implements ParserCell {
    private Cell cell;
    private XSSFWorkbook xssfWorkbook;
    private Row row;
    private MetaDataObject metaDataObject;
    private Boolean readHeader;
    private int index;

    public ExcelParseCell(Cell cell) {
        this.cell = cell;
    }

    public ExcelParseCell(XSSFWorkbook xssfWorkbook, Row row, MetaDataObject metaDataObject, Boolean readHeader, int index) {
        this.xssfWorkbook = xssfWorkbook;
        this.row = row;
        this.metaDataObject = metaDataObject;
        this.readHeader = readHeader;
        this.index = index;
    }

    public Object getCellValue() {
        if (Cell.CELL_TYPE_NUMERIC == cell.getCellType())
            return cell.getNumericCellValue();
        return cell.getStringCellValue();
    }
//
//    public void create() {
//        Cell cell = row.createCell(index);
//        setColor(cell);
//        if (readHeader)
//            cell.setCellValue(metaDataObject.getName());
//        else
//            cell.setCellValue(metaDataObject.getValuePrimitive().toString());
//    }

    private void setColor(Cell cell) {
        XSSFCellStyle style = xssfWorkbook.createCellStyle();
        style.setFillForegroundColor(new XSSFColor(new java.awt.Color(metaDataObject.getRed(), metaDataObject.getGreen(), metaDataObject.getBlue())));
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell.setCellStyle(style);
    }

    public void parse(MetaDataObject metaDataObject) throws BaseExcelParserException {

    }

    public void create(MetaDataObject metaDataObject) throws BaseExcelParserException {
        Cell cell = row.createCell(index);
        setColor(cell);
        if (readHeader)
            cell.setCellValue(metaDataObject.getName());
        else
            cell.setCellValue(metaDataObject.getValuePrimitive().toString());
    }

    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }
}
