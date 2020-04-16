package util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import tests.TestBase;

public class TestUtil extends TestBase {
	
	//login function
	public static void doLogin(String username, String password) throws InterruptedException {
		
		if(isLoggedIn) {
			System.out.println("do log out");
			doLogOut();
			return;
			
			
		}
		else {
			//getObject("login_tab").click();
			//getObject("popup").click();
			getObject("username_field").sendKeys(username);
			getObject("password_field").sendKeys(password);
			getObject("login_button").click();
			
			Thread.sleep(5000L);
			try {
			System.out.println("find display name");
			
			String displayedUserEmail = driver.findElement(By.xpath(OR.getProperty("display_name"))).getText();
			System.out.println("display name:" + displayedUserEmail);
			
			if((displayedUserEmail).equals("Manger Id : " + username))
			{
				isLoggedIn=true;
				System.out.println("log in success");
			} else {
				isLoggedIn=false;
				System.out.println("log in unsucess");
			}
		}catch(Throwable t) {
			isLoggedIn=false;
			System.out.println("log in unsucess as element not found");
		}
			
		}
		
		
	}
	
	//logout function
	
			public static void doLogOut() {
				if(isLoggedIn) {
					
					getObject("sign_out_tab").click();
				}
			}

			public static boolean isSkip(String testCase) {
				
				
				int rowCount = suite1Sheet.getLastRowNum() - suite1Sheet.getFirstRowNum();
				for(int i=0; i<=rowCount; i++) {
					Row row = suite1Sheet.getRow(i);
					int cellCount = row.getLastCellNum();
				    for(int j=0; j<cellCount; j++) {
				    	value = row.getCell(j).getStringCellValue();
				    	if (value.equals(testCase)) {
					    		if(row.getCell(j+1).getStringCellValue().equals("Y")) {
					    			System.out.println("false(Run)");
				    				return false;
					    		}else {
					    			System.out.println("true(dont run)");
					    			return true;
					    		}
				    			} 
				    	}
				}
				System.out.println("true1");
				return true;
				} 

}
