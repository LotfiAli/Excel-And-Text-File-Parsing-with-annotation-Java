package ir.bmi.api.excelParser.exception;

/**
 * Created by alotfi on 5/28/2016.
 */
public class BaseExcelParserException extends Exception {
    public BaseExcelParserException(String s, Exception e) {
        super(s,e);
    }
}
