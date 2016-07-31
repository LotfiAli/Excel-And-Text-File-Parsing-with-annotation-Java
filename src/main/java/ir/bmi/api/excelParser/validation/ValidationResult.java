package ir.bmi.api.excelParser.validation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 7/16/2016.
 */
public class ValidationResult {
    public static final int ZERO = 0;
    private ArrayList<ValidationResultItem> validationResultItems;

    public ValidationResult() {
        this.validationResultItems = new ArrayList<ValidationResultItem>();
    }

    public List<ValidationResultItem> getValidationResultItems() {
        return validationResultItems;
    }

    public void addItem(ValidationResultItem validationResultItem) {
        validationResultItems.add(validationResultItem);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (ValidationResultItem validationResultItem : validationResultItems) {
            result.append(validationResultItem.toString());
        }
        return result.toString();
    }

    public int count() {
        if (validationResultItems != null)
            return validationResultItems.size();
        return ZERO;
    }
}