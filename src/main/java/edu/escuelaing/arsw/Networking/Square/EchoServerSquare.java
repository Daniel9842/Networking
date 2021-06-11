package edu.escuelaing.arsw.Networking.Square;

import java.net.*;
import java.io.*;

//Code implemented in class with the teacher 
/**
 * this class is the Square server that will respond to a request from the client,the answer will be the square of a number.
 * @author Daniel Santiago Ducuara Ardila
 *
 */
public class EchoServerSquare {
	/**
	 * This method creates the link linked to port 35000 to connect with the client and reads the requests made by the client.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(35000);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 35000.");
			System.exit(1);
		}
		Socket clientSocket = null;
		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String inputLine, outputLine;
		while ((inputLine = in.readLine()) != null) {
			if (inputLine.equals("Bye.")) break;
			System.out.println("Mensaje recibido: " + inputLine);
			int ResultOperation = Integer.parseInt(inputLine) * Integer.parseInt(inputLine);
			outputLine = "Respuesta desde servidor: " + Integer.toString(ResultOperation);
			;
			out.println(outputLine);
		}
		System.out.println("Cerrando el servidor");
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}
	
	
}

