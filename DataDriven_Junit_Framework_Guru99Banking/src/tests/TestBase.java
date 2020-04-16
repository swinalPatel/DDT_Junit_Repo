package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestBase {
	
	// initializing properties file to read (need to create object of the properties file)
	public static Properties CONFIG = null;
	public static Properties OR = null;
	public static WebDriver dr = null;
	public static EventFiringWebDriver driver = null;
	public static boolean isLoggedIn = false;
	public static String value;
	public static File file = null;
	public static Sheet suite1Sheet = null;
	
	// creating object of xlsx file
	//public static TestBase objExcelFile = null;
	
	//making new function to initialize this objects 
	
	public void initialize() throws IOException {
		if(driver==null) {
		// initialize config properties file 
		CONFIG = new Properties();
		FileInputStream fn = new FileInputStream(System.getProperty("user.dir") + "//src//config//config.properties" );
		CONFIG.load(fn);
		
		// initialize OR properties file
		OR = new Properties();
		fn = new FileInputStream(System.getProperty("user.dir") + "//src//config//OR.properties");
		OR.load(fn);
		
		// initialize the browser
		
		if(CONFIG.getProperty("browser").equals("Mozilla")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			dr = new FirefoxDriver();
		}
		else if(CONFIG.getProperty("browser").equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			dr = new ChromeDriver();
		}
		else if(CONFIG.getProperty("browser").equals("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
			dr = new InternetExplorerDriver();
		}
		
		//reading excel file 
		String filePath = System.getProperty("user.dir") + "\\src\\config";
		readExcelFile(filePath, "Suite1.xlsx", "Test_Cases");
		
		// adding evenfiring wedriver for listner and mousemovement
		driver = new EventFiringWebDriver(dr);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
		
		
	}
	
	//function created for finding xpath and returns the webelement of that path
	public static WebElement getObject(String xpathkey) {
		try {
		return driver.findElement(By.xpath(OR.getProperty(xpathkey)));
		}catch (Throwable t) {
			System.out.println("element not found");
			return null;
		}
	}
	
	//function to read excel file
	public void readExcelFile(String filePath, String fileName, String sheetName) throws IOException {
		
		file = new File(filePath + "//" + fileName);
		FileInputStream fn = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fn);
		suite1Sheet = workbook.getSheet(sheetName);

	
	}
}
