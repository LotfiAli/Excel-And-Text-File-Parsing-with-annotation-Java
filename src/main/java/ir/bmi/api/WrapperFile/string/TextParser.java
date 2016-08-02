package ir.bmi.api.WrapperFile.string;


import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.exception.IOExcelException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserFile;
import ir.bmi.api.excelParser.parserWrapper.ParserSheet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 6/5/2016.
 */
public class TextParser implements ParserFile {

    public static final int ALL_CONTENT = 0;
    private List<ParserSheet> wrapperSheetses = new ArrayList<ParserSheet>();
    private ArrayList<String> salary;
    private String fileName;

    public TextParser(String fileName) throws BaseExcelParserException, IOException {
        this.fileName = fileName;
    }

    private void readContentFile() throws BaseExcelParserException, IOException {
        ArrayList<String> lineFiles = new ArrayList<String>();
        BufferedReader bufferedReader = readFile(fileName);
        String sCurrentLine;

        while ((sCurrentLine = bufferedReader.readLine()) != null) {
            lineFiles.add(sCurrentLine);
        }
        this.salary = lineFiles;
    }

    public TextParser(ArrayList<String> data) {
        this.salary = data;
    }


    public static TextParser createSerializeStringParser(String fileName) throws BaseExcelParserException, IOException {
        return new TextParser(fileName);
    }

    public TextParser() {
    }

    public static TextParser createDeSerializeParser(String fileName) throws BaseExcelParserException, IOException {
        TextParser stringParser = new TextParser(fileName);
        stringParser.readContentFile();
        return stringParser;
    }

    private List<String> getDataSheet(ArrayList<String> contentFile, int count) {
        if (count == ALL_CONTENT) return contentFile;
        ArrayList<String> resultList = new ArrayList<String>();
        for (int i = 0; i <= count - 1; i++) {
            resultList.add(contentFile.remove(i));
        }
        return resultList;
    }

    public void parse(MetaDataObject metaDataObject) throws BaseExcelParserException {
        int rowIndex = 0;
        for (MetaDataObject metaData : metaDataObject.getMetaDataObjects()) {
            TextParserSheet parserSheet = new TextParserSheet(getDataSheet(salary, metaData.getCountColumn()), rowIndex);
            rowIndex += metaData.getCountColumn();
            parserSheet.setSheetName(metaData.getSheetName());
            parserSheet.parse(metaDataObject);
            wrapperSheetses.add(parserSheet);
        }

    }

    public void create(MetaDataObject metaDataObject) throws BaseExcelParserException {
        StringBuilder contentFile = new StringBuilder();
        for (MetaDataObject metaData : metaDataObject.getMetaDataObjects()) {
            TextParserSheet parserSheet = new TextParserSheet(contentFile, metaData);
            parserSheet.create(metaData);
        }
        createFile(contentFile.toString());
    }

    private void createFile(String content) throws IOExcelException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            File file = new File(this.fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            throw new IOExcelException("Error In Write File " + salary, e);
        }
    }

    private BufferedReader readFile(String pathFile) throws BaseExcelParserException {
        FileInputStream fis = null;
        try {
            return new BufferedReader(new FileReader(pathFile));

        } catch (Exception e) {
            throw new IOExcelException("error in read file excel from path" + pathFile, e);
        }
    }

    public ParserSheet getSheetByName(String sheetName) {
        for (ParserSheet wrapperSheet : wrapperSheetses) {
            if (wrapperSheet.getName().equals(sheetName))
                return wrapperSheet;
        }
        throw new IllegalArgumentException();
    }
}
