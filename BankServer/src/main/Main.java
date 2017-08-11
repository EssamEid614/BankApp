package main;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args)
	{
		
		System.out.println("Waiting for Connection ..");
		try
		{
			ServerSocket ListenTo = new ServerSocket(6606);
			ListenTo.setSoTimeout(10000);
			Socket socket = ListenTo.accept();
			DataInputStream in = new DataInputStream(socket.getInputStream());
	        System.out.println(in.readUTF());
	        System.out.println(in.readUTF());
	        while(true);
	        ListenTo.close();
		} 	
		catch (IOException e) 
		{
			System.out.println("an error occured");
			e.printStackTrace();
		}
	}
	
}
