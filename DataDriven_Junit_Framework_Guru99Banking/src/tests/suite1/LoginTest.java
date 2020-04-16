package tests.suite1;

import java.io.IOException;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import tests.TestBase;
import util.TestUtil;


public class LoginTest extends TestBase {
	
	@Before
	public void beforeTest() throws IOException {
		initialize();
		if(TestUtil.isSkip("LoginTest")) 
		Assume.assumeTrue(false);
		
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		driver.get(OR.getProperty("login_URL"));
		TestUtil.doLogin("mngr253411","Patel888!");
		}

	
}
