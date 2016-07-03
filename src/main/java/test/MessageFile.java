package test;

import ir.bmi.api.excelParser.annotation.sheet.Sheet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 6/8/2016.
 */
public class MessageFile {
//    @Sheet(name = "test")
//    private List<Header> header;
//    @Sheet(name = "test1")
    private List<Body> message;

    public MessageFile() {
//        this.header = new ArrayList<Header>();
        this.message = new ArrayList<Body>();
    }

//    public List<Header> getHeader() {
//        return header;
//    }
//
//    public void setHeader(ArrayList<Header> header) {
//        this.header = header;
//    }

    public List<Body> getMessage() {
        return message;
    }

    public void setMessage(List<Body> message) {
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
        for(Body body:message){
            stringBuilder.append(body.getName()+"              "+body.getFamily()+"             "+body.getOld());
            stringBuilder.append(System.getProperty("line.separator"));
        }
        return stringBuilder.toString();

    }
}
