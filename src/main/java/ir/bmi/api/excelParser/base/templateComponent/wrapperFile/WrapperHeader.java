package ir.bmi.api.excelParser.base.templateComponent.wrapperFile;



import ir.bmi.api.excelParser.parserWrapper.ParserRow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 6/7/2016.
 */
public class WrapperHeader {
    private List<WrapperCell> headerRow = new ArrayList<WrapperCell>();
    private ParserRow parserHeader;

    public WrapperHeader(ParserRow excelParserRow) {
        this.parserHeader = excelParserRow;
        read();
    }

    private void read() {
        headerRow = this.parserHeader.getCells();
    }

    public List<WrapperCell> getHeaders() {
        return headerRow;
    }


}
