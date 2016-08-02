package ir.bmi.api.WrapperFile.excel.excel;

import ir.bmi.api.excelParser.exception.BaseExcelParserException;
import ir.bmi.api.excelParser.exception.IOExcelException;
import ir.bmi.api.excelParser.parser.MetaDataObject;
import ir.bmi.api.excelParser.parserWrapper.ParserFile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 6/5/2016.
 */
public class ExcelParser implements ParserFile {

    private List<ExcelParserSheet> wrapperSheetses = new ArrayList<ExcelParserSheet>();
    private String fileName;

    public ExcelParser(String fileName) {
        this.fileName = fileName;
    }

    public void parse(MetaDataObject metaDataObject) throws BaseExcelParserException {
        XSSFWorkbook xssfSheets = readFile(fileName);
        for (int i = 0; i < xssfSheets.getNumberOfSheets(); i++) {
            XSSFSheet sheet = xssfSheets.getSheetAt(i);
            ExcelParserSheet excelParserSheet = new ExcelParserSheet(sheet);
            excelParserSheet.parse(metaDataObject.getWithIndex(i));
            wrapperSheetses.add(excelParserSheet);
        }
    }

    public void create(MetaDataObject metaDataObject) throws BaseExcelParserException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        int i = 0;
//        for(ExcelParserSheet excelParserSheet:wrapperSheetses){
//            excelParserSheet.setXssfWorkbook(workbook);
//            excelParserSheet.create(metaDataObject.getWithIndex(i));
//            i++;
//        }

        for (MetaDataObject metaData : metaDataObject.getMetaDataObjects()) {
            ExcelParserSheet parserSheet = new ExcelParserSheet(workbook, metaData);
            parserSheet.create(metaDataObject.getWithIndex(i));
            wrapperSheetses.add(parserSheet);
            i++;
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(new File(fileName));
            workbook.write(out);
        } catch (FileNotFoundException e) {
            throw new IOExcelException("error create Excel File", e);
        } catch (IOException e) {
            throw new IOExcelException("error create Excel File", e);
        }

    }

    private XSSFWorkbook readFile(String pathFile) throws BaseExcelParserException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File(pathFile));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            return workbook;

        } catch (Exception e) {
            throw new IOExcelException("error in read file excel from path" + pathFile, e);
        }
    }

    public ExcelParserSheet getSheetByName(String sheetName) {
        for (ExcelParserSheet wrapperSheet : wrapperSheetses) {
            if (wrapperSheet.getName().equals(sheetName))
                return wrapperSheet;
        }
        throw new IllegalArgumentException();
    }
}
