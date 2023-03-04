package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFIleHandler {
	//load properties file from folder
	public Properties loadProperties(String recourcename) throws IOException
	{
		Properties prop = new Properties();
		MyLogger.info("get as FileInputStream property file -> " + recourcename);
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/configurations/"+(recourcename)+".properties");
		MyLogger.info("load property file -> " + recourcename);
		prop.load(fis); 
		return prop;
	}
}
