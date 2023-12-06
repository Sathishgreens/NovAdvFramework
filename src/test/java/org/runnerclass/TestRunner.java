package org.runnerclass;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junitsample.AdactinApp;
import org.junitsample.Sample;
//Using JUnitCore
public class TestRunner {
	
	public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(AdactinApp.class,Sample.class);
		
		List<Failure> failures = result.getFailures();
		
		for(Failure failure:failures) {
			
			String message = failure.getMessage();
			String trace = failure.getTrace();
			System.out.println(trace);
			
		}
		
		boolean wasSuccessful = result.wasSuccessful();
		System.out.println("Test Passed : "+wasSuccessful);
		
		
	}

}
