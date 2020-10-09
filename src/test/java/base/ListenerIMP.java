package base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenerIMP extends ExtentManager implements ITestListener {
	@Override		
	public void onFinish(ITestContext arg0) {					
		   flushReport();				

	}		

	@Override		
	public void onStart(ITestContext arg0) {					
		
		set();
	}		

	@Override		
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					


	}		

	@Override		
	public void onTestFailure(ITestResult arg0) {					
		test.log(Status.FAIL, arg0.getMethod().getMethodName()+" is failed");

	}		

	@Override		
	public void onTestSkipped(ITestResult arg0) {					
		test.log(Status.SKIP, arg0.getMethod().getMethodName()+" is skipped");

	}		

	@Override		
	public void onTestStart(ITestResult arg0) {
		test=reports.createTest(arg0.getMethod().getMethodName());	
	}		

	@Override		
	public void onTestSuccess(ITestResult arg0) {					
		test.log(Status.PASS, arg0.getMethod().getMethodName()+" is passed");

	}		


}
