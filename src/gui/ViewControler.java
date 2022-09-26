package gui;

import gui.utils.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class ViewControler {
    
	@FXML
	private Button btTest;
	
	@FXML
	public void onBtTestAction() {
		Alerts.showAlert("Alert Title", "Alert Header", "HELLO", AlertType.INFORMATION);
	}
}
