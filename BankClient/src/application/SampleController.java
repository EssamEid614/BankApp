package application;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.net.*;
import java.io.*;


public class SampleController {

	@FXML private TextField userName;
	@FXML private PasswordField Password;
	@FXML public void Login()
	{
		
		String Name= userName.getText();
		String Pass = Password.getText();
		try {
	         Socket client = new Socket("localhost", 6606);
	         OutputStream outToServer = client.getOutputStream();
	         DataOutputStream out = new DataOutputStream(outToServer);
	         out.writeUTF(Name+'\n');
	         out.writeUTF(Pass+'\n');
	         InputStream inFromServer = client.getInputStream();
	         DataInputStream in = new DataInputStream(inFromServer);     
	         System.out.println("Server says " + in.readUTF());
			}
		catch(IOException e) {
	         e.printStackTrace();
	      }
		
		//send data to network
		//retrieve whether a success login or failed
		//if success load another window
	}
	
}
