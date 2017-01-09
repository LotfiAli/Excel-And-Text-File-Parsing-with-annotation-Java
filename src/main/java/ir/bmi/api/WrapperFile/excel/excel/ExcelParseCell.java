package ir.bmi.api.WrapperFile.excel.excel;


import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.util.GregorianCalendar;

/**
 * Created by alotfi on 6/6/2016.
 */
public class ExcelParseCell implements ParserCell {
    private static final int NORMAL_CELL = 1;

    private Cell cell;
    private XSSFWorkbook xssfWorkbook;
    private Row row;
    private MetaDataObject metaDataObject;
    private Boolean readHeader;
    private int index;
    private XSSFSheet sheet;
    private boolean isHeader;

    public ExcelParseCell(Cell cell) {
        this.cell = cell;
    }

    public ExcelParseCell(XSSFSheet sheet, XSSFWorkbook xssfWorkbook, Row row, MetaDataObject metaDataObject, Boolean readHeader, int index) {

        this(sheet, xssfWorkbook, row, metaDataObject, readHeader, index, false);
    }


    public ExcelParseCell(XSSFSheet sheet, XSSFWorkbook xssfWorkbook, Row row, MetaDataObject metaDataObject, Boolean readHeader, int index, boolean isHeader) {
        this.xssfWorkbook = xssfWorkbook;
        this.row = row;
        this.metaDataObject = metaDataObject;
        this.readHeader = readHeader;
        this.index = index;
        this.sheet = sheet;
        this.isHeader = isHeader;
    }

    public Object getCellValue() {
        if (Cell.CELL_TYPE_NUMERIC == cell.getCellType())
            return cell.getNumericCellValue();
        return cell.getStringCellValue();
    }

    public void create() {
        Cell cell = row.createCell(index);
        setColor(cell);
        if (readHeader)
            cell.setCellValue(metaDataObject.getColumnTitel());
        else {
            if (metaDataObject.getType() == double.class|| metaDataObject.getType() == long.class) {
//                cell.setCellValue(1002515);
                cell.setCellValue(Double.parseDouble(metaDataObject.getValuePrimitive().toString()));
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);

            }else
            cell.setCellValue(metaDataObject.getValuePrimitive().toString());
        }


    }

    private void setColor(Cell cell) {
        XSSFCellStyle style = xssfWorkbook.createCellStyle();
        style.setFillForegroundColor(new XSSFColor(new Color(metaDataObject.getRed(), metaDataObject.getGreen(), metaDataObject.getBlue())));
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);

        style.setAlignment(metaDataObject.getAlign_cell().getValue());

        style.setBorderBottom(metaDataObject.getBorderCellBottom().getValue());
        style.setBorderTop(metaDataObject.getBorderCellTop().getValue());
        style.setBorderLeft(metaDataObject.getBorderCellLeft().getValue());
        style.setBorderRight(metaDataObject.getBorderCellRight().getValue());

        if (metaDataObject.getSpamCell() != NORMAL_CELL) {

            for (int i = metaDataObject.getStartColumn(); i <= metaDataObject.getSpamCell(); ++i) {
                Cell cellRegin = row.createCell(i);
                cellRegin.setCellStyle(style);
            }

            CellRangeAddress region = new CellRangeAddress(
                    metaDataObject.getStartRowIndx(),
                    metaDataObject.getStartRowIndx(), //last row  (0-based)
                    metaDataObject.getStartColumn(), //first column (0-based)
                    metaDataObject.getSpamCell()  //last column  (0-based)
            );
            sheet.addMergedRegion(region);

        }
        if (isHeader)
            style.setFillForegroundColor(new XSSFColor(new Color(metaDataObject.getRedHeader(), metaDataObject.getGreenHeader(), metaDataObject.getBlueHeader())));
        setFormatStyleCell(style);
        cell.setCellStyle(style);
    }

    private void setFormatStyleCell(XSSFCellStyle style) {

        if (metaDataObject.getType() == double.class|| metaDataObject.getType() == long.class) {
            style.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));

        }

//        switch (metaDataObject.getTypeObject()) {
//
//            case COMPLEX:
//                break;
//            case INT:
//                break;
//            case STRING:
////                style.setDataFormat();
//                break;
//            case Boolean:
//                break;
//            case Long:
//                style.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,###"));
//                break;
//            case FLOAT:
//                break;
//        }
    }
}
