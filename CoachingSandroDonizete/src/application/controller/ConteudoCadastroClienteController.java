package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javax.swing.JOptionPane;


public class ConteudoCadastroClienteController extends AbstraticController{
	
	@FXML
	public void testarBotao(ActionEvent event){
		
		JOptionPane.showMessageDialog(null, "Teste");
		
	}

}
