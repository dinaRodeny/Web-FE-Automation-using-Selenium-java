package driver;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.MyLogger;

public class ChromeManager extends BrowserFactory{
	@Override
	protected WebDriver Driversetup() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver(getOptions());
	}
	
	@Override
	protected ChromeOptions getOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        MyLogger.info("Add arguments for Chrome options");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
        return chromeOptions;
    }
}
