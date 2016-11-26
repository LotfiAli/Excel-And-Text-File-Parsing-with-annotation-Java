package ir.bmi.api.excelParser.base.templateComponent.wrapperFile;



import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.exception.ParserException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 5/25/2016.
 */
public class WrapperFileImpl implements WrapperFile {

    private ParserFile parseFile;
    private List<WrapperSheet> wrapperSheets = new ArrayList<WrapperSheet>();
    private MetaDataObject metaDataObject;

    public WrapperFileImpl(ParserFile parseFile) throws BaseExcelParserException {
        this.parseFile = parseFile;
    }

    public WrapperFileImpl(ParserFile parseFil, MetaDataObject metaDataObject) {
        this.parseFile = parseFil;
        this.metaDataObject = metaDataObject;
    }

    public WrapperSheet getSheetByName(String sheetName) throws ParserException {
        for (WrapperSheet sheet : wrapperSheets) {
            if (sheet.getSheetName().equals(sheetName))
                return sheet;
        }
        throw new IllegalArgumentException("this file was not sheet name" + sheetName, new IllegalArgumentException());
    }

    public void read(MetaDataObject metaDataObject) throws BaseExcelParserException {
        this.wrapperSheets = this.parseFile.parse(metaDataObject);
    }

    public void write() throws BaseExcelParserException {
        this.parseFile.create(metaDataObject);
    }
}
