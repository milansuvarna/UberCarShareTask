package runnerFile;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import stepDef.BaseClass;


@CucumberOptions(features="src/test/resources/Features",
	tags="@tag1",
	glue= {"stepDef"},
	plugin = {"pretty", "html:target/cucumber-report.html"},
	monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests{
	
	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass(alwaysRun=true)
	public void setUpClass()
	{
		testNGCucumberRunner=new TestNGCucumberRunner(this.getClass());
		//BaseClass.getDriver();
	}
	
	@Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
	   testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
	}

	@DataProvider
	public Object[][] scenarios() {
	   return testNGCucumberRunner.provideScenarios();
	}
	   
	@AfterClass(alwaysRun=true)
	public void tearDown()
	{
		testNGCucumberRunner.finish();
		BaseClass.tearDown();
	}

}
