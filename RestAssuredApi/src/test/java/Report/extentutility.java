package Report;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;

public class extentutility {
	public static ExtentReports extentReport ;
	//public static ExtentSparkReporter
	
	@BeforeSuite
	public void initializeExtentReport() {
		extentReport = new ExtentReports();
		
	}

}
