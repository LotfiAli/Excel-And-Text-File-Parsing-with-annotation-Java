package test;

import ir.bmi.api.excelParser.annotation.cell.*;
import ir.bmi.api.excelParser.annotation.column.StartColumn;
import ir.bmi.api.excelParser.annotation.row.IndexRow;
import ir.bmi.api.excelParser.annotation.row.TitleHolder;
import ir.bmi.api.excelParser.annotation.sheet.Sheet;

import java.util.List;

/**
 * Created by alotfi on 5/24/2016.
 */
public class MessageExcel {

    @BorderRight(BOrderCell = BORDER_CELL.BORDER_THIN)
    @BorderUp(BOrderCell = BORDER_CELL.BORDER_THIN)
    @BoredrBottom(BOrderCell = BORDER_CELL.BORDER_THIN)
    @BorderLeft(BOrderCell = BORDER_CELL.BORDER_THIN)
    @AlignCell(Align = ALIGN_CELL.ALIGN_LEFT)
    @TitleHolder(HaveHolder = false)
    @IndexRow(Index = 0)
    @Sheet(name = "test")
    @StartColumn(Start = 0)
    @SpamCell(SpamCell = 4)
    private String titel;

    @BorderRight(BOrderCell = BORDER_CELL.BORDER_THIN)
    @TitleHolder(HaveHolder = false)
    @IndexRow(Index = 1)
    @Sheet(name = "test")
    @StartColumn(Start = 0)
    @SpamCell(SpamCell = 4)
    private String description;

    @BorderRight(BOrderCell = BORDER_CELL.BORDER_THIN)
    @TitleHolder(HaveHolder = false)
    @IndexRow(Index = 2)
    @Sheet(name = "test")
    @StartColumn(Start = 0)
    @SpamCell(SpamCell = 4)
    private String name;

    @BorderRight(BOrderCell = BORDER_CELL.BORDER_THIN)
    @TitleHolder(HaveHolder = false)
    @IndexRow(Index = 3)
    @Sheet(name = "test")
    @StartColumn(Start = 0)
    @SpamCell(SpamCell = 4)
    private String family;

    //    @TitleHolder(HaveHolder = true)
//    @IndexRow(Index = 1)
//    @Sheet(name = "test")
//    private Header header;
//
    @BorderRight(BOrderCell = BORDER_CELL.BORDER_THIN)
    @TitleHolder(HaveHolder = true)
    @IndexRow(Index = 4)
    @Sheet(name = "test")
    @StartColumn(Start = 0)
    private List<Body> message;
//
//    public MessageExcel() {
//        this.header = new Header();
//        this.message = new ArrayList<Body>();
//    }
//
//    public Header getHeader() {
//        return header;
//    }
//
//    public void setHeader(Header header) {
//        this.header = header;
//    }
//
    public List<Body> getMessage() {
        return message;
    }

    public void setMessage(List<Body> message) {
        this.message = message;
    }
//
    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    //
//    @Override
//    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(System.getProperty("line.separator"));
//        stringBuilder.append("************sheet 1**************");
//        stringBuilder.append(System.getProperty("line.separator"));
////        for (Header h : header) {
//        stringBuilder.append(header.getName() + "              " + header.getFamily());
//        stringBuilder.append(System.getProperty("line.separator"));
////        }
//        stringBuilder.append("************sheet2******************");
//        stringBuilder.append(System.getProperty("line.separator"));
//        for (Body body : message) {
//            stringBuilder.append(body.getName() + "              " + body.getFamily() + "             " + body.getOld());
//            stringBuilder.append(System.getProperty("line.separator"));
//        }
//        return stringBuilder.toString();
//
//    }
}
