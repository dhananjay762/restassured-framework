package support;

import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import common.*;

public class Hooks implements ICommonConstant{
	
	@Before
	public void beforeScenario(Scenario scenario){
		Reporter.assignAuthor(AUTHOR_NAME);
	}
	
	@After
	public void afterScenario(Scenario scenario) throws Exception{
		Report.createReport();
	}

}
