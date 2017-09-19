package testCases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sikuli.script.Screen;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Login_Test {

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
	public static int[] ReportStepNumber= new int[100];
	public static String[] ReportStepName = new String[100];
	public static String[] ReportStepResult = new String[100];
	public static String excelFilePath ="C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_Results\\tempData.xlsx";
	
	
	
	
	
	public static void Test_Login(String TestName) throws Exception {
	    
		try{ 	
			
			
			
		  System.out.println("launching chrome browser");
		  System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");		

		  chromeOptions.addArguments("--start-maximized");
		  driver = new ChromeDriver(chromeOptions);		      
		 
		  int Stepno=1;//Important value
		  		  
		  //Test Start
		  ReportStepName[1]= "Get Url";
	      driver.get("http://22.149.62.84:8088/auth/realms/supplierfinance/protocol/openid-connect/auth?client_id=supplierfinance-app&redirect_uri=http%3A%2F%2F22.149.62.84%3A9085%2F%3Fredirect_fragment%3D%252F&state=f8901771-49fd-445e-a680-7367ae52a347&nonce=8a2b393a-996b-4484-8634-a316317442e1&response_mode=fragment&response_type=code");
	    
	      generalFunctions.Functions.robo(Stepno);	
	      ReportStepResult[Stepno]="PASS";
	    
	      Stepno=Stepno+1;	     
	     
	      ReportStepName[2]= "Login In SF Application";
	      
	      driver.findElement(By.id("username")).clear();
	      driver.findElement(By.id("username")).sendKeys("abdv220");
	      driver.findElement(By.id("password")).clear();
	      driver.findElement(By.id("password")).sendKeys("Deepak@123");	      
	      driver.findElement(By.id("kc-login")).click();
	      generalFunctions.Functions.robo(Stepno);	         
	      //Test End
	      ReportStepResult[Stepno]="PASS";
	      //Report Creation Start
	      generalFunctions.Functions.createTestDoc(Stepno, TestName, "PASS");
	      //Report Creation End 
	      generalFunctions.Functions.FlushOldResults();	      
	      generalFunctions.Functions.Wait(3000);	      
	      generalFunctions.Functions.Strtype("abdv220");
	      generalFunctions.Functions.Inttype(KeyEvent.VK_TAB);	    
	      generalFunctions.Functions.UPStrtype("K");
	      generalFunctions.Functions.Strtype("rishna");	   
	      generalFunctions.Functions.ATtype();	   
	      generalFunctions.Functions.Strtype("123");	           
	      generalFunctions.Functions.Inttype(KeyEvent.VK_ENTER);     
	     
	      
	      
		    }
		    catch (Exception e) {e.printStackTrace();}
	       
		
		

	}




















}
