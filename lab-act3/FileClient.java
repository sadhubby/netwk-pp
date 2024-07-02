/*
Group Members:
De Guzman, Evan Mari 
Dimaculangan, Aldwin Renzel
Javier, Devon Jarek  
 */


import java.net.*;
import java.io.*;

public class FileClient
{
	public static void main(String[] args)
	{
		String sServerAddress = args[0]; 
		int nPort = Integer.parseInt(args[1]); 
		
		try
		{
			Socket clientEndpoint = new Socket(sServerAddress, nPort);
			System.out.println("Client: Connecting to server at " + clientEndpoint.getRemoteSocketAddress() + "\n");
			System.out.println("Client: Connected to server at " + clientEndpoint.getRemoteSocketAddress() + "\n");
			
			DataOutputStream dosWriter = new DataOutputStream(clientEndpoint.getOutputStream());
			
			DataInputStream disReader = new DataInputStream(clientEndpoint.getInputStream());
			
			//
            int length = disReader.readInt(); 
            byte[] buffer = new byte[length]; 
            disReader.readFully(buffer); 

            FileOutputStream fos = new FileOutputStream("Received.txt"); 
            fos.write(buffer); 
            fos.close();    

            System.out.println("Client: Downloaded file \"Received.txt\"\n");


			clientEndpoint.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Client: Connection is terminated.");
		}
	}
}