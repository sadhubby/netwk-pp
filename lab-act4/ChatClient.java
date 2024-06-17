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
			
			System.out.println(username + ": Connecting to server at" + clientEndpoint.getRemoteSocketAddress());
			System.out.println(username + ": Connected to server at" + clientEndpoint.getRemoteSocketAddress());
			DataOutputStream dosWriter = new DataOutputStream(clientEndpoint.getOutputStream());
			
			dosWriter.writeUTF("Client: Hello from client" + clientEndpoint.getLocalSocketAddress());
			dosWriter.writeUTF(message);
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