package ir.bmi.api.excelParser.base.templateComponent.converter;

import ir.bmi.api.excelParser.base.templateComponent.converter.Converter;

/**
 * Created by alotfi on 5/24/2016.
 */
public abstract class ConverterBase implements Converter {

    protected abstract Object convertToObject(Object value);

    public Object convertTo(Object value) {
        return convertToObject(value);
    }
}
