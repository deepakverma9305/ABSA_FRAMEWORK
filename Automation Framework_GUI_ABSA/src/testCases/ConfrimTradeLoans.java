package testCases;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import java.awt.event.KeyEvent;

public class ConfrimTradeLoans {

	static ChromeOptions chromeOptions = new ChromeOptions();
	//static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");
	public static String driverPath = "C:\\Users\\abdv220\\workspace\\all External jars\\";	
	public static WebDriver driver;
	static Screen s= new Screen();	
    public static String sikulImages="C:\\Users\\abdv220\\git\\ABSA_FrameWork_Selinium\\ABSA_AutomationFrameWork_CIB\\SikuliImages";
	public static String Header = "ABSA-CIB CORPORATE: SUPPLIER FINANCE";
	public static String Footer = "ABSA BANK";
	public static String TemlatePath= "C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_data\\Template\\TestResultTemplate.docx";
	public static String TesDocPath= "C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_Results\\";
	public static String ImgLocation= "C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_Results\\temp\\";
	public static int[] ReportStepNumber= new int[100];
	public static String[] ReportStepName = new String[100];
	public static String[] ReportStepResult = new String[100];
	public static String excelFilePath ="C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_Results\\tempData.xlsx";
	public static String SRFAccount= "SRF Suspense Account - ABSAZAJJ, 4082761030";
	public static String SfZarAccount="SF Suspense Account - ABSAZAJJ, 4082761030";
	public static String SfNonZarAccount="USD Nostro - CITIUS33, 010686";
	public static String BankAccount=null;
	public static Date date = new Date();  
	public static  SimpleDateFormat formatter1 = new SimpleDateFormat("dd hh:mm:ss");  
	public static  String strDate1= formatter1.format(date);   
	public static int Stepno=1;//Important value
	public static int m=1;
	
