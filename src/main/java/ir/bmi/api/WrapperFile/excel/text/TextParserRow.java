package ir.bmi.api.WrapperFile.excel.text;


import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperCell;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserRow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 6/6/2016.
 */
public class TextParserRow implements ParserRow {

    List<WrapperCell> cellWrappers;
    private String row;
    private MetaDataObject metaDataObject;
    private StringBuilder spreadsheet;

    public TextParserRow(String row) {
        this.row = row;
    }

    public TextParserRow(StringBuilder spreadsheet, MetaDataObject metaDataObject) {
        this.spreadsheet = spreadsheet;
        this.metaDataObject = metaDataObject;
    }

    public List<WrapperCell> getCells() {
        cellWrappers = new ArrayList<WrapperCell>();
        String[] cellIterator = row.split(",");
        for (String cellValue : cellIterator) {
            cellWrappers.add(new WrapperCell(new TextParseCell(cellValue)));
        }
        return cellWrappers;
    }

    public void create() {
        cellWrappers = new ArrayList<WrapperCell>();
        StringBuilder row = new StringBuilder();
        List<MetaDataObject> metaDataObjects = metaDataObject.getMetaDataObjects();
        for (int i = 0; i <= metaDataObjects.size() - 1; i++) {
            MetaDataObject cellValue = metaDataObjects.get(i);
            TextParseCell cell = new TextParseCell(row, cellValue);
            cell.create();
            if (i < metaDataObjects.size() - 1)
                row.append(",");
        }
        spreadsheet.append(row.toString());


    }

    public int rowNumber() {
        return 0;
    }

    public Object getRowValueString() {
        return null;
    }
}
