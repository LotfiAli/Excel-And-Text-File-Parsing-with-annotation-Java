package test;

import ir.bmi.api.WrapperFile.string.TextParser;
import ir.bmi.api.excelParser.base.ExcelManagerFactory;
import ir.bmi.api.excelParser.base.ParserManager;
import ir.bmi.api.excelParser.model.ResultModel;

/**
 * Created by alotfi on 5/24/2016.
 */
public class Launcher {
    public static void main(String[] args) throws Exception {
        ExcelCall();
        callFile();
    }

    private static void callFile() throws Exception {
        ParserManager excelManager = ExcelManagerFactory.getParserManager(MessageFile.class, TextParser.createDeSerializeParser("d:\\book2.txt"));
        ResultModel message = excelManager.deSerialize();
        System.out.println(message.getResultModel().toString());

        ParserManager excelManager1 = ExcelManagerFactory.getParserManager(MessageFile.class, TextParser.createSerializeStringParser("d:\\book3.txt"));
        excelManager1.serialize(message.getResultModel());

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
