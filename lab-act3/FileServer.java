/*
Group Members:
De Guzman, Evan Mari 
Dimaculangan, Renzel Aldwin
Javier, Devon Jarek Yumping 
 */


import java.net.*;
import java.io.*;

public class FileServer
{
	
	public static void main(String[] args)
	{
		int nPort = Integer.parseInt(args[0]);
		System.out.println("Server: Listening on port " + args[0] + "...");
		ServerSocket serverSocket;
		Socket serverEndpoint;

		try 
		{
			serverSocket = new ServerSocket(nPort);
			serverEndpoint = serverSocket.accept();
			
			System.out.println("Server: New client connected: " + serverEndpoint.getRemoteSocketAddress());
			
			DataInputStream disReader = new DataInputStream(serverEndpoint.getInputStream());
			System.out.println(disReader.readUTF());
			
			DataOutputStream dosWriter = new DataOutputStream(serverEndpoint.getOutputStream());
			dosWriter.writeUTF("Server: Hello World!");

  
            File file = new File("C:/Users/Evan/Documents/netwk-pp/Download.txt");
            FileInputStream fis = new FileInputStream(file);
            
            byte[] buffer = new byte[(int) file.length()];
          
            dosWriter.writeInt(buffer.length);
            dosWriter.write(buffer, 0, buffer.length);

            System.out.println("Server: Sending file: Download.txt");

            fis.close();
           
			serverEndpoint.close();
            serverSocket.close();
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