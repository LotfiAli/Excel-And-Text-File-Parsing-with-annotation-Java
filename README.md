# Excel And Text File Parsing With Annotation-
  Hello. This framework works with Excel and text file format. you do with Annotationn a correct model  and use ExcelManagerFactory to seriliaze and deserilize file.




      public class MessageExcel{
         @sheet(name="test")
         private Header heaer;
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
    }}
And

    @DescriptionColumn(description = "test3")
    @NotNullValidation()
    @ColorCell(blue = 100, green = 10, red = 250)
    private String accNum;

    @NotNullValidation()
    @DescriptionColumn(description = "test4")
    @ConvertTo(convertTo = TypeObject.INT)
    @ColorCell(blue = 200, green = 150, red = 80)
    private int totalCount;

    @NotNullValidation()
    @DescriptionColumn(description = "test5")
    @ColorCell(blue = 200, green = 150, red = 80)
    @ConvertTo(convertTo = TypeObject.Long)

    private double totalSuml;

/

    public HeaderString() {
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public Double getTotalSuml() {
        return totalSuml;
    }

    public void setTotalSuml(Double totalSuml) {
        this.totalSuml = totalSuml;
    }

after your entity ready you must write this code:

    ParserManager excelManager = ExcelManagerFactory.getExcelParserManager("d:\\Book1.xlsx",MessageExcel.class);
    ResultModel message = excelManager.deSerialize();
    System.out.println(message.getResultModel().toString());

    ParserManager excelManagerSerialize = ExcelManagerFactory.getExcelParserManager("d:\\Book2.xlsx", MessageExcel.class);
    excelManagerSerialize.serialize(message.getResultModel());
    
   
    
