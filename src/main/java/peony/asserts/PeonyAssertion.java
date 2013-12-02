package peony.asserts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

public class PeonyAssertion {

	private static Map<ITestResult, List<PeonyAssertionResult>> verificationFailuresMap = new HashMap();
	private static Map<ITestResult, List<PeonyAssertionResult>> verificationPassedMap = new HashMap();
	private static String defaultMessage = "Assertion passed";

	public static List<PeonyAssertionResult> getVerificationPassed() {
		List verificationPassed = (List) verificationPassedMap.get(Reporter
				.getCurrentTestResult());
		verificationPassed = (verificationPassed == null) ? new ArrayList()
				: verificationPassed;
		return verificationPassed;
	}

	private static void addVerificationPassed(String message) {
		List verificationPassed = getVerificationPassed();
		verificationPassedMap.put(Reporter.getCurrentTestResult(),
				verificationPassed);
		verificationPassed.add(new PeonyAssertionResult(null, message));
		;
	}

	public static List<PeonyAssertionResult> getVerificationFailures() {
		List verificationFailures = (List) verificationFailuresMap.get(Reporter
				.getCurrentTestResult());
		verificationFailures = (verificationFailures == null) ? new ArrayList()
				: verificationFailures;
		return verificationFailures;
	}

	private static void addVerificationFailures(Throwable e, String message) {
		List verificationFailures = getVerificationFailures();
		verificationFailuresMap.put(Reporter.getCurrentTestResult(),
				verificationFailures);

		ITestResult result = Reporter.getCurrentTestResult();
		result.setThrowable(e);
		verificationFailures.add(new PeonyAssertionResult(e, message));
		;
	}

	public static Map<ITestResult, List<PeonyAssertionResult>> getVerificationFailuresMap() {
		return verificationFailuresMap;
	}

	public static void assertTrue(boolean condition) {
		Assert.assertTrue(condition);
		addVerificationPassed(defaultMessage);
	}

	public static void assertTrue(boolean condition, String msg) {
		Assert.assertTrue(condition, msg);
		addVerificationPassed(msg);
	}

	public static void assertFalse(boolean condition) {
		Assert.assertFalse(condition);
		addVerificationPassed(defaultMessage);
	}

	public static void assertFalse(boolean condition, String msg) {
		Assert.assertFalse(condition, msg);
		addVerificationPassed(msg);
	}

	public static void assertEquals(Object actual, Object expected) {
		Assert.assertEquals(actual, expected);
		addVerificationPassed("Actual: " + actual.toString()
				+ " matches Expected: " + expected.toString());
	}

	public static void assertEquals(String actual, String expected) {
		Assert.assertEquals(actual, expected);
		addVerificationPassed("Actual: " + actual + " matches Expected: "
				+ expected);
	}

	public static void assertEquals(String actual, String expected, String msg) {
		Assert.assertEquals(actual, expected, msg);
		addVerificationPassed(msg);
	}

	public static void verifyTrue(boolean condition, String msg) {
		try {
			Assert.assertTrue(condition);
			addVerificationPassed(msg);
		} catch (Throwable e) {
			addVerificationFailures(e, msg);
		}
	}

	public static void verifyTrue(boolean condition) {
		try {
			Assert.assertTrue(condition);
			addVerificationPassed(defaultMessage);
		} catch (Throwable e) {
			addVerificationFailures(e, "");
		}
	}

	public static void verifyFalse(boolean condition, String msg) {
		try {
			Assert.assertFalse(condition);
			addVerificationPassed(msg);
		} catch (Throwable e) {
			addVerificationFailures(e, msg);
		}
	}

	public static void verifyFalse(boolean condition) {
		try {
			Assert.assertFalse(condition);
			addVerificationPassed(defaultMessage);
		} catch (Throwable e) {
			addVerificationFailures(e, "");
		}
	}

	public static void verifyEquals(Object actual, Object expected, String msg) {
		try {
			Assert.assertEquals(actual, expected);
			addVerificationPassed(msg);
		} catch (Throwable e) {
			addVerificationFailures(e, msg);
		}

	}

	public static void verifyEquals(Object actual, Object expected) {
		try {
			Assert.assertEquals(actual, expected);
			addVerificationPassed("Actual: " + actual.toString()
					+ " matches Expected: " + expected.toString());
		} catch (Throwable e) {
			addVerificationFailures(e, "");
		}
	}

	public static void fail(String msg) {
		Assert.fail(msg);
	}

	public static void fail(Throwable e, String msg) {
		addVerificationFailures(e, msg);
	}
}
