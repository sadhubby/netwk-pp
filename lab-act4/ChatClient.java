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
		
			
			System.out.println(username + ": Connecting to server at " + clientEndpoint.getRemoteSocketAddress());
			System.out.println(username + ": Connected to server at " + clientEndpoint.getRemoteSocketAddress());
			DataOutputStream dosWriter = new DataOutputStream(clientEndpoint.getOutputStream());
			
			dosWriter.writeUTF("Client: Hello from client" + clientEndpoint.getLocalSocketAddress()); //1 
			
			DataInputStream disReader = new DataInputStream(clientEndpoint.getInputStream());
			dosWriter.writeUTF(username); //2 
			
			while(true){
				if(disReader.available() > 0){
					String messageFromClient = disReader.readUTF();
					System.out.println("Message from " + messageFromClient);
				}
			}

/*
 * evan when you get back to this, here is the TODO: 
 * server counts when it takes two, so we're passed that.
 * Server also gets the username variable. this should be passed back into a client. possible problem: it might not be alice to bob but bob to alice. can try to store two instnaces of username vairable into server somehow
 * give the username to the other client + the message they have. 
 */

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