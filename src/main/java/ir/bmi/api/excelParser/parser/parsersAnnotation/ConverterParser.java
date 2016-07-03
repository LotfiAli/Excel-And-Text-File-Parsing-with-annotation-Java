package ir.bmi.api.excelParser.parser.parsersAnnotation;

import ir.bmi.api.excelParser.annotation.converter.ConvertTo;
import ir.bmi.api.excelParser.base.templateComponent.converter.Converter;
import ir.bmi.api.excelParser.base.templateComponent.converter.ConvertToLong;
import ir.bmi.api.excelParser.base.templateComponent.converter.ConverterToString;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parser.TypeObject;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * Created by alotfi on 5/24/2016.
 */
public class ConverterParser extends CollectionValidationBase<Converter> {

    @Override
    protected void addToMetaDataObject(List<Converter> parsers, MetaDataObject metaDataObject) {
        if (parsers.size() == 1)
            metaDataObject.setConverters(parsers.get(0));
    }

    @Override
    protected Converter createParseForAnnotation(Annotation annotation) {
        ConvertTo convertTo = (ConvertTo) annotation;
        return createConverter(annotation, convertTo != null ? convertTo.convertTo() : null);
    }

    @Override
    protected Boolean checkConstraintAnnotation(Annotation annotation) {
        String annotationName = getNameAnnotation(annotation);
        return (annotationName.contains("Convert"));
    }

    private Converter createConverter(Annotation annotation, TypeObject typeObject) {
        String annotationName = getNameAnnotation(annotation);
        if (annotationName.contains("ConvertTo"))
            switch (typeObject) {
                case COMPLEX:
                    break;
                case INT:
                    return new ConvertToLong();
                case STRING:
                    return new ConverterToString();
                case Boolean:
                    break;
            }
        return null;
    }
}
