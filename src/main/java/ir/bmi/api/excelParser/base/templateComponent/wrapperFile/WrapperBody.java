package ir.bmi.api.excelParser.base.templateComponent.wrapperFile;

import ir.bmi.api.excelParser.exception.IOExcelException;
import ir.bmi.api.excelParser.parserWrapper.ParserBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 5/25/2016.
 */
public class WrapperBody  {
    private List<WrapperRow> bodyRows = new ArrayList<WrapperRow>();
    private ParserBody parserBody;

    public WrapperBody(ParserBody parserBody) throws IOExcelException {
        this.parserBody = parserBody;
        read();
    }

    private void initializeBodySheet() throws IOExcelException {
        this.bodyRows = parserBody.getBody();
    }

    public WrapperRow getRowBodyByIndex(int index) {
        return bodyRows.get(index);
    }

    public List<WrapperRow> getAllRows() {
        return bodyRows;
    }

    public void read() throws IOExcelException {
        initializeBodySheet();
    }
}
