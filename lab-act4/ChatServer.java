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
		
			
			while(true){
				serverSocket = new ServerSocket(nPort);
				System.out.println("Server: Listening on port " + args[0] + "...");
				serverEndpoint = serverSocket.accept();
				System.out.println("Server: New client connected: " + serverEndpoint.getRemoteSocketAddress());
				DataInputStream disReader = new DataInputStream(serverEndpoint.getInputStream());
				System.out.println(disReader.readUTF());
				System.out.println(disReader.readUTF());
			}
			


		//	DataOutputStream dosWriter = new DataOutputStream(serverEndpoint.getOutputStream());
		//	dosWriter.writeUTF("Server: Hello World!");

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