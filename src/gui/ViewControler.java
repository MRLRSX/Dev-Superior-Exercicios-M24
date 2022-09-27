package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import mode.entities.Seller;
import mode.entities.dao.DaoFactory;
import mode.entities.dao.SellerDao;

public class ViewControler implements Initializable{
    
	
	@FXML
    private ComboBox<Seller> comboBoxPerson;
    
	private ObservableList<Seller> obsList;
	
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
        List<Seller> lista = new ArrayList<>();
        SellerDao sDao = DaoFactory.createSellerDaoJDBC();
        lista.addAll(sDao.findAll());
        obsList = FXCollections.observableArrayList(lista);
        comboBoxPerson.setItems(obsList);
	}
}
