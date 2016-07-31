package test;

import ir.bmi.api.excelParser.base.ParserManager;
import ir.bmi.api.excelParser.base.ExcelManagerFactory;
import ir.bmi.api.excelParser.model.ResultModel;

/**
 * Created by alotfi on 5/24/2016.
 */
public class Launcher {
    public static void main(String[] args) throws Exception {
        ExcelCall();
//        callFile();

    }

    private static void callFile() throws Exception {
        ParserManager excelManager = ExcelManagerFactory.getFileParserManager("d:\\book2.txt", MessageFile.class);
        ResultModel message = excelManager.deSerialize();

        ParserManager excelManager1 = ExcelManagerFactory.getFileParserManager("d:\\book3.txt", MessageFile.class);
        excelManager1.serialize(message);

        System.out.println(message.getResultModel().toString());



    }

    private static void ExcelCall() throws Exception {
        ParserManager excelManager = ExcelManagerFactory.getExcelParserManager("d:\\Book1.xlsx", MessageExcel.class);
        ResultModel message = excelManager.deSerialize();
        System.out.println(message.getResultModel().toString());

        ParserManager excelManagerSerialize = ExcelManagerFactory.getExcelParserManager("d:\\Book2.xlsx", MessageExcel.class);
        excelManagerSerialize.serialize(message.getResultModel());
    }
}
