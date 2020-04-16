package tests.suite1;

import java.io.IOException;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import tests.TestBase;
import util.TestUtil;

public class PasswordChangeTest extends TestBase {

	@Before
	public void beforeTest() throws IOException {
		initialize();
		if(TestUtil.isSkip("PasswordChangeTest"))
		Assume.assumeTrue(false);
		
	}
	
	@Test
	public void passwordChangeTest() throws InterruptedException {
		driver.get(OR.getProperty("password_change_URL"));
		//TestUtil.doLogin("mngr253411","Patel888!");
	
		getObject("password_change_tab").click();
		getObject("old_password_input").sendKeys("Patel888!");
		getObject("new_password_input").sendKeys("Patel888");
		getObject("confim_password_input").sendKeys("Patel888");
		getObject("submit_button").click();
		
		}
	
	
}