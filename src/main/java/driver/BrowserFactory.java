package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;

import utils.MyLogger;

public abstract class BrowserFactory {
	protected WebDriver driver;
	protected abstract WebDriver Driversetup();
	
	public WebDriver getDriver()
	{
		MyLogger.info("Check if driver null");
		if(driver == null)
		{
			MyLogger.info("driver is null then setup driver");
			driver = Driversetup();
		}	
		return driver;
	}

	@SuppressWarnings("rawtypes")
	protected abstract AbstractDriverOptions getOptions();
}
