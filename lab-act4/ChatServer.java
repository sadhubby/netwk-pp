/*
Group Members:
De Guzman, Evan Mari 
Dimaculangan, Aldwin Renzel
Javier, Devon Jarek  
 */

import java.net.*;
import java.io.*;

public class ChatServer
{
	public static void main(String[] args)
	{
		
		
		int nPort = Integer.parseInt(args[0]);
		ServerSocket serverSocket;
		Socket serverEndpoint_1;
		Socket serverEndpoint_2;	
		int flag = 1;
		try 
		{				
				serverSocket = new ServerSocket(nPort);
			
			while(flag == 1){

				System.out.println("Server: Listening on port " + args[0] + "...");
				serverEndpoint_1 = serverSocket.accept();
				serverEndpoint_1.setKeepAlive(true);
				DataOutputStream dosWriter_1 = new DataOutputStream(serverEndpoint_1.getOutputStream());
				System.out.println("\nServer: New client connected: " + serverEndpoint_1.getRemoteSocketAddress());
				DataInputStream disReader_1 = new DataInputStream(serverEndpoint_1.getInputStream());

				String username_1 = disReader_1.readUTF();
				String message_1 = disReader_1.readUTF();

				System.out.println("\nServer: Listening on port " + args[0] + "...");
				serverEndpoint_2 = serverSocket.accept();
				serverEndpoint_2.setKeepAlive(true);
				DataOutputStream dosWriter_2 = new DataOutputStream(serverEndpoint_2.getOutputStream());
				System.out.println("\nServer: New client connected: " + serverEndpoint_2.getRemoteSocketAddress());
				DataInputStream disReader_2 = new DataInputStream(serverEndpoint_2.getInputStream());

				String username_2 = disReader_2.readUTF();
				String message_2 = disReader_2.readUTF();
				
				dosWriter_1.writeUTF(username_2);
				dosWriter_1.writeUTF(message_2);

				dosWriter_2.writeUTF(username_1);
				dosWriter_2.writeUTF(message_1);

				serverEndpoint_1.close();
				serverEndpoint_2.close();
				flag = 0;
		}
	}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("\nServer: Connection terminated.");
		}
	}
}