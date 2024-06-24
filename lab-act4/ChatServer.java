import java.net.*;
import java.io.*;

public class ChatServer
{
	public static void main(String[] args)
	{
		int nPort = Integer.parseInt(args[0]);
		
		ServerSocket serverSocket;
		Socket serverEndpoint;	
		try 
		{
				
				serverSocket = new ServerSocket(nPort);
				System.out.println("Server: Listening on port " + args[0] + "...");
				
		//	DataOutputStream dosWriter = new DataOutputStream(serverEndpoint.getOutputStream());
		//	dosWriter.writeUTF("Server: Hello World!");
			
			while(true){
				serverEndpoint = serverSocket.accept();
				serverEndpoint.setKeepAlive(true);

				System.out.println("Server: New client connected: " + serverEndpoint.getRemoteSocketAddress());
				DataInputStream disReader = new DataInputStream(serverEndpoint.getInputStream());
				System.out.println(disReader.readUTF()); //1
				System.out.println(disReader.readUTF()); //2
				
				// condition to check if name is the same or not, if not, send to this client. 


			}


		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Server: Connection is terminated.");
		}
	}
}