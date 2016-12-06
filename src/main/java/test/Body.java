package test;

import ir.bmi.api.excelParser.annotation.cell.ColorCell;
import ir.bmi.api.excelParser.annotation.cell.ColorHeader;
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
    @ColorHeader(blue = 100,green = 10,red = 60)
    @ColorCell(blue = 100,green = 10,red = 60)
    private String name;
    @ConvertTo(convertTo = TypeObject.STRING)
    @NotNullValidation()
    @ColorHeader(blue = 100,green = 10,red = 60)
    private String family;
    @ConvertTo(convertTo = TypeObject.Long)
    @ColorHeader(blue = 100,green = 10,red = 60)
    private double old;

    public Body(String name, String family, double old) {
        this.name = name;
        this.family = family;
        this.old = old;
    }

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
