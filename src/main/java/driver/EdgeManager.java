package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.MyLogger;

public class EdgeManager extends BrowserFactory{
	@Override
	public WebDriver Driversetup() {
		WebDriverManager.edgedriver().setup();
		return new EdgeDriver(getOptions());
	}
	
	@Override
	protected EdgeOptions getOptions() {
		EdgeOptions edgeoptions = new EdgeOptions();
		MyLogger.info("Add arguments for Edge options");
		edgeoptions.addArguments("--start-maximized");
		edgeoptions.addArguments("--disable-infobars");
		edgeoptions.addArguments("--disable-notifications");
        return edgeoptions;
	}
}
