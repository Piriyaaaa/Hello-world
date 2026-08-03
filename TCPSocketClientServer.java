package Hard;

import java.io.*;
import java.net.*;

public class TCPSocketClientServer {
	public static void main(String[] args) {
		System.out.println("Basic TPC Socket Client-Server Comminucation");
		if(args.length > 0 && args[0].equalsIgnoreCase("server")) {
			runServer();
			
		}
		else {
			runClient();
		}
	}
	private static void runServer() {
		int port = 5000;
		System.out.println("Server starting on port" + port + "...");
		
		try (ServerSocket serverSocket = new ServerSocket(port)){
			System.out.println("Wating for client connection...");
			
		try (Socket socket = serverSocket.accept();
				BufferedReader in = new BufferedReader(new
				InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true)){
			
			System.out.println("Client connected:" + socket.getInetAddress());
			
			String line = in.readLine();
			System.out.println("Client says: " + line);
			
			String response = "Server received: " + line;
			out.println(response);
			
			System.out.println("Response sent. Closing connection.");
		}
				
		}
		catch(IOException e) {
			System.out.println("Server error:" + e.getMessage());
		}
	}
	private static void runClient() {
		String host = "localhost";
		int port = 5000;
		
		System.out.println("Client connecting to" + host + "," + port + "...");
		
		
	try (Socket socket = new Socket(host, port);
			BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
		
		System.out.print("Enter message to send:");
		String message = consoleReader.readLine();
				out.println(message);
				
				String reply = in.readLine();
				System.out.println("Server reply:" + reply);
	}
	catch(IOException e) {
		System.out.println("Client error:" + e.getMessage());
	}
			
		
		
	}

}










