package tests.suite1;

import java.io.IOException;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import tests.TestBase;
import util.TestUtil;

public class MiniStatementTest extends TestBase{

	@Before
	public void beforeTest() throws IOException {
		initialize();
		if(TestUtil.isSkip("MiniStatementTest")) 
		Assume.assumeTrue(false);
	
	}
	
	@Test
	public void miniStatementTest() throws InterruptedException {
		driver.get(OR.getProperty("mini_statement_URL"));
		getObject("mini_statement_tab").click();
		getObject("account_no_input").sendKeys("123456");
		getObject("edit_cust_submit_button").click();
		}
}