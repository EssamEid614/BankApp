package main;
import java.net.*;
import java.io.*;

public class Server extends Thread 
{	
	private ServerSocket ListenTo;
	private Socket server;
	int Port = 6606;
	//constructor default port is 6606 listening on localhost 
	public Server(Socket x)
	{
		server = x;
		//set time out here , commented for now no timeout
	    //ListenTo.setSoTimeout(10000);
		
	}
	//the threading part of the run function which will be called when the thread is created
	public void run()
	{
		while(true)
		{
			try
			{
	        DataInputStream InFromClient = new DataInputStream(server.getInputStream());
	        DataOutputStream OutToClient = new DataOutputStream(server.getOutputStream());
	        System.out.println("Waiting for data");
	        while(true)
	        {
	        while(InFromClient.available()==0);
	        System.out.println("recieved data\n");
	        //System.out.println(InFromClient.readUTF());
	        //System.out.println(InFromClient.readUTF());
	        OutToClient.writeUTF(InFromClient.readUTF());
	        OutToClient.writeUTF(InFromClient.readUTF());
	        }
	        //DataOutputStream OutToClient = new DataOutputStream(server.getOutputStream());    
	         }
			catch(IOException e)
			{
	            e.printStackTrace();
	            break;
			}
		}
	}
	public void StopServer()
	{
		try 
		{
			ListenTo.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}