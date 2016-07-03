package ir.bmi.api.excelParser.base.templateComponent.validation;

/**
 * Created by alotfi on 5/24/2016.
 */
public class NotNullValidation extends ValidationBase {
    @Override
    protected Boolean execute(Object value) {
          return value!=null;
    }
}
