package Hard;

import java.io.*;
import java.net.*;

public class HTTPServer {
	public static void main(String[] args) throws IOException{
		int port = 8080;
		
		System.out.println("5.Building a simple HTTP Server in java");
		
		try(ServerSocket serverSocket = new ServerSocket(port)){
			System.out.println("HTTP Server started on port" + port);
			
			while(true) {
				Socket ClientSocket = serverSocket.accept(); 
				handleClient(ClientSocket);
			}
		}
	}

	private static void handleClient(Socket ClientSocket) throws IOException{
		try(BufferedReader in = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream())) ;
			OutputStream out = ClientSocket.getOutputStream()) {
			
			String requestLine = in.readLine();
			
			String line;
			while((line = in.readLine()) != null && !line.isEmpty()) { }
			
			String body = "Hello! This is a simple HTTP Server in java.\n";
			byte[] bodyBytes = body.getBytes("UTF-8");
			
			String response = 
					"HTTP/1.1 200 OK\r\n" + "content-Type: text/plain; charset=UTF-8/r/n" + "Connection: close\r\n" + "\r\n";
			
			out.write(response.getBytes("UTF-8"));
			out.write(bodyBytes);
			out.flush();
			}
		finally {
			ClientSocket.close();
		}
				
		}
		}

		
	



		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
