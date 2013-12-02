package peony.asserts;

import java.util.Arrays;
import java.util.List;

import ulive.util.UliveBaseClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class PeonyAssertionListener implements IInvokedMethodListener {
	Logger logger = LogManager.getLogger(UliveBaseClass.class);

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		logSoftAssertsPassed(testResult);
		logSoftAssertsFailures(testResult);
	}

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
	}

	private void logSoftAssertsFailures(ITestResult testResult) {
		PeonyAssertionResult temporaryTestResult = null;
		Throwable eachFailure = null;
		Throwable lastFailure = null;
		Throwable consolidatedFailures = null;
		String msg = null;
		StringBuffer failureMessage = null;
		String fullStackTrace = null;
		Reporter.setCurrentTestResult(testResult);
		List verificationFailures = PeonyAssertion.getVerificationFailures();

		if (verificationFailures.size() > 0) {
			testResult.setStatus(2);
			if (!(Arrays.asList(testResult.getThrowable().getStackTrace())
					.equals(Arrays
							.asList(((PeonyAssertionResult) verificationFailures
									.get(verificationFailures.size() - 1))
									.getTestResult().getStackTrace())))) {
				verificationFailures.add(new PeonyAssertionResult(testResult
						.getThrowable(), testResult.getThrowable().toString()));

			}

			int size = verificationFailures.size();

			if (size == 1) {
				temporaryTestResult = (PeonyAssertionResult) verificationFailures
						.get(0);
				eachFailure = temporaryTestResult.getTestResult();
				msg = temporaryTestResult.getMessage();
				failureMessage = new StringBuffer();
				failureMessage.append("1 FAILURE IN THE TEST CASE\n\n");
				failureMessage.append("  ***").append(msg).append("***  ");
				consolidatedFailures = new Throwable(failureMessage.toString());
				consolidatedFailures.setStackTrace(eachFailure.getStackTrace());
				testResult.setThrowable(consolidatedFailures);

			} else {
				failureMessage = new StringBuffer(size
						+ " FAILURES IN THE TEST CASE").append(":\n\n");
				for (int i = 0; i < size - 1; ++i) {
					failureMessage.append("Failure ").append(i + 1)
							.append(" of ").append(size).append(":\n");
					temporaryTestResult = (PeonyAssertionResult) verificationFailures
							.get(i);
					eachFailure = temporaryTestResult.getTestResult();
					msg = temporaryTestResult.getMessage();
					fullStackTrace = org.testng.internal.Utils.stackTrace(
							eachFailure, false)[1];
					failureMessage.append("  ***").append(msg).append("***  ");
					failureMessage.append(fullStackTrace).append("\n\n");

				}

				String classtype = ((PeonyAssertionResult) verificationFailures
						.get(size - 1)).getClass().getSimpleName();

				if (classtype.equalsIgnoreCase("AssertionError")) {
					eachFailure = ((PeonyAssertionResult) verificationFailures
							.get(size - 1)).getTestResult();
					fullStackTrace = org.testng.internal.Utils.stackTrace(
							eachFailure, false)[1];
					failureMessage.append("Failure ").append(size)
							.append(" of ").append(size).append(":\n");
					failureMessage.append(fullStackTrace);
					consolidatedFailures = new Throwable(
							failureMessage.toString());
					consolidatedFailures.setStackTrace(eachFailure
							.getStackTrace());
					testResult.setThrowable(consolidatedFailures);
				} else {
					temporaryTestResult = (PeonyAssertionResult) verificationFailures
							.get(size - 1);
					lastFailure = temporaryTestResult.getTestResult();
					msg = temporaryTestResult.getMessage();
					failureMessage.append("Failure ").append(size)
							.append(" of ").append(size).append(":\n");
					failureMessage.append(" ***").append(msg).append("***  ");
					failureMessage.append(lastFailure.toString());

					consolidatedFailures = new Throwable(
							failureMessage.toString());
					consolidatedFailures.setStackTrace(lastFailure
							.getStackTrace());
					testResult.setThrowable(consolidatedFailures);
				}
			}
		}

	}

	private void logSoftAssertsPassed(ITestResult testResult) {
		PeonyAssertionResult temporaryTestResult = null;
		String msg = null;
		String methodName = testResult.getMethod().getMethodName();
		Reporter.setCurrentTestResult(testResult);
		List verificationPassed = PeonyAssertion.getVerificationPassed();
		int size = verificationPassed.size();

		if (size == 1) {
			temporaryTestResult = (PeonyAssertionResult) verificationPassed
					.get(0);
			msg = temporaryTestResult.getMessage();
			String eachPassMsg = "1 PASSED IN THE TEST CASE: " + methodName
					+ "\n";
			Reporter.log(eachPassMsg + " ***" + msg + "*** ", true);

		} else {
			if (size > 1) {
				String successMessage = size + " PASSED IN THE TEST CASE:"
						+ methodName + "\n";
				Reporter.log(successMessage, true);
			}

			for (int i = 0; i < size - 1; ++i) {
				String eachPassMsg = "Passed " + (i + 1) + " of " + size + ":";
				temporaryTestResult = (PeonyAssertionResult) verificationPassed
						.get(i);
				msg = temporaryTestResult.getMessage();
				Reporter.log(eachPassMsg + "  ***" + msg + "***  ", true);
			}

			if (size > 0) {
				temporaryTestResult = (PeonyAssertionResult) verificationPassed
						.get(size - 1);
				msg = temporaryTestResult.getMessage();
				Reporter.log("Passed " + size + " of " + size + ":" + " ***"
						+ msg + "*** \n", true);
			}
		}

	}
}
