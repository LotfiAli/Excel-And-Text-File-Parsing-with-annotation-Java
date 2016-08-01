package test;

import ir.bmi.api.excelParser.annotation.column.CountColumn;
import ir.bmi.api.excelParser.annotation.column.DescriptionColumn;
import ir.bmi.api.excelParser.annotation.sheet.Sheet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 6/8/2016.
 */
public class MessageFile {
    @DescriptionColumn(description = "test")
    @CountColumn(count = 1)
    private HeaderString header;
    //    @Sheet(name = "test1")
    @DescriptionColumn(description = "test1")
    @CountColumn(count = 0)
    private List<BodyString> message;

    public MessageFile() {
//        this.header = new ArrayList<Header>();
        this.message = new ArrayList<BodyString>();
        this. header=new HeaderString();
    }

//    public List<Header> getHeader() {
//        return header;
//    }
//
//    public void setHeader(ArrayList<Header> header) {
//        this.header = header;
//    }

    public List<BodyString> getMessage() {
        return message;
    }

    public void setMessage(List<BodyString> message) {
        this.message = message;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("************sheet 1**************");
        stringBuilder.append(System.getProperty("line.separator"));
//        for (Header h : header) {
//            stringBuilder.append(h.getName() + "              " + h.getFamily());
//            stringBuilder.append(System.getProperty("line.separator"));
//        }
        stringBuilder.append("************sheet2******************");
        stringBuilder.append(System.getProperty("line.separator"));
        for(BodyString body:message){
            stringBuilder.append(body.toString());
            stringBuilder.append(System.getProperty("line.separator"));
        }
        return stringBuilder.toString();

    }
}
