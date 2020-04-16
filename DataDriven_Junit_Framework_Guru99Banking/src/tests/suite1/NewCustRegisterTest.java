package tests.suite1;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tests.TestBase;
import util.TestUtil;

// (1) 1st step for parameterized 
@RunWith(Parameterized.class)

public class NewCustRegisterTest extends TestBase{
	
// (2) decleare all parameters globally 
	public String name;
	//public String gender;
	public String dob; 
	public String address;
	public String city;
	public String state;
	public String pin;
	public String phone;
	public String email;
	public String password;
	
	
// (3) make costructor class same name as main class
	public NewCustRegisterTest(String name, String dob, String address,
							   String city, String state, String pin, String phone,
							   String email, String password) {
		this.name = name;
		//this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.phone = phone;
		this.email = email;
		this.password = password;
		
	}
	
	
	
	@Before
	public void beforeTest() throws IOException {
		initialize();
		if(TestUtil.isSkip("NewCustRegisterTest")) 
		Assume.assumeTrue(false);
		}
	
	@Test
	public void newCustTest() throws InterruptedException {
		driver.get(OR.getProperty("register_URL"));
		//TestUtil.doLogin("mngr253411","Patel888!");
		
		getObject("new_cust_tab").click();
		getObject("cust_name_input").sendKeys(name);
		getObject("gender_female_radio").click();
		getObject("dob_input").sendKeys(dob);
		getObject("address_input").sendKeys(address);
		getObject("city_input").sendKeys(city);
		getObject("state_input").sendKeys(state);
		getObject("PIN_input").sendKeys(pin);
		getObject("phone_input").sendKeys(phone);
		getObject("email_input").sendKeys(email);
		getObject("password_input").sendKeys(password);
		
		getObject("submit_button").click();
		System.out.println("entered data");
		
		
		WebElement success = getObject("reg_success_message");
		System.out.println("display message: " + success);
		if(success==null) {
			//report error mess
			System.out.println("ERROR");
			}
		
		
		
		}
	
// (4) write function with annotation of parameters
	@Parameters
	public static Collection<Object[]> getData(){
		
		Object[][] data = new Object[2][9];
		
		// 1st row
		data[0][0] = "swinal";
		data[0][1] = "01101982";
		data[0][2] = "swinal";
		data[0][3] = "swinal";
		data[0][4] = "swinal";
		data[0][5] = "123456";
		data[0][6] = "1111111111";
		data[0][7] = "swinal0110@gmail.com";
		data[0][8] = "swinal";
		
		// 2nd row
		data[1][0] = "maulik";
		data[1][1] = "08031982";
		data[1][2] = "maulik";
		data[1][3] = "maulik";
		data[1][4] = "maulik";
		data[1][5] = "123456";
		data[1][6] = "2222222222";
		data[1][7] = "maulik@gmail.com";
		data[1][8] = "maulik";
		
		
		
		return Arrays.asList(data);
		
	}
	
	
}