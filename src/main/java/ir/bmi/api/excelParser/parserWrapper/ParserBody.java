package ir.bmi.api.excelParser.parserWrapper;

import ir.bmi.api.excelParser.exception.IOExcelException;

import java.io.IOException;
import java.util.List;

/**
 * Created by alotfi on 6/6/2016.
 */
public interface ParserBody extends ParserComponent {
    ParserRow getRowBodyByIndex(int i);

    List<ParserRow> getAllRows();
//    List<WrapperRow> getBody() throws IOExcelException;
//    void create();
}
