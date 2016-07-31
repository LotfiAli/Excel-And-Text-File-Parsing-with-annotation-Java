# Excel-and-File-Parsing-with-anotation-
 Hi. Hello. This framework works with Excel file format Mtn.tnha second thing you do with Annvtatyvn a correct model and related marks and Framvvrk delivered to you.

package test;

import ir.bmi.api.excelParser.annotation.sheet.Sheet;
import ir.bmi.api.excelParser.annotation.validation.NotNullValidation;

import java.util.ArrayList;
import java.util.List;


    public class MessageExcel {
      @Sheet(name = "test")
      private Header header;
      @Sheet(name = "test1")
     private List<Body> message;

    public MessageExcel() {
       this.header = new Header();
       this.message = new ArrayList<Body>();
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
 }

public class Header {
  @NotNullValidation()
  @ColorCell(blue = 100,green = 10,red = 250)
  private String name;
  @NotNullValidation()
  @ColorCell(blue = 200,green = 150,red = 80)
  private String family;

  public Header() {
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
}

after your entity ready you must write this code:

    ParserManager excelManager = ExcelManagerFactory.getExcelParserManager("d:\\Book1.xlsx",MessageExcel.class);
    ResultModel message = excelManager.deSerialize();
    System.out.println(message.getResultModel().toString());

    ParserManager excelManagerSerialize = ExcelManagerFactory.getExcelParserManager("d:\\Book2.xlsx", MessageExcel.class);
    excelManagerSerialize.serialize(message.getResultModel());
