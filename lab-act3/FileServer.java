/*
Group Members:
De Guzman, Evan Mari 
Dimaculangan, Aldwin Renzel
Javier, Devon Jarek 
 */


import java.net.*;
import java.io.*;

public class FileServer
{
	
	public static void main(String[] args)
	{
		int nPort = Integer.parseInt(args[0]); // 4000
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

			
            File file = new File("Download.txt"); // file object that is the Download.txt file put in the same folder
            FileInputStream fis = new FileInputStream(file); // bytes of the content of Download.txt
            
            byte[] buffer = new byte[(int) file.length()]; // array of bytes with size of length of content of Download.txt
			fis.read(buffer); //reads the bytes of the array buffer

            dosWriter.writeInt(buffer.length); // sending to client number of bytes
            dosWriter.write(buffer, 0, buffer.length); // sends the byte array, the starting index and overall length of the byte array

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