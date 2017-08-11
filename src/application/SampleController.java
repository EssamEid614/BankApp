package application;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SampleController {

	@FXML private TextField userName;
	@FXML private PasswordField Password;
	
	@FXML public void Login()
	{
		String Name= userName.getText();
		String Pass = Password.getText();
		//send data to network
		//retrieve whether a success login or failed
	}
	
}
