package generalFunctions;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sikuli.script.Screen;
import java.awt.AWTException;
import java.awt.event.KeyEvent;

public class Functions {

	static ChromeOptions chromeOptions = new ChromeOptions();
	static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");
	public static String driverPath = "C:\\Users\\abdv220\\workspace\\all External jars\\";	
	public static WebDriver driver;
	static Screen s= new Screen();
	public static String sikulImages="C:\\Users\\abdv220\\git\\ABSA_FrameWork_Selinium\\ABSA_AutomationFrameWork_CIB\\SikuliImages";
	public static String Header = "ABSA-CIB CORPORATE: SUPPLIER FINANCE";
	public static String Footer = "ABSA BANK";
	public static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	public static Date date = new Date();
	public static String TemlatePath= "C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_data\\Template\\TestResultTemplate.docx";
	public static String TesDocPath= "C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_Results\\";
	public static String ImgLocation= "C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_Results\\temp\\";
	
    
public static void DeleteDBWF()

{
    try {
    	
    	Class.forName("org.postgresql.Driver");
    	Connection connection = null;    	
    	connection = DriverManager.getConnection("jdbc:postgresql://22.149.62.84:5432/SIT_supplierfinance_workflow","postgres", "postgres");
   
        Statement stmt = connection.createStatement();    
        stmt.executeUpdate("truncate act_hi_procinst,act_ru_task,act_hi_actinst,act_hi_taskinst,act_ru_job cascade;");
        connection.close();
        
        
        
        
    } catch (Exception e){e.printStackTrace();}}

public static void Wait(int time)



{
	try {
	    Thread.sleep(time);                 //1000 milliseconds is one second.
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	
	
	
	
}
public static void CleanDB(){
	
	try {
    	
    	Class.forName("org.postgresql.Driver");
    	Connection connection = null;
    	//connection = DriverManager.getConnection(Str);
    	connection = DriverManager.getConnection("jdbc:postgresql://22.149.62.84:5432/SIT2_supplierfinance","postgres", "postgres");
    	
       
        Statement stmt = connection.createStatement();
       // ResultSet rs;

        //rs = stmt.executeQuery("truncate batch_run cascade;");
        stmt.executeUpdate("truncate detail_recon_report,recon_summary_report,trade_loan_batch_link,trade_loan_batch,batch_run,trade_loan_batch_link,trade_loan_batch,payment_transmission,exception_payment_request,exception_task_detail,file_import,payment_request,payment_request_exception_task_detail,payment_request_file_import,primary_transaction,propell_payment,rao_file_import,supplier_payment,trade_loan cascade;");
        connection.close();
       
        
        
        
    } catch (Exception e){e.printStackTrace();}
	
	
	
}

public static void CreateFile_SRF(String path) throws FileNotFoundException

{
	
	PrintWriter pw = new PrintWriter(new File(path));
    StringBuilder sb = new StringBuilder();
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = new Date();
    Calendar c = Calendar.getInstance();    
    c.add(Calendar.DATE, 60);
   
    //SRF File  //        
  
    sb.append("EXPORT_DATE,,,,,,,,,,,,,,,,,");        
    sb.append('\n');
    sb.append("22-Aug-2017 14:15 (SAST),,,,,,,,,,,,,,,,,");        
    sb.append('\n');               
    
    //sb.append('"');
    sb.append("Offer Acceptance Date");
    //sb.append('"');        
    sb.append(',');
    //sb.append('"');
    sb.append("Advanced Value");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Obligor External ID");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Program Name");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Obligor");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Currency");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("FI Payment");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Invoice Reference");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Repayment Date");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("SP Rate Amount");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("FI Rate and Base Amount");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Seller External ID");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Seller");
    //sb.append('"');        
    sb.append(',');
    //sb.append('"');
    sb.append("Supplier Receipt");
    //sb.append('"');        
    sb.append(',');
    //sb.append('"');
    sb.append("Trade Payment Date");
    //sb.append('"');        
    sb.append(',');
    //sb.append('"');
    sb.append("Offer Reference");
    //sb.append('"');        
    sb.append(',');
    //sb.append('"');
    sb.append("Tenor Days (Trade payment to Repayment)");
    //sb.append('"');        
    sb.append(',');
    //sb.append('"');
    sb.append("Invoice Value");
    //sb.append('"');        
    sb.append('\n');
    
    

    //sb.append('"');
    sb.append(dateFormat.format(date));
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append(3341.16);
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append(79044);
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Farmwise on ABSA: Woolworths (79044)");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Woolworths (Pty) Ltd");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("ZAR");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append(3281.66);
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("INV21484");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');     
    sb.append(dateFormat.format(c.getTime()));
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append(2.14);
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append(59.5);
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Farmwise");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Farmwise Marketing (Pty) Ltd");
    //sb.append('"');        
    sb.append(',');
    //sb.append('"');
    sb.append(3279.52);
    //sb.append('"');        
    sb.append(',');
    //sb.append('"');
    sb.append(dateFormat.format(date));
    //sb.append('"');        
    sb.append(',');
    //sb.append('"');
    sb.append("SCQCGOSQITKNDCY");
    //sb.append('"');        
    sb.append(',');
    //sb.append('"');
    sb.append(60);
    //sb.append('"');       
    sb.append(',');
    //sb.append('"');
    sb.append(3712.4);
    //sb.append('"');        
    sb.append('\n');

    pw.write(sb.toString());
    pw.close();
    System.out.println("done!");




}


