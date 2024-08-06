package api.utilities;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//Extent report 5.x

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;	
	String repName;	

	@Override
	public void onStart(ITestContext context) {
		
		String timeStamp = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
		repName="Test-Report-"+timeStamp+".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\"+repName);// specify location of the report
		sparkReporter.config().setDocumentTitle("RestAssureAutomationProject"); // Title of the project
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Pet Store Users API");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "SDET");
		extent.setSystemInfo("User", "Sai Srinivas");		
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, "Test Passed");
	}


	@Override
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}


	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	
	
}
