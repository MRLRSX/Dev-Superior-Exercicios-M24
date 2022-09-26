package gui;

import java.util.Locale;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewControler {
    
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
}