public static void CreateFile_SF(String path) throws FileNotFoundException

{
	
	PrintWriter pw = new PrintWriter(new File(path));
    StringBuilder sb = new StringBuilder();
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = new Date();
    Calendar c = Calendar.getInstance();    
    c.add(Calendar.DATE, 60);
   
    //SRF File  //        
  
    sb.append("EXPORT_DATE,,,,,,,,,,,,,,,,,");        
    sb.append('\n');
    sb.append("22-Aug-2017 14:15 (SAST),,,,,,,,,,,,,,,,,");        
    sb.append('\n');               
    
  sb.append('"');
    sb.append("Offer Acceptance Date");
  sb.append('"');        
    sb.append(',');
  sb.append('"');
    sb.append("Advanced Value");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Obligor External ID");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Program Name");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Obligor");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Currency");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("FI Payment");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Invoice Reference");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Repayment Date");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("SP Rate Amount");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("FI Rate and Base Amount");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Seller External ID");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Seller");
  sb.append('"');        
    sb.append(',');
  sb.append('"');
    sb.append("Supplier Receipt");
  sb.append('"');        
    sb.append(',');
  sb.append('"');
    sb.append("Trade Payment Date");
  sb.append('"');        
    sb.append(',');
  sb.append('"');
    sb.append("Offer Reference");
  sb.append('"');        
    sb.append(',');
  sb.append('"');
    sb.append("Tenor Days (Trade payment to Repayment)");
  sb.append('"');        
    sb.append(',');
  sb.append('"');
    sb.append("Invoice Value");
  sb.append('"');        
    sb.append('\n');
    
    

  sb.append('"');
    sb.append(dateFormat.format(date));
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append(3341.16);
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append(79044);
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Farmwise on ABSA: Woolworths (79044)");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Woolworths (Pty) Ltd");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("ZAR");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append(3281.66);
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("INV21484");
  sb.append('"');
    sb.append(',');
  sb.append('"');     
    sb.append(dateFormat.format(c.getTime()));
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append(2.14);
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append(59.5);
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Farmwise");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Farmwise Marketing (Pty) Ltd");
  sb.append('"');        
    sb.append(',');
  sb.append('"');
    sb.append(3279.52);
  sb.append('"');        
    sb.append(',');
  sb.append('"');
    sb.append(dateFormat.format(date));
  sb.append('"');        
    sb.append(',');
  sb.append('"');
    sb.append("SCQCGOSQITKNDCY");
  sb.append('"');        
    sb.append(',');
  sb.append('"');
    sb.append(60);
  sb.append('"');       
    sb.append(',');
  sb.append('"');
    sb.append(3712.4);
  sb.append('"');        
    sb.append('\n');

    pw.write(sb.toString());
    pw.close();
    System.out.println("done!");




}
public static void CreateStepInReport(String TestName, String StepName, String StepResult, String TestResult ,String ImgLocation, String TestDocLoacation) throws IOException, InvalidFormatException


