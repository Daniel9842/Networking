package edu.escuelaing.arsw.Networking.Calculator;

import java.net.*;
import java.io.*;
	
//Code implemented in class with the teacher 

/**
 * this class is the calculator server that will respond to a request from the client,the answer will be to perform a trigonometric function
 * @author Daniel Santiago Ducuara Ardila
 *
 */
public class EchoServerCalculator {
	//this variable stores the type of function
	public static String operation = "fun:cos";
	/**
	 * This method creates the link linked to port 35000 to connect with the client and reads the requests made by the client.
	 * @param args server variable
	 * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
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
			outputLine = calculateFunctions(inputLine);
			out.println(outputLine);
		}
		System.out.println("Cerrando el servidor");
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}
	
	/**
	 * This method is responsible for making an operation change or performing the trigonometric operation
	 * @param inputLine are the numbers or functions requested by the server.
	 * @return the result of the trigonometric operation
	 */
	public static String calculateFunctions(String inputLine) {
		String outputLine="";
		if(inputLine.equals("fun:sin") || inputLine.equals("fun:tan") || inputLine.equals("fun:cos")) {
			operation = inputLine;
			outputLine = "Realizando cambio de operación";
		}else {
			if(operation.equals("fun:cos")) {
				outputLine = String.valueOf(Math.cos(Math.toRadians(Double.parseDouble(inputLine))));
			}else if(operation.equals("fun:sin")) {
				outputLine = String.valueOf(Math.sin(Math.toRadians(Double.parseDouble(inputLine))));
			}else if(operation.equals("fun:tan")) {
				outputLine = String.valueOf(Math.tan(Math.toRadians(Double.parseDouble(inputLine))));
			}
		}
		return outputLine;
	}
	/**
	 * this method was done for testing
	 * @param operation is the trigonometric function
	 * @param number in the trigonometric operation
	 * @return the value of the function
	 */
	public static String makeOperation(String operation,String number) {
		calculateFunctions(operation);
		return calculateFunctions(number);
	}
}

