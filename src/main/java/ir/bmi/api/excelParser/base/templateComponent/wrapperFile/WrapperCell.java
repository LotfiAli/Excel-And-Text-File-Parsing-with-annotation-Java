package ir.bmi.api.excelParser.base.templateComponent.wrapperFile;

import ir.bmi.api.excelParser.parserWrapper.ParserCell;

/**
 * Created by alotfi on 5/25/2016.
 */
public class WrapperCell {

    private ParserCell cell;

    public WrapperCell(ParserCell cell) {
        this.cell = cell;
    }

    public Object getCellValue() {
        if (cell != null)
            return cell.getCellValue();
        return null;
    }

    public void read() {

    }

   }
