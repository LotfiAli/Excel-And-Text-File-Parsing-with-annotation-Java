package ir.bmi.api.excelParser.base.templateComponent.converter;

/**
 * Created by alotfi on 7/20/2016.
 */
public class ConvertToFloat extends ConverterBase {
    @Override
    protected Object convertToObject(Object value) {

        return Float.parseFloat(value.toString());
    }
}
