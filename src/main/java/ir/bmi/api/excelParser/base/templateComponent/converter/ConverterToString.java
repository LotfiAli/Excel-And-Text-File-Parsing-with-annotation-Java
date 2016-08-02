package ir.bmi.api.excelParser.base.templateComponent.converter;

/**
 * Created by alotfi on 5/24/2016.
 */
public class ConverterToString extends ConverterBase {
    @Override
    protected Object convertToObject(Object value) {
        return value.toString();
    }
}
