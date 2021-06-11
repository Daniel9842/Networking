package edu.escuelaing.arsw.Networking.HttpServer;

import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.*;


//Code implemented in class with the teacher

public class HttpServer {
	private static HttpServer _instance = new HttpServer();

	private HttpServer() {
	}

	private static HttpServer getInstance() {
		return _instance;
	}

	public static void main(String[] args) throws IOException {
		HttpServer.getInstance().startServer(args);
	}

	public void startServer(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(35000);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 35000.");
			System.exit(1);
		}
		Socket clientSocket = null;
		boolean running=true;
		while (running) {
			try {
				System.out.println("Listo para recibir ...");
				clientSocket = serverSocket.accept();
			} catch (IOException e) {
				System.err.println("Accept failed.");
				System.exit(1);
			}
			processRequest(clientSocket);
		}
		serverSocket.close();
	}

	public void processRequest(Socket clientSocket) throws IOException {
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String inputLine;
		String method="";
		String path="";
		String version="";
		List<String> headers = new ArrayList<String>();
		while ((inputLine = in.readLine()) != null) {
			if(method.isEmpty()) {
				String[] requestStrings = inputLine.split(" ");
				method = requestStrings[0];
				path = requestStrings[1];
				version = requestStrings[2];
				System.out.println("Request: " + method + "" + path + "" + version);
			}else {
				System.out.println("Header: " + inputLine);
				headers.add(inputLine);
			}
			
			if (!in.ready()) {
				break;
			}
		}
		String responseMsg = createTextResponse(path);
		out.println(responseMsg);
		out.close();
		in.close();
		clientSocket.close();
	}
	
	public String createTextResponse(String path) {
		String type = "text/html";
		if(path.endsWith(".css")) {
			type = "text/css";
		}else if(path.endsWith(".js")) {
			type = "text/javascript";
		}
		Path file = Paths.get("."+path);
		Charset charset = Charset.forName("UTF-8");
		String outmsg="";
		try(BufferedReader reader = Files.newBufferedReader(file,charset)){
			String line = null;
			while((line=reader.readLine())!=null) {
				System.out.println(line);
				outmsg = outmsg + "\r\n"+ line;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return"HTTP/1.1 200 OK\r\n"
                + "Content-Type: "+ type +"\r\\n"
                + "\r\n"
                + outmsg;
	}
}
