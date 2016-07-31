package ir.bmi.api.excelParser.exception;

/**
 * Created by alotfi on 5/28/2016.
 */
public class BaseExcelParserException extends Exception {
    private int rowNumber;
    private String code;
    private String detailException;

    public BaseExcelParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseExcelParserException() {
    }

    public BaseExcelParserException(int rowNumber, String code, String detailException) {
        this(rowNumber,code,detailException,null,null);
    }


    public BaseExcelParserException(int rowNumber, String code, String detailException, String s, Exception e) {
        super(s, e);

        this.rowNumber = rowNumber;
        this.code = code;
        this.detailException = detailException;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetailException() {
        return detailException;
    }

    public void setDetailException(String detailException) {
        this.detailException = detailException;
    }
}
