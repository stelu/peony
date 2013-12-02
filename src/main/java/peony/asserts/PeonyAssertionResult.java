package peony.asserts;

import org.testng.TestListenerAdapter;


public class PeonyAssertionResult extends TestListenerAdapter {
	
	private Throwable testResult;
	private String resultMessage;
	
	public PeonyAssertionResult() {
		this.testResult = null;
		this.resultMessage = null;
	}

	public PeonyAssertionResult(Throwable result, String message) {
		this.testResult = result;
		this.resultMessage = message;
	}
	
	public Throwable getTestResult() {
		return this.testResult;
	}
	
	public void setTestResult(Throwable result) {
		this.testResult = result;
	}
	
	public String getMessage() {
		return this.resultMessage;
	}
	
	public void setMessage(String message) {
		this.resultMessage = message;
	}
}