{
	 String imgFile = ImgLocation+StepName+".jpg";	
	 @SuppressWarnings("resource")
     XWPFDocument document = new XWPFDocument(OPCPackage.open(TesDocPath+TestName+".docx"));	
        
     XWPFParagraph paragraph = document.createParagraph();     
     XWPFRun paragraph1 = paragraph.createRun();
     paragraph1.addBreak(); 
     paragraph1.setText("Step Name: "+StepName);
     paragraph1.addTab();
     paragraph1.setText("Step Result: "+StepResult);     
     FileInputStream is = new FileInputStream(imgFile);
     paragraph1.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, imgFile, Units.toEMU(471), Units.toEMU(400));
     is.close();
     FileOutputStream out = new FileOutputStream(new File(TesDocPath+TestName+".docx")); 
     document.write(out);
     out.close();
     System.out.println("Document written successully");
  }

public static void robo(int StepNumber) throws Exception
{
    
	
	Calendar now = Calendar.getInstance();
    Robot robot = new Robot();
    try {
	    Thread.sleep(2000);                 //1000 milliseconds is one second.
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
    BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
   // ImageIO.write(screenShot, "JPG", new File(str+formatter.format(now.getTime())+".jpg"));
    
    ImageIO.write(screenShot, "JPG", new File(ImgLocation+"Step"+StepNumber+".jpg"));
    //StepNumber++;
    
    
    
    System.out.println(formatter.format(now.getTime()));
}

public static void createTestDoc(int StepNumber, String TestName,String TestResult) throws InvalidFormatException, IOException


{
	//int[] SteNumber = new int[100];
	
	//XWPFDocument document = new XWPFDocument();
	
	@SuppressWarnings("resource")
	XWPFDocument document = new XWPFDocument(OPCPackage.open(TemlatePath));
	
	XWPFParagraph paragraph = document.createParagraph();
    
    //Set Bold an Italic
    XWPFRun paragraph0 = paragraph.createRun();
    paragraph0.setBold(true);    
    paragraph0.setText("Test case Name: "+TestName);
    paragraph0.setFontSize(12);
    paragraph0.setTextPosition(10);
    paragraph.setBorderRight(org.apache.poi.xwpf.usermodel.Borders.BASIC_BLACK_DASHES);
    paragraph.setBorderBottom(org.apache.poi.xwpf.usermodel.Borders.BASIC_BLACK_DASHES);
    paragraph.setBorderLeft(org.apache.poi.xwpf.usermodel.Borders.BASIC_BLACK_DASHES);
    paragraph.setBorderTop(org.apache.poi.xwpf.usermodel.Borders.BASIC_BLACK_DASHES);     
    paragraph0.addBreak();     
    paragraph0.setText("Date: "+dateFormat.format(date));
    paragraph0.addTab();
    paragraph0.setText("Test Analyst: Automation Test ");
    paragraph0.addTab();
    paragraph0.setText("Result: "+TestResult);   
    paragraph0.addBreak();  
    
    for (int i=1;i<=StepNumber;i++)
    	
    {
    
    XWPFParagraph paragraph2 = document.createParagraph();
    XWPFRun paragraph3 = paragraph2.createRun();
    paragraph3.setText("StepName: "+testCases.Login_Test.ReportStepName[i]);
    paragraph3.addTab();
    paragraph3.setText("Step Result:");
    paragraph3.addTab();
    paragraph3.setText(testCases.Login_Test.ReportStepResult[i]);
    paragraph3.addBreak(); 
    FileInputStream is = new FileInputStream(ImgLocation+"Step"+i+".jpg");
    paragraph3.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, ImgLocation+"Step"+i+".jpg", Units.toEMU(471), Units.toEMU(400));
    is.close();
    paragraph3.addBreak();
    
    }
    
    
	FileOutputStream out = new FileOutputStream(new File(TesDocPath+TestName+".docx"));
	
	 document.write(out);
	 
     out.close();
}

