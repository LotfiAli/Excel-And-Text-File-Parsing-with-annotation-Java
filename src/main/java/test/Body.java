package test;

import ir.bmi.api.excelParser.annotation.cell.*;
import ir.bmi.api.excelParser.annotation.column.ColumnTitel;
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
    @BorderRight(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
    @BorderUp(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
    @BoredrBottom(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
    @BorderLeft(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
    @ColorHeader(blue = 100,green = 10,red = 60)
    @ColumnTitel(TitelName = "نام")
    private String name;
    @ConvertTo(convertTo = TypeObject.STRING)
    @NotNullValidation()
    @ColorHeader(blue = 100,green = 10,red = 60)
    @BorderRight(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
    @BorderUp(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
    @BoredrBottom(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
    @BorderLeft(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
    @ColumnTitel(TitelName = " نام خانوادگی")
    private String family;

    @BorderRight(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
    @BorderUp(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
    @BoredrBottom(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
    @BorderLeft(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
    @ConvertTo(convertTo = TypeObject.Long)
    @ColorHeader(blue = 100,green = 10,red = 60)
    @ColumnTitel(TitelName = "سن")
    private double old;

    @ConvertTo(convertTo = TypeObject.STRING)
    @NotNullValidation()
    @ColorHeader(blue = 100,green = 10,red = 60)
    @BorderRight(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
    @BorderUp(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
    @BoredrBottom(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
    @BorderLeft(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
    @ColumnTitel(TitelName = "فامیلی")
    private String family1;

    @BorderRight(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
    @BorderUp(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
    @BoredrBottom(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
    @BorderLeft(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
    @ConvertTo(convertTo = TypeObject.Long)
    @ColorHeader(blue = 100,green = 10,red = 60)
    @ColorCell(blue = 100,green = 10,red = 60)
    @ColumnTitel(TitelName = "سن واقعی")
    private double old1;


    public Body(String name, String family, double old, String family1, double old1) {
        this.name = name;
        this.family = family;
        this.old = old;
        this.family1 = family1;
        this.old1 = old1;
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

    public String getFamily1() {
        return family1;
    }

    public void setFamily1(String family1) {
        this.family1 = family1;
    }

    public double getOld1() {
        return old1;
    }

    public void setOld1(double old1) {
        this.old1 = old1;
    }
}
