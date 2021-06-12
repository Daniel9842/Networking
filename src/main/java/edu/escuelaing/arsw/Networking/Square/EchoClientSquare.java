package edu.escuelaing.arsw.Networking.Square;

import java.io.*;
import java.net.*;

//Code implemented in class with the teacher  

/**
 * 
 *this class is the Square client that will ask the server for a request,the request will be the square of a number
 * @author Daniel Santiago Ducuara Ardila
 */
public class EchoClientSquare {
	/**
	 * This method creates the link bound to port 35000 to connect to the server and sends the requests to the server
	 * @param args client variable
	 * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
	 */
	public static void main(String[] args) throws IOException {

		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			echoSocket = new Socket("127.0.0.1", 35000);
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don’t know about host!.");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn’t get I/O for " + "the connection to: localhost.");
			System.exit(1);
		}
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String userInput;
		System.out.println("Por favor digite un número");
		while ((userInput = stdIn.readLine()) != null) {
			out.println(userInput);
			System.out.println("echo: " + in.readLine());
			if (userInput.equals("Bye.")) {
				System.out.println("Cerrando la aplicación");
				break;
			}
		}
		out.close();
		in.close();
		stdIn.close();
		echoSocket.close();
	}
}