package qa.utilties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;

public class ExtentReporter {
	public static ExtentReports generateReport()  {
		ExtentReports extentReport = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(extentReportFile);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName("Ecommerce");
		spark.config().setDocumentTitle("Selenium Automation Report");
		spark.config().setTimeStampFormat("dd/MM/YYYY hh:mm:ss");
		extentReport.attachReporter(spark);
		Properties confipro = new Properties();
		File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\qa\\config\\config.properties");
		FileInputStream fl;
		try {
			fl = new FileInputStream(file);
			confipro.load(fl);

		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//system.getProperties().list(system.out)
		extentReport.setSystemInfo("Application URL", confipro.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", confipro.getProperty("browser"));
		extentReport.setSystemInfo("Operating system", System.getProperty("os.name"));
		extentReport.setSystemInfo("Username", System.getProperty("user.name"));
		extentReport.setSystemInfo("Java version", System.getProperty("java.version"));

		return extentReport;

	}
}
