package ir.bmi.api.excelParser.base.templateComponent.converter;

/**
 * Created by alotfi on 5/28/2016.
 */
public class ConvertToLong extends ConverterBase {
    @Override
    protected Object convertToObject(Object value) {
        return Double.parseDouble(value.toString());
    }
}
