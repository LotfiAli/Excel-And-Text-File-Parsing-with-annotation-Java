package ir.bmi.api.excelParser.validation;

import ir.bmi.api.excelParser.enumParser.StateValidationItem;

/**
 * Created by alotfi on 7/16/2016.
 */
public class ValidationResultItem {

    private int rowNumber;
    private StateValidationItem code;
    private String detailException;
    private String cellValue;

    public ValidationResultItem() {

    }

    public ValidationResultItem(StateValidationItem code, String detailException) {
        this(code, detailException, null);
    }

    public ValidationResultItem(StateValidationItem code, String detailException, Integer rowNumber) {
        this(code, detailException, rowNumber, null);
    }

    public ValidationResultItem(StateValidationItem code, String detailException, Integer rowNumber, String cellValue) {
        this.code = code;
        this.detailException = detailException;
        this.rowNumber = rowNumber;
        this.cellValue = cellValue;
    }

    public StateValidationItem getCode() {
        return code;
    }

    public void setCode(StateValidationItem code) {
        this.code = code;
    }

    public String getDetailException() {
        return detailException;
    }

    public void setDetailException(String detailException) {
        this.detailException = detailException;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cellValue);
        stringBuilder.append("     ");

        if (code != null) {
            stringBuilder.append(code.getTextError(detailException));
            stringBuilder.append("  ");
        }
        stringBuilder.append(System.getProperty("line.separator"));
        return stringBuilder.toString();
    }
}