	public static void ConfrimTradeLoan(String TestName) throws Exception {
	    
		try{ 	
			
			
			
			//Clean DB
		      generalFunctions.Functions.CleanDB();
		      generalFunctions.Functions.DeleteDBWF();
		      //DB Cleaned
		      
		      //Put RAO File
		      generalFunctions.Functions.Wait(10000);
		      generalFunctions.Functions.PutRAOFilesInserver();
		      
		      //File Put in SERVER
			
		  System.out.println("launching chrome browser");
		  System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		  chromeOptions.addArguments("--start-maximized");
		  driver = new ChromeDriver(chromeOptions);   
		 
		 
		  		  
		  //Test Start
		  ReportStepName[Stepno]= "Get Url";
	      driver.get("http://22.149.62.84:8088/auth/realms/supplierfinance/protocol/openid-connect/auth?client_id=supplierfinance-app&redirect_uri=http%3A%2F%2F22.149.62.84%3A9085%2F%3Fredirect_fragment%3D%252F&state=f8901771-49fd-445e-a680-7367ae52a347&nonce=8a2b393a-996b-4484-8634-a316317442e1&response_mode=fragment&response_type=code");
	    
	      generalFunctions.Functions.robo(Stepno);	
	      ReportStepResult[Stepno]="PASS";	    
	      Stepno=Stepno+1;	     
	      ReportStepName[Stepno]= "Login In SF Application";	      
	      driver.findElement(By.id("username")).clear();
	      driver.findElement(By.id("username")).sendKeys("abdv220");
	      driver.findElement(By.id("password")).clear();
	      driver.findElement(By.id("password")).sendKeys("Deepak@123");	      
	      driver.findElement(By.id("kc-login")).click();	      
	      generalFunctions.Functions.robo(Stepno);
	      ReportStepResult[Stepno]="PASS";
	      Stepno=Stepno+1;	     
	      ReportStepName[Stepno]= "Login Into DashBoard";	          
	      generalFunctions.Functions.Wait(3000);	      
	      generalFunctions.Functions.Strtype("abdv220");
	      generalFunctions.Functions.Inttype(KeyEvent.VK_TAB);	    
	      generalFunctions.Functions.UPStrtype("T");
	      generalFunctions.Functions.Strtype("he");
	      generalFunctions.Functions.Strtype("1");
	      generalFunctions.Functions.ATtype();	   
	      generalFunctions.Functions.Strtype("123");	           
	      generalFunctions.Functions.Inttype(KeyEvent.VK_ENTER);  
	      generalFunctions.Functions.Wait(5000);	      
	      generalFunctions.Functions.robo(Stepno);
	      ReportStepResult[Stepno]="PASS";	
	      Stepno=Stepno+1;	
	      //Report Creation
	       
	      
	     
	      
	     
	     int i = generalFunctions.Functions.GetTradeLoanCountAndRefNum();
	     
	     for(int j=1;j<=i;j++)
	     
	     {
	    	 
	    	 WebDriverWait wait = new WebDriverWait(driver, 10); 	    	 
	    	 int TradeLoanRefNo= generalFunctions.Functions.RecNo[j];		     
		     String s= String.valueOf(TradeLoanRefNo);
		     WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/nav/div/div[2]/ul/li[3]/a")));
		     element1.click();
		     generalFunctions.Functions.Wait(2000);		     
		     WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div/div[1]/div/div[1]/label/input")));
		     element2.click();
		     generalFunctions.Functions.Strtype(s);
		     WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div/div[1]/div/table/tbody/tr/td[5]/a")));
		     element3.click();
		     WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/form/div[4]/div[2]/button")));
		     element4.click();
		     WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/form/div[3]/button[1]")));
		     element.click();
		     //Buyer
		     String buyer=generalFunctions.Functions.GetBuyer(TradeLoanRefNo);
		     driver.findElement(By.xpath("/html/body/div/div[3]/div/form/div[2]/div[3]/div/select")).sendKeys(buyer);
		     //Loan Amount
		     
		     String LoanAmt=generalFunctions.Functions.GetLoanAmount(TradeLoanRefNo);		     
		     driver.findElement(By.xpath("/html/body/div/div[3]/div/form/div[2]/div[4]/div/input")).sendKeys(LoanAmt);
		   
		     //Maturity Date
		     String MaturityDate=generalFunctions.Functions.GetMaturityDate(TradeLoanRefNo);
		     driver.findElement(By.xpath("/html/body/div/div[3]/div/form/div[2]/div[5]/div[1]/input")).sendKeys(MaturityDate);		     
		     //TradeLoan Ref
		     Date date = new Date();  
		 	 SimpleDateFormat formatter1 = new SimpleDateFormat("dd hh:mm:ss");  
		 	 String strDate= formatter1.format(date);  
		     driver.findElement(By.xpath("/html/body/div/div[3]/div/form/div[2]/div[6]/div/input")).sendKeys("TR"+strDate);		     
		     //Bank Account
		     String Product= generalFunctions.Functions.GetProduct(TradeLoanRefNo);
		     
		     //String SRF=null;
		     if(Product.equals("SRF")){
		     
		     BankAccount=SRFAccount;
		     
		     }else if(Product.equals("SF"))
		     
		     		     
		     {
		    	 
		    	 String Currency= generalFunctions.Functions.GetCurrency(TradeLoanRefNo);
		    	 
		    	 if(Currency.equals("ZAR"))
		    	 
		    	 {
		    		 BankAccount= SfZarAccount;
		    		 
		    	 }else{BankAccount= SfNonZarAccount;}
		    	 
		    	 
		     }
		     
		     
		     driver.findElement(By.xpath("/html/body/div/div[3]/div/form/div[2]/div[7]/div/select")).sendKeys(BankAccount);
		    
		      
		      ReportStepName[Stepno]= "ConfirmTradeLoan"+m;
		      generalFunctions.Functions.robo(Stepno);	
		      ReportStepResult[Stepno]="PASS";	    
		      Stepno=Stepno+1;
		      m=m+1;
		     
		     
		     WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/form/div[3]/button[3]")));
		     element5.click();
		
	     }
	    	 
	    	 
		    }
		    catch (Exception e) {e.printStackTrace();}
	       
		      Stepno=Stepno-1;	
		      generalFunctions.Functions.createTestDoc(Stepno, TestName, "PASS");
		      generalFunctions.Functions.FlushOldResults();

	}





}
