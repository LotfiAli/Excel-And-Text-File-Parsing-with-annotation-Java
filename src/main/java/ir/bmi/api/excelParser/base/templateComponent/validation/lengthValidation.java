package ir.bmi.api.excelParser.base.templateComponent.validation;

/**
 * Created by alotfi on 8/2/2016.
 */
public class lengthValidation extends ValidationBase {

    private int minLength = 0;
    private int maxLentght = 1024;

    @Override
    protected Boolean execute(Object value) {
        if (value == null)
            return false;
        int length = value.toString().length();
        if (length >= minLength && length <= maxLentght)
            return true;
        return false;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getMaxLentght() {
        return maxLentght;
    }

    public void setMaxLentght(int maxLentght) {
        this.maxLentght = maxLentght;
    }
}
