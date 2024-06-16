/*
Group Members:
De Guzman, Evan Mari 
Dimaculangan, Renzel Aldwin
Javier, Devon Jarek Yumping 
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
			
			System.out.println("Client: Connected to server at" + clientEndpoint.getRemoteSocketAddress());
			
			DataOutputStream dosWriter = new DataOutputStream(clientEndpoint.getOutputStream());
			dosWriter.writeUTF("Client: Hello from client" + clientEndpoint.getLocalSocketAddress());
			
			DataInputStream disReader = new DataInputStream(clientEndpoint.getInputStream());
			System.out.println(disReader.readUTF());
			
            int length = disReader.readInt();
            byte[] buffer = new byte[length];
            disReader.readFully(buffer);

            FileOutputStream fos = new FileOutputStream("C:/Users/Evan/Documents/netwk-pp/Received.txt");
            fos.write(buffer);
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