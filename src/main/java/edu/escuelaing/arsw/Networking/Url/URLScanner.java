package edu.escuelaing.arsw.Networking.Url;

import java.net.MalformedURLException;
import java.net.URL;
/**
 * This class prints what the methods return to read url information
 * @author Daniel Santiago Ducuara Ardila
 *
 */
public class URLScanner {
	/**
	 * this method receives the url and prints its information
	 * @param args is the url from which you want to obtain the information
	 * @throws MalformedURLException Thrown to indicate that a malformed URL has occurred.
	 */
	public static void main(String[] args) throws MalformedURLException {
		
		System.out.println(MethodsValue(args[0]));
	}
	
	public static String MethodsValue(String url) throws MalformedURLException {
		URL personalSite = new URL(url);
		return 	"ref: "+personalSite.getProtocol()
		+"authority: "+personalSite.getAuthority()
		+"host: "+personalSite.getHost()
		+"port: "+personalSite.getPort()
		+"path: "+personalSite.getPath()
		+"query: "+personalSite.getQuery()
		+"file: "+personalSite.getFile()
		+"ref: "+personalSite.getRef();
		
	}
	
	
}
