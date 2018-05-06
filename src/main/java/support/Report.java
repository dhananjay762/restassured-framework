package support;

import com.cucumber.listener.Reporter;
import managers.ConfigFileReader;
import common.*;

public class Report implements ICommonConstant{
	
	public static void createReport() throws Exception{
		ConfigFileReader reader = new ConfigFileReader();
		Reporter.loadXMLConfig(reader.getReportConfigPath());
		Reporter.setSystemInfo("User Name", USER_NAME);
	    Reporter.setSystemInfo("Time Zone", TIME_ZONE);
	    Reporter.setSystemInfo("Machine", MACHINE);
//	    Reporter.setSystemInfo("Selenium", "3.7.0");
//	    Reporter.setSystemInfo("Maven", "3.5.2");
//	    Reporter.setSystemInfo("Java Version", "1.8.0_151");
	    Reporter.setSystemInfo("Java Version", JAVA_VERSION);
	}

}
