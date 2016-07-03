package test;

import ir.bmi.api.excelParser.annotation.cell.ColorCell;
import ir.bmi.api.excelParser.annotation.column.Column;
import ir.bmi.api.excelParser.annotation.validation.NotNullValidation;

/**
 * Created by alotfi on 5/24/2016.
 */
public class Header {
    @NotNullValidation()
    @ColorCell(blue = 100,green = 10,red = 250)
    private String name;
    @NotNullValidation()
    @ColorCell(blue = 200,green = 150,red = 80)
    private String family;

    public Header() {
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
}
