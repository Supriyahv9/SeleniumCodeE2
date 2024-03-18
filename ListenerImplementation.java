package CommonUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerImplementation implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("testscript execution is started");
		Reporter.log("Testscript execution is Started",true);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	//System.out.println("testscript is passed");	
		Reporter.log("Testscript execution is Pass",true);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("testscript is failed");
		Reporter.log("Testscript execution is Fail",true);
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("testscript is skipped");
		Reporter.log("Testscript execution is Skip",true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
