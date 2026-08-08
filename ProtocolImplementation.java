package Hard;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
	

public class ProtocolImplementation {
	public static void main(String[] args) {
		System.out.println("File Transfer Protocol Implementation with Sockets");
		
		
		if(args.length < 2) {
			System.out.println("Usage:");
			System.out.println(" Server: java ProtocolImplemetation server<port>");
			System.out.println(" Client: java ProtocolImplementation client<host><port><filepath>");
			
		return;
		}
		String mode = args[0].toLowerCase();
		try {
			if (mode.equals("server")) {
				int port = Integer.parseInt(args[1]);
				runServer(port);
				
			}
			else if (mode.equals("client")) {
				if (args.length < 4) {
					System.out.println("Usage:");
					System.out.println(" Client: java ProtocolImplementation client<host><port><filepath>");
					 return;
				}
				String host = args[1];
				int port = Integer.parseInt(args[2]);
				String filepath = args[3];
				runClient(host, port, filepath);
				
			}
			else { 
				System.out.println("Unkhown mode. Use sever or client.");
				
			}
			
		}catch(Exception e) {
			System.out.println("Error:" + e.getMessage());
			e.printStackTrace();
			
		}
	}
	private static void runServer(int port) throws IOException {
		try (ServerSocket serverSocket = new ServerSocket(port)){
			System.out.println("Server listening on port" + port + "...");
			
			try (Socket socket = serverSocket.accept()){
				System.out.println("Client connected:" + socket.getRemoteSocketAddress());
				
				InputStream in = socket.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				
				String command = reader.readLine();
				if (command == null) {
					System.out.println("Unsupported/empty command:" + command);
					return;
				}
				
				String[] parts = command.split("\\s+", 2);
				if (parts.length !=2 || !parts[0].equalsIgnoreCase("UPLOAD")) {
					DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
					dos.writeUTF("Error: Expected: UPLOAD <filename>");
				
					
				}
				String filename = parts[1].trim();
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				long fileSize = dis.readLong();
				
				File outFile = new File(filename);
				System.out.println("Recieving file: " + outFile.getAbsolutePath());
				receiveFile(dis, outFile, fileSize);
				
				dos.writeUTF("OK: Uploaded" + filename);
				System.out.println("Upload complete:" + filename);

			}
		}
	}


private static void runClient(String host, int port, String filepath) {
	File file = new File(filepath);
	if (!file.exists() || !file.isFile()) {
		System.out.println("Client: file not found" + file.getAbsolutePath());
		return;
	}
	try (Socket socket = new Socket(host, port);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8)
            );
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            FileInputStream fis = new FileInputStream(file)
       ) {
          
           writer.write("UPLOAD " + file.getName());
           writer.write("\n");
           writer.flush();

           
           dos.writeLong(file.length());
           dos.flush();

           System.out.println("Sending file: " + file.getName() + " (" + file.length() + " bytes)");

           sendFile(fis, socket.getOutputStream());

           // Read server response
           DataInputStream dis = new DataInputStream(socket.getInputStream());
           String response = dis.readUTF();
           System.out.println("Server response: " + response);

       } catch (Exception e) {
           System.out.println("Client error: " + e.getMessage());
           e.printStackTrace();
       }
   }

   private static void sendFile(FileInputStream fis, OutputStream out) throws IOException {
       byte[] buffer = new byte[8192];
       int n;
       while ((n = fis.read(buffer)) != -1) {
           out.write(buffer, 0, n);
       }
       out.flush();
   }

   private static void receiveFile(DataInputStream dis, File outFile, long fileSize) throws IOException {
       try (FileOutputStream fos = new FileOutputStream(outFile)) {
           byte[] buffer = new byte[8192];
           long remaining = fileSize;

           while (remaining > 0) {
               int toRead = (int) Math.min(buffer.length, remaining);
               int read = dis.read(buffer, 0, toRead);
               if (read == -1) break;
               fos.write(buffer, 0, read);
               remaining -= read;
           }
       }
   }

		
	}


 




















