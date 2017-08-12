package application;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.*;
import java.io.*;


public class SampleController {

	@FXML private TextField userName;
	@FXML private Text ServerState;
	@FXML private PasswordField Password;
	@FXML private Text bhmed;
	private Socket client;
	@FXML public void Login()
	{
		
		String Name= userName.getText();
		String Pass = Password.getText();
		try {
	         
	         OutputStream outToServer = client.getOutputStream();
	         DataOutputStream out = new DataOutputStream(outToServer);
	         out.writeUTF(Name+'\n');
	         out.writeUTF(Pass+'\n');
	         InputStream inFromServer = client.getInputStream();
	         DataInputStream in = new DataInputStream(inFromServer);
	         bhmed.setText(in.readUTF());
	         //client.close();
			}
		catch(IOException e) {
	         e.printStackTrace();
	      }
		
		//send data to network
		//retrieve whether a success login or failed
		//if success load another window
	}
	@FXML public void ConnectToServer()
	{
		try 
		{	
			client = new Socket("localhost", 6606);
			ServerState.setText("Connected!");
			
		} 
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
