package com.prathmesh.selenium.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentmanager {

	private static ExtentReports extent;
	
	public static ExtentReports  getreportsInstance() {
		
		if (extent==null) {
			CreatereportsInstance();
		}
		
		return extent;
		
	}
	
	public static ExtentReports CreatereportsInstance() {
		
		String reportpath = System.getProperty("user.dir")+ "/reports/extent-reports.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportpath);
		reporter.config().setDocumentTitle("Automation Test Report");
	    reporter.config().setReportName("Selenium Practice Lab");
		reporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Tester", "Prathmesh Ghate");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("Framework", "Selenium + TestNG + Java");
		
        
		
		return extent;
		
	}
}
