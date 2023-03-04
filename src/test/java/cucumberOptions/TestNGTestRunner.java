package cucumberOptions;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.java.BeforeAll;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import pages.TestBase;

@CucumberOptions(features="src/test/java/features",glue ={"stepDefinitions"}
,monochrome=true,
plugin= {"pretty", "html:target/cucumber", "json:target/cucumber-report.json"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	static TestBase testBase = new TestBase();
	
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
	@BeforeAll
    @Parameters(value = {"browser"})
    public static void setUp(@Optional("Chrome") String browser) throws IOException {
		testBase.InitializeEnvironment(browser);
    }
}
