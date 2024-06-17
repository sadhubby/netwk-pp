import java.net.*;
import java.io.*;

public class ChatClient
{
	public static void main(String[] args)
	{
		String sServerAddress = args[0];
		int nPort = Integer.parseInt(args[1]);
		String name = args[2];
	
		try
		{
			Socket clientEndpoint = new Socket(sServerAddress, nPort);
			System.out.println(name + ": Connecting to server at" + clientEndpoint.getRemoteSocketAddress());
			System.out.println(name + ": Connected to server at" + clientEndpoint.getRemoteSocketAddress());
			
			DataOutputStream dosWriter = new DataOutputStream(clientEndpoint.getOutputStream());
			dosWriter.writeUTF("Client: Hello from client" + clientEndpoint.getLocalSocketAddress());
			
			DataInputStream disReader = new DataInputStream(clientEndpoint.getInputStream());
			System.out.println(disReader.readUTF());
			
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