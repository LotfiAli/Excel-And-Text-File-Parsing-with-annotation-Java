package ir.bmi.api.excelParser.enumParser;

/**
 * Created by alotfi on 7/19/2016.
 */
public enum StateValidationItem {
    VALIDATION_ERROR(1000),
    CONVERTER_ERROR(1001),
    READ_FIELD_ERROR(1002);

    private int errorCode;

    StateValidationItem(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getTextError(String filed) {
        String attachToText="";
        if (filed!=null)
            attachToText+="on field "+filed;
        switch (errorCode) {
            case 1000:
                return "Value not be empty"+ attachToText;
            case 1001:
                return "convert error Data"+attachToText;
            case 1002:
                return "error  in read data"+attachToText;

        }
        return null;
    }
    public String getTextError() {
       return getTextError(null);
    }
}
