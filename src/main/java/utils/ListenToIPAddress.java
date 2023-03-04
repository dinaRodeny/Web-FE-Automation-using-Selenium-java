package utils;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ListenToIPAddress {
	public String GetMyIpAddress() throws UnknownHostException
	{	
		String result = System.getProperty("HUBHOST");
		if(result == null)
		{
			result = InetAddress.getLocalHost().getHostAddress();
			MyLogger.info("get ip from current host -> " + result);
		}
		else
		{
			MyLogger.info("get ip from Environment variable hub -> " + result);
		}
			
		return result;
	}
}
