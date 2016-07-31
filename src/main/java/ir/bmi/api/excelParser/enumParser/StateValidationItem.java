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
            attachToText+="در فیلد "+filed;
        switch (errorCode) {
            case 1000:
                return "دمقادیر را پر کنید "+ attachToText;
            case 1001:
                return "خطا در تبدیل دادها "+attachToText;
            case 1002:
                return "مشکل در خوانایی فایل"+attachToText;

        }
        return null;
    }
    public String getTextError() {
       return getTextError(null);
    }
}
