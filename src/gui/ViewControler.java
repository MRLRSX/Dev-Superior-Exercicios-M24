package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.utils.Constrains;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewControler implements Initializable{
    
	@FXML
	private Button btSum;
	
	
	@FXML
	private TextField txtNumber1 ;
	
	@FXML
	private TextField txtNumber2 ;
	
	@FXML
	private Label labelResult;
	
	
	@FXML
	public void onBtSumAction() {
		Locale.setDefault(Locale.US);
		Double number1 = Double.parseDouble(txtNumber1.getText());
		Double number2 = Double.parseDouble(txtNumber2.getText());
		labelResult.setText(String.format("%.2f", number1 + number2));
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Constrains.setTextFieldDouble(txtNumber1);
		Constrains.setTextFieldDouble(txtNumber2);
		Constrains.setTextFieldMaxLength(txtNumber1, 12);
		Constrains.setTextFieldMaxLength(txtNumber2, 12);
	}
}