public static void FlushOldResults()

{
	try{
	  String path= ImgLocation; 
        File file = new File(path);
        File[] files = file.listFiles(); 
        
        for (File f:files) {
       
           f.delete();
        }
	} catch(Exception e){e.printStackTrace();}
	
}

public static void WriteToExcel(int SheetNumber, int RowNumber, int ColNumber, String StepResult) throws IOException
{
    //Blank workbook
	
	FileInputStream file = new FileInputStream(new File("C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_Results\\Test.xlsx"));
    @SuppressWarnings("resource")
    XSSFWorkbook workbook = new XSSFWorkbook(file);
//	XSSFWorkbook workbook = new XSSFWorkbook();
     
    //Create a blank sheet
    Sheet sheet = workbook.getSheetAt(SheetNumber);
   // XSSFSheet sheet = workbook.createSheet("TestSteps");
    
    for(int i=1;i<=RowNumber;i++){
    Row row = sheet.createRow(i);
    Cell cell = row.createCell(ColNumber);           
    cell.setCellValue(testCases.Login_Test.ReportStepName[i]);
    
    Cell cell2 = row.createCell(ColNumber+1);           
    cell2.setCellValue(StepResult);
    }
            
    
    try
    {
        //Write the workbook in file system
        FileOutputStream out = new FileOutputStream(new File("C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_Results\\Test.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}





public static void leftClick() throws AWTException
{
  Robot robot = new Robot();
  robot.mousePress(InputEvent.BUTTON1_MASK);
  robot.delay(200);
  robot.mouseRelease(InputEvent.BUTTON1_MASK);
  robot.delay(200);
}

public static void Inttype(int i) throws AWTException
{
  Robot robot = new Robot();
  robot.delay(40);
  robot.keyPress(i);
  robot.keyRelease(i);
}

public static void Strtype(String s) throws AWTException
{
	
  Robot robot = new Robot();
  byte[] bytes = s.getBytes();
  for (byte b : bytes)
  {
    int code = b;
    // keycode only handles [A-Z] (which is ASCII decimal [65-90])
    if (code > 96 && code < 123) code = code - 32;
    robot.delay(40);
    robot.keyPress(code);
    robot.keyRelease(code);
  }
}


public static void ATtype() throws AWTException
{
  Robot robot = new Robot();
  robot.keyPress(KeyEvent.VK_SHIFT);
  robot.keyPress(KeyEvent.VK_2);
  robot.keyRelease(KeyEvent.VK_2);
  robot.keyRelease(KeyEvent.VK_SHIFT);
}

public static void UPStrtype(String s) throws AWTException
{
	
  Robot robot = new Robot();
  byte[] bytes = s.getBytes();
  for (byte b : bytes)
  {
    int code = b;
    // keycode only handles [A-Z] (which is ASCII decimal [65-90])
    if (code > 96 && code < 123) code = code - 32;
    robot.delay(40);
    robot.keyPress(KeyEvent.VK_CAPS_LOCK);
    robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
    robot.keyPress(code);
    robot.keyRelease(code);
    robot.keyPress(KeyEvent.VK_CAPS_LOCK);
    robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
  }
}






}







