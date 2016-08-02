package ir.bmi.api.excelParser.base.templateComponent.converter;

/**
 * Created by alotfi on 7/12/2016.
 */
public class ConvertToInt extends ConverterBase {
    @Override
    protected Object convertToObject(Object value) {

        return Integer.parseInt(value.toString());
    }
}
