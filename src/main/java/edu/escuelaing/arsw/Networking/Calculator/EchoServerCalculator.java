package edu.escuelaing.arsw.Networking.Calculator;

import java.net.*;
import java.io.*;

//parte del código realizado en clase con el profesor 

public class EchoServerCalculator {
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
		String operation = "fun:cos";
		while ((inputLine = in.readLine()) != null) {
			if (inputLine.equals("Bye.")) break;
			System.out.println("Mensaje recibido: " + inputLine);
			outputLine = "";
			if(inputLine.equals("fun:sin") || inputLine.equals("fun:tan") || inputLine.equals("fun:cos")) {
				operation = inputLine;
				outputLine = "Realizando cambio de operación";
			}else {
				if(operation.equals("fun:cos")) {
					outputLine = String.valueOf(Math.cos(Double.parseDouble(inputLine)));
				}else if(operation.equals("fun:sin")) {
					outputLine = String.valueOf(Math.sin(Double.parseDouble(inputLine)));
				}else if(operation.equals("fun:tan")) {
					outputLine = String.valueOf(Math.tan(Double.parseDouble(inputLine)));
				}
			}
			out.println(outputLine);
		}
		System.out.println("Cerrando el servidor");
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}
}

