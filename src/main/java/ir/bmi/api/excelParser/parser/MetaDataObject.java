package ir.bmi.api.excelParser.parser;

import ir.bmi.api.excelParser.base.templateComponent.converter.Converter;
import ir.bmi.api.excelParser.base.templateComponent.validation.Validation;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 5/24/2016.
 */
public class MetaDataObject {

    private TypeObject typeObject;
    private List<Validation> validations;
    private Converter converters;
    private Integer column;
    private String sheetName;
    private List<MetaDataObject> metaDataObjects;
    private Boolean isArray;
    private String name;
    private Boolean isComplex;
    private Field field;
    private Class<?> type;
    private Type typeGeneric;
    private Object valuePrimitive;
    private List<List<Object>> complexValue;
    private int blue;
    private int green;
    private int red;
    private int countColumn;
    private String descriptionColumn;


    public MetaDataObject() {
        this.metaDataObjects = new ArrayList<MetaDataObject>();
        this.blue = 250;
        this.green = 250;
        this.red = 250;
    }

    public TypeObject getTypeObject() {
        return typeObject;
    }

    public void setTypeObject(TypeObject typeObject) {
        this.typeObject = typeObject;
    }

    public List<Validation> getValidations() {
        return validations;
    }

    public void setValidations(List<Validation> validations) {
        this.validations = validations;
    }

    public Converter getConverters() {
        return converters;
    }

    public void setConverters(Converter converters) {
        this.converters = converters;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public List<MetaDataObject> getMetaDataObjects() {
        return metaDataObjects;
    }

    public void setMetaDataObjects(List<MetaDataObject> metaDataObjects) {
        this.metaDataObjects = metaDataObjects;
    }

    public Boolean getArray() {
        return isArray;
    }

    public void setArray(Boolean array) {
        isArray = array;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getComplex() {
        return isComplex;
    }

    public void setComplex(Boolean complex) {
        isComplex = complex;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public Type getTypeGeneric() {
        return typeGeneric;
    }

    public void setTypeGeneric(Type typeGeneric) {
        this.typeGeneric = typeGeneric;
    }

    public Object getValuePrimitive() {
        return valuePrimitive;
    }

    public void setValuePrimitive(Object valuePrimitive) {
        this.valuePrimitive = valuePrimitive;
    }

    public List<List<Object>> getComplexValue() {
        return complexValue;
    }

    public void setComplexValue(List<List<Object>> complexValue) {
        this.complexValue = complexValue;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getCountColumn() {
        return countColumn;
    }

    public void setCountColumn(int countColumn) {
        this.countColumn = countColumn;
    }

    public String getDescriptionColumn() {
        return descriptionColumn;
    }

    public void setDescriptionColumn(String descriptionColumn) {
        this.descriptionColumn = descriptionColumn;
    }

    public MetaDataObject getWithIndex(int i){
        return metaDataObjects.get(i);
    }
}
