package Hard;

import java.io.*;
import java.net.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiClientChatApplication {
	public static void main(String[] args) {
		System.out.println("Multi-Client Chat Application Using Sockets");
		
		int port = 12345;
		Server server = new Server(port);
		server.start();
		
	}
	static class Server{
		private final int port;
		private ServerSocket serverSocket;
		private final AtomicInteger clientCounter = new AtomicInteger(1);
		
		Server(int port) {
			this.port = port;
		}
		
		void start() {
			try {
				serverSocket = new ServerSocket(port);
				System.out.println("Server started on port" + port);
				
				while(true) {
					Socket clientSocket = serverSocket.accept();
					int clientId = clientCounter.getAndIncrement();
					System.out.println("Client connected: #" + clientId);
					
					Thread t = new Thread(new ClientHandler(clientSocket, clientId));
					t.start();
					
					
				}
				
			}catch(IOException e) {
				System.out.println("Server error: " + e.getMessage());
				}
			finally {
				if (serverSocket != null) {
					try { serverSocket.close();
				}
					catch(IOException Ignored) {}
			}
		}
		
	}
		
	}
	static class ClientHandler implements Runnable {
		private final Socket socket;
		private final int clientId;
		
		ClientHandler(Socket socket, int clientId){ 
			this.socket = socket;
			this.clientId = clientId;
		}
		
		public void run() {
			try(BufferedReader in = new BufferedReader(new
					InputStreamReader(socket.getInputStream()));
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true)){
				
				out.println("Welcome, you are client #" + clientId);
				out.println("Type messages and press Enter. Type /quit to disconnect.");
				
				String line;
				while((line = in.readLine()) !=null) {
					if(line.trim().equalsIgnoreCase("/quit")){
						out.println("Goodbye!");
						break;
						
					}
					System.out.println("Client #" + clientId + line);
					out.println("Server received: " + line);
							
				}
				
			}
			catch(IOException e) { 
				System.out.println("Client #" + clientId + "disconnected:" + e.getMessage());
				
				
			}
			finally {
				try { socket.close();} catch(IOException ignored) {}
			}
				
					
					
		}
			
		}
	
	}
		















