package edu.escuelaing.arsw.Networking.Url;

import java.io.*;
import java.net.*;
/**
 * This class prints what the methods return to read url information
 * @author Daniel Santiago Ducuara Ardila
 *
 */
public class URLReader {
	/**
	 * this method receives a url and obtains the data to save it in a file
	 * @param args is the url from which you want to obtain the data.
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		URL url = new URL(args[0]);
		String data = "";
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
			String inputLine = null;
			while ((inputLine = reader.readLine()) != null) {
				data+=inputLine;
			}
		} catch (IOException x) {
			System.err.println(x);
		}
		WriteFile(data);
	}
	/**
	 * this method creates an html file with the information obtained
	 * @param data is the information obtained from the url
	 */
	public static void WriteFile(String data) {
		try {
            PrintWriter writer = new PrintWriter("./resultado.html", "UTF-8");
            writer.println(data);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}