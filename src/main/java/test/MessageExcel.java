package test;

import ir.bmi.api.excelParser.annotation.sheet.Sheet;
import ir.bmi.api.excelParser.annotation.validation.NotNullValidation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 5/24/2016.
 */
public class MessageExcel {
    @Sheet(name = "test")
    private Header header;
    @Sheet(name = "test1")
    private List<Body> message;

    public MessageExcel() {
        this.header = new Header();
        this.message = new ArrayList<Body>();
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public List<Body> getMessage() {
        return message;
    }

    public void setMessage(List<Body> message) {
        this.message = message;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append("************sheet 1**************");
        stringBuilder.append(System.getProperty("line.separator"));
//        for (Header h : header) {
            stringBuilder.append(header.getName() + "              " + header.getFamily());
            stringBuilder.append(System.getProperty("line.separator"));
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
