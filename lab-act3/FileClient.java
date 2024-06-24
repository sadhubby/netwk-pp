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
		String sServerAddress = args[0]; //localhost
		int nPort = Integer.parseInt(args[1]); //4000
		
		try
		{
			Socket clientEndpoint = new Socket(sServerAddress, nPort);
			
			System.out.println("Client: Connected to server at" + clientEndpoint.getRemoteSocketAddress());
			
			DataOutputStream dosWriter = new DataOutputStream(clientEndpoint.getOutputStream());
			dosWriter.writeUTF("Client: Hello from client" + clientEndpoint.getLocalSocketAddress());
			
			DataInputStream disReader = new DataInputStream(clientEndpoint.getInputStream());
			System.out.println(disReader.readUTF()); //Hello World
			
			//
            int length = disReader.readInt(); // length of hello world
            byte[] buffer = new byte[length]; //makes Hello World! into bytes
            disReader.readFully(buffer); // reads the bytes 

            FileOutputStream fos = new FileOutputStream("Received.txt"); //makes new Received.txt file 
            fos.write(buffer); //writes the bytes in buffer to fos object which is the Received.txt file
            fos.close();    

            System.out.println("Client: Downloaded file Received.txt");


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