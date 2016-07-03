package ir.bmi.api.excelParser.parserWrapper;

import ir.bmi.api.excelParser.base.templateComponent.wrapperFile.WrapperCell;

import java.util.List;

/**
 * Created by alotfi on 6/6/2016.
 */
public interface ParserRow {
    List<WrapperCell> getCells();
    void create();
}
