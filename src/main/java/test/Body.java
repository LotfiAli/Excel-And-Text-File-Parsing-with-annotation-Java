package test;

import ir.bmi.api.excelParser.annotation.converter.ConvertTo;
import ir.bmi.api.excelParser.annotation.sheet.Sheet;
import ir.bmi.api.excelParser.annotation.validation.NotNullValidation;
import ir.bmi.api.excelParser.parser.TypeObject;

import java.util.List;

/**
 * Created by alotfi on 5/24/2016.
 */
public class Body {
    @ConvertTo(convertTo = TypeObject.STRING)
    @NotNullValidation()
    private String name;
    @ConvertTo(convertTo = TypeObject.STRING)
    @NotNullValidation()
    private String family;
    @ConvertTo(convertTo = TypeObject.Long)
    private double old;

    public Body() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public double getOld() {
        return old;
    }

    public void setOld(double old) {
        this.old = old;
    }
}
