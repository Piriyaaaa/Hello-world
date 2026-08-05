package Hard;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleEchoServer {
	public static void main(String[] args) {
		System.out.println("Creating a simple echo server in java");
		
		int port = 12345;
		try(ServerSocket serverSocket = new ServerSocket(port)){
			System.out.println("Echo system linstening on port" + port);
			
			while (true);
			Socket client = serverSocket.accept();
			System.out.println("Client connected: " + client.getRemoteSocketAddress());
			
			Thread t = new Thread(() -> handleClient(client));
			t.start();
			
		}
			
		} 
	   catch (IOException e) {
		   System.out.println("Server error:" + e.getMessage());
		
	   }

}


private static <BufferedReader> void handleClient(Socket client) {
	try(
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream())));
			PrinterWriter out = new PrinterWriter(client.getOutputStream(), true)){
				
				String line;
				while((line = in.readline())!= null) {
					out.println(line);
				}
			}
			catch (IOException ignored) {
			
			}
				finally {
					
					try {client.close();} 
					catch (IOException ignored) {}
				}
			}

}
