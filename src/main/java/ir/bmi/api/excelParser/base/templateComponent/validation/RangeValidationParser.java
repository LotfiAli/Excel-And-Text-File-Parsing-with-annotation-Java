package ir.bmi.api.excelParser.base.templateComponent.validation;


import ir.bmi.api.excelParser.annotation.validation.RangeValidation;

import java.lang.annotation.Annotation;

/**
 * Created by alotfi on 11/8/2016.
 */
public class RangeValidationParser extends ValidationBase {

    private static final String ERROR_IN_READ_FILED = "مشکل در خواندن فیلد ";
    private static final String VALUE_IS_NOT_IN_RANGE_MIN_MAX = "value is not in range min ,max";

    private long min;
    private long max;

    public RangeValidationParser() {
        super(RangeValidation.class);
    }

    public RangeValidationParser(long min, long max) {
        this.min = min;
        this.max = max;
    }

    @Override
    protected String execute(Object value) {
        long v;
        try {
            v = Long.parseLong(value.toString());
        } catch (Exception e) {
            return ERROR_IN_READ_FILED;
        }
        if (!(v >= min && v <= max))
            return VALUE_IS_NOT_IN_RANGE_MIN_MAX;
        return "";
    }

    public ExecuteValidation executeValidation(Annotation annotation) {
        RangeValidation rangeValidation = (RangeValidation) annotation;
        return new RangeValidationParser(rangeValidation.Min(), rangeValidation.Max());
    }
}
