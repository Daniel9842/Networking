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
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException {
		URL personalSite = new URL(args[0]);
		
		System.out.println("ref: "+personalSite.getProtocol());
		System.out.println("authority: "+personalSite.getAuthority());
		System.out.println("host: "+personalSite.getHost());
		System.out.println("port: "+personalSite.getPort());
		System.out.println("path: "+personalSite.getPath());
		System.out.println("query: "+personalSite.getQuery());
		System.out.println("file: "+personalSite.getFile());
		System.out.println("ref: "+personalSite.getRef());
		
	}
	
	
}
