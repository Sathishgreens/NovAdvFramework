package org.runnerclass;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junitsample.AdactinApp;
import org.junitsample.Sample;

//SuiteLevel

@RunWith(Suite.class)
@SuiteClasses({Sample.class,AdactinApp.class})
public class SuiteExecution {

}
