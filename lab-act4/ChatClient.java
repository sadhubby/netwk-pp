/*
Group Members:
De Guzman, Evan Mari 
Dimaculangan, Aldwin Renzel
Javier, Devon Jarek  
 */

import java.net.*;
import java.io.*;

public class ChatClient
{
	public static void main(String[] args)
	{
		String sServerAddress = args[0]; 
		int nPort = Integer.parseInt(args[1]);
		String username = args[2]; 
		String message = args[3]; 
		
		try
		{
			Socket clientEndpoint = new Socket(sServerAddress, nPort);
		
			System.out.println(username + ": Connecting to server at \n" + clientEndpoint.getRemoteSocketAddress() + "\n");
			System.out.println(username + ": Connected to server at \n" + clientEndpoint.getRemoteSocketAddress() +"\n");
			DataOutputStream dosWriter = new DataOutputStream(clientEndpoint.getOutputStream());
			
			DataInputStream disReader = new DataInputStream(clientEndpoint.getInputStream());
			dosWriter.writeUTF(username); 
			dosWriter.writeUTF(message);
			
			String fromUsername = disReader.readUTF();
			String fromMessage = disReader.readUTF();
			System.out.println("Message from " + fromUsername + " : " + fromMessage +"\n");
			clientEndpoint.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println(username + ": Connection is terminated.");
		}
	}
}