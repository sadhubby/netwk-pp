import java.net.*;
import java.io.*;

public class ChatClient
{
	public static void main(String[] args)
	{
		String sServerAddress = args[0]; //localhost
		int nPort = Integer.parseInt(args[1]); // 4000
		String username = args[2]; // P1 = Alice, P2 = Bob
		String message = args[3]; // message to Bob from Alice, message to Alice from Bob
		
		try
		{
			Socket clientEndpoint = new Socket(sServerAddress, nPort);
		
			System.out.println(username + ": Connecting to server at \n" + clientEndpoint.getRemoteSocketAddress() + "\n");
			System.out.println(username + ": Connected to server at \n" + clientEndpoint.getRemoteSocketAddress() +"\n");
			DataOutputStream dosWriter = new DataOutputStream(clientEndpoint.getOutputStream());
			
			DataInputStream disReader = new DataInputStream(clientEndpoint.getInputStream());
			dosWriter.writeUTF(username); //2 
			dosWriter.writeUTF(message);//3
			
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