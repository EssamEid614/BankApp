package main;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args)
	{
		ServerSocket serverSocket = null;
		 try
		 {
	       serverSocket = new ServerSocket(6606);
	     } 
		 catch (IOException e)
		 {
	            System.err.println("Could not listen on port: 2343");
	     }
		 while(true)
		 {
			 Socket NewClientArrived;
			try 
			{
				System.out.println("Waiting for Connection on port 6606 ");
				NewClientArrived = serverSocket.accept();
				Server t = new Server(NewClientArrived);
				t.start();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			 
		 }
		
	}
	
}
