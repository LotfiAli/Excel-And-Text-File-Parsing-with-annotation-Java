# Excel-and-File-Parsing-with-anotation-
  Hello. This framework works with Excel and text file format. you do with Annotationn a correct model  and use ExcelManagerFactory to seriliaze and deserilize file.
  

  
public class MessageExcel {
    @Sheet(name = "test")

public class MessageExcel {
    @Sheet(name = "test")
    public class MessageExcel {
    @Sheet(name = "test")
    public class MessageExcel {
    @Sheet(name = "test")
    public class MessageExcel {
    @Sheet(name = "test")public class MessageExcel {
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



after your entity ready you must write this code:

    ParserManager excelManager = ExcelManagerFactory.getExcelParserManager("d:\\Book1.xlsx",MessageExcel.class);
    ResultModel message = excelManager.deSerialize();
    System.out.println(message.getResultModel().toString());

    ParserManager excelManagerSerialize = ExcelManagerFactory.getExcelParserManager("d:\\Book2.xlsx", MessageExcel.class);
    excelManagerSerialize.serialize(message.getResultModel());
