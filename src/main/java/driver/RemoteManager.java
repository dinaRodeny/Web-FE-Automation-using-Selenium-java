package driver;

import java.net.URL;
import java.net.UnknownHostException;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import Environments.Environment;
import pages.TestBase;
import utils.ListenToIPAddress;
import utils.MyLogger;

public class RemoteManager extends TestBase{
	private Environment env;
	private String getip;
	public RemoteManager(Environment env) {
		this.env = env;
		try {
			MyLogger.info("get ip from Environment variable or current Host");
			getip = new ListenToIPAddress().GetMyIpAddress();
		} catch (UnknownHostException e) {
			MyLogger.error("there is UnknownHostException issue Please Investegate this");
		}
	}
	
	public RemoteWebDriver createRemoteInstance(MutableCapabilities capability) {
		RemoteWebDriver remoteWebDriver = null;
	    try {
	    	MyLogger.info("Save URL and port for Grid -> " + getip + env.getgridport());
	        String gridURL = String.format("http://%s:%s/wd/hub", getip, env.getgridport());
	        MyLogger.info("send URL and port and capability to remote driver");
	        remoteWebDriver = new RemoteWebDriver(new URL(gridURL), capability);
	    } catch (java.net.MalformedURLException e) {
	    	MyLogger.error("there is java.net.MalformedURLException issue Please Investegate this");
	    } catch (IllegalArgumentException e) {
	    	MyLogger.error("there is IllegalArgumentException issue Please Investegate this");
	    }
	    return remoteWebDriver;
	}
}