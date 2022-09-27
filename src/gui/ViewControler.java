package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import mode.entities.Person;

public class ViewControler implements Initializable{
    
	
	@FXML
    private ComboBox<Person> comboBoxPerson;
    
	private ObservableList<Person> obsList;
	
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
        List<Person> lista = new ArrayList<>();
        lista.add(new Person(1, "lucasrocharsx@outlook.com", "Lucas Rocha dos Santos"));
	}
}
