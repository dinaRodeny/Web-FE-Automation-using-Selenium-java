package driver;

import java.util.HashMap;
import java.util.Map;

import utils.MyLogger;


public class BrowserFactoryManager {
	private BrowserFactory Chrome = new ChromeManager();
	private BrowserFactory Edge =  new EdgeManager();
	private BrowserFactory Firefox =  new FireFoxManager();
	private Map<String, BrowserFactory> map = new HashMap<>();
	
	{
		map.put("Chrome",Chrome);
		map.put("Edge",Edge);
		map.put("Firefox",Firefox);	
	}
	
	public BrowserFactory get(String param)
	{
		MyLogger.info("get the browser Manager from the parameter passed -> " + param);
		return map.get(param);

	}
}
