package tests.suite1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	NewCustRegisterTest.class,
	LoginTest.class,
	MiniStatementTest.class,
	PasswordChangeTest.class
	})
public class FirstSuiteRunner {

}
