package ir.bmi.api.excelParser.base.templateComponent.validation;


import ir.bmi.api.excelParser.annotation.validation.AccountValidation;

import java.lang.annotation.Annotation;

/**
 * Created by alotfi on 11/19/2016.
 */
public class AccountValidationParser extends ValidationBase {

    public static final String ACCOUNT_NUMBER_IS_NOT_VALID = "شماره حساب اشتباه است";

    public AccountValidationParser() {
        super(AccountValidation.class);
    }


    //I do not know what the code logic. I got a copy of the Other,I Refactor This Code
    @Override
    protected String execute(Object value) {
        if (value == null || "".equals(value.toString()))
            return "value can not be null";
        int n = 0;
        int p = 0;
        int m = 0;
        String strAcc = value.toString();
        if (strAcc.length() != 13) {
            return ACCOUNT_NUMBER_IS_NOT_VALID;
        }
        n = calculateDigit(strAcc);
        m = n % 11;
        if (m == 1)
            return ACCOUNT_NUMBER_IS_NOT_VALID;
        p = 11 - m;
        int intCheckDigit = p == 11 ? 0 : p;
        if (intCheckDigit != Integer.parseInt(strAcc.substring(12))) {
            return ACCOUNT_NUMBER_IS_NOT_VALID;
        }
        return null;
    }

    private int calculateDigit(String strAcc) {
        int eleven = sunString(strAcc, 11, 1) * 5;
        int ten = sunString(strAcc, 10, 1) * 7;
        int nine = sunString(strAcc, 9, 1) * 13;
        int eight = sunString(strAcc, 8, 1) * 17;
        int seven = sunString(strAcc, 7, 1) * 19;
        int six = sunString(strAcc, 6, 1) * 23;
        int five = sunString(strAcc, 5, 1) * 29;
        int four = sunString(strAcc, 4, 1) * 31;
        int three = sunString(strAcc, 3, 1) * 37;
        int two = sunString(strAcc, 2, 1) * 41;
        int one = sunString(strAcc, 1, 1) * 43;
        int zero = sunString(strAcc, 0, 1) * 47;
        return eleven + ten + nine + eight + seven + six + five + four + three + two + one + zero;
    }

    private int sunString(String strAcc, int start, int len) {
        String subS = strAcc.substring(start, start + len);
        return Integer.parseInt(subS);
    }

    public ExecuteValidation executeValidation(Annotation annotation) {
        return new AccountValidationParser();
    }
}
