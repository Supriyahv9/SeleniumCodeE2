package CommonUtils;

import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {

	ExtentReports report;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("testscript execution is started");
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"Testscript execution is Started",true);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	//System.out.println("testscript is passed");	
		//Capture the method name
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"Testscript execution is Pass",true);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("testscript is failed");
		//Capture the method name
	String methodname = result.getMethod().getMethodName();
	Reporter.log(methodname+"Testscript execution is Fail",true);
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("testscript is skipped");
		//Capture the method name
	String methodname = result.getMethod().getMethodName();
	Reporter.log(methodname+"Testscript execution is Skip",true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
		//To configure extent reports
	ExtentSparkReporter	esr = new ExtentSparkReporter("./Extentreport/report.html");
	esr.config().setReportName("Vtigercrm");	
	esr.config().setTheme(Theme.DARK);
	esr.config().setDocumentTitle("Vtiger");
		
	//To generate extent reports
	report = new ExtentReports();
	report.attachReporter(esr);
	report.setSystemInfo("Browser", "Chrome");
	report.setSystemInfo("Chrome", "122");
	report.setSystemInfo("OS", "Windows");
	report.setSystemInfo("Author", "supriya");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
	}

	
	
	
}
