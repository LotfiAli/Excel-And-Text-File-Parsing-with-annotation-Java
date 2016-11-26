package ir.bmi.api.excelParser.base.templateComponent.validation;



import ir.bmi.api.excelParser.annotation.validation.LengthValidation;
import ir.bmi.api.excelParser.annotation.validation.TYPE_OPERATION;

import java.lang.annotation.Annotation;

/**
 * Created by alotfi on 11/8/2016.
 */
public class LengthValidationParser extends ValidationBase {

    public static final String FIELD_VALUE_IS_LESS_THAN_THE_LIMIT = "مقدار فیلد کمتر از حد مجاز است";
    private static final String FIELD_VALUE_IS_EXCEEDED = "مقدار فیلد بیش از حد مجاز است";
    private static final String ERROR_IN_LEN = "خطا در طول فیلد";

    private long targetLength;
    private TYPE_OPERATION typeOperation;

    public LengthValidationParser() {
        super(LengthValidation.class);
    }

    public LengthValidationParser(long length, TYPE_OPERATION typeOperation) {
        this.targetLength = length;
        this.typeOperation = typeOperation;
    }

    @Override
    protected String execute(Object value) {
        if (value == null)
            return null;
        int lengthValue = value.toString().length();
        switch (typeOperation) {
            case BIGGER:
                if (lengthValue < targetLength)
                    return FIELD_VALUE_IS_LESS_THAN_THE_LIMIT;
            case SMALLER:
                if (lengthValue > targetLength)
                    return FIELD_VALUE_IS_EXCEEDED;
            case SMALLER_EQUAL:
                if (!(lengthValue <= targetLength))
                    return FIELD_VALUE_IS_EXCEEDED;
                break;
            case BIGGER_EQUAL:
                if (!(lengthValue >= targetLength))
                    return FIELD_VALUE_IS_LESS_THAN_THE_LIMIT;
                break;
            case EQUAL:
                if (!(lengthValue == this.targetLength))
                    return ERROR_IN_LEN;
        }
        return null;
    }


    public ExecuteValidation executeValidation(Annotation annotation) {
        LengthValidation lengthValidation = (LengthValidation) annotation;
        return new LengthValidationParser(lengthValidation.Length(), lengthValidation.TypeOperation());
    }
}
