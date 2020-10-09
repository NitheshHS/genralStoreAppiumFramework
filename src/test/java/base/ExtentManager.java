package base;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private ExtentSparkReporter htmlReporter;
	public ExtentReports reports;
	public ExtentTest test;
	
	public ExtentReports set() {
		htmlReporter =new ExtentSparkReporter(System.getProperty("user.dir")+"//extentReport/report.html");
		htmlReporter.config().setDocumentTitle("GenralStore");
		htmlReporter.config().setReportName("Nithesh HS");
		htmlReporter.config().setTheme(Theme.DARK);
		
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("OS", "Windows 8.1");
		reports.setSystemInfo("Date", new Date().toString());
		return reports;
		
		
	}
	
	public void flushReport() {
		reports.flush();
	}

}
