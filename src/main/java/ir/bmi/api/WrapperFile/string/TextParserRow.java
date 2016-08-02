package ir.bmi.api.WrapperFile.string;

import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserCell;
import ir.bmi.api.excelParser.parserWrapper.ParserRow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 6/6/2016.
 */
public class TextParserRow implements ParserRow {

    List<ParserCell> cellWrappers = new ArrayList<ParserCell>();
    private String row;
    private MetaDataObject metaDataObject;
    private StringBuilder spreadsheet;
    private int rowNumber;

    public TextParserRow(String row, int index) {
        this.row = row;
        this.rowNumber = index;
    }


    public TextParserRow(StringBuilder spreadsheet, MetaDataObject metaDataObject) {
        this.spreadsheet = spreadsheet;
        this.metaDataObject = metaDataObject;
    }

    public int rowNumber() {
        return rowNumber;
    }


    public Object getRowValueString() {
        String result = "";
        for (ParserCell wrapperCell : cellWrappers) {
            result += wrapperCell.getCellValue().toString();
            result += ",";
        }
        return result;
    }

    public ParserCell getCellOfRowById(int i) {
        return cellWrappers.get(i);
    }

    public int getRowNumber() {
        return 0;
    }

    public String getRowData() {
        return null;
    }

    public void parse(MetaDataObject metaDataObject) throws BaseExcelParserException {
        cellWrappers = new ArrayList<ParserCell>();
        String[] cellIterator = row.split(",");
        for (String cellValue : cellIterator) {
            cellWrappers.add(new TextParseCell(cellValue));
        }
    }

    public void create(MetaDataObject metaDataObject) throws BaseExcelParserException {
        cellWrappers = new ArrayList<ParserCell>();
        StringBuilder row = new StringBuilder();
        List<MetaDataObject> metaDataObjects = metaDataObject.getMetaDataObjects();
        for (int i = 0; i <= metaDataObjects.size() - 1; i++) {
            MetaDataObject metaRow = metaDataObjects.get(i);
            TextParseCell cell = new TextParseCell(row);
            cell.create(metaRow);
            if (i < metaDataObjects.size() - 1)
                row.append(",");
        }
        spreadsheet.append(row.toString());
    }
}
