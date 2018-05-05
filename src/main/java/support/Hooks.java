package support;

import org.testng.asserts.SoftAssert;

import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import common.*;

public class Hooks implements ICommonConstant{
	
	@Before
	public void beforeScenario(Scenario scenario){
		Reporter.assignAuthor(AUTHOR_NAME);
	}

}
