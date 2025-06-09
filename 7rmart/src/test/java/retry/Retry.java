package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	int counter = 0;
	int retryLimit = 2;//here retry limit
	
	public boolean retry(ITestResult result) {

		if(counter < retryLimit)//0<2
		{
			counter++;
			return true;
		}
		return false;
	}
}




















//reexecute failed testcases
//wrong read from Excel cannot aply
//network not stable fail 
//one or more time we can reexecute
//site down issue one or more time execute we can use it
//incase test fail the li
//IRetryAnalyzer Interface is used