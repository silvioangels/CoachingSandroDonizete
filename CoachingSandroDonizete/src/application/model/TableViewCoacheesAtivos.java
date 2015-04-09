package application.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TableViewCoacheesAtivos {
	
	private StringProperty nomeCoachee;
	
	private StringProperty ultimaSessao;
	
	private StringProperty numeroSessao;
	
	public TableViewCoacheesAtivos(String nomeCoachee, Date ultimaSessao, Integer numeroSessao) {
		SimpleDateFormat formatadorDMY = new SimpleDateFormat("dd/MM/yyyy");
		
		this.nomeCoachee  = new SimpleStringProperty(nomeCoachee);
		this.ultimaSessao = new SimpleStringProperty(formatadorDMY.format(ultimaSessao).toString());
		this.numeroSessao = new SimpleStringProperty(numeroSessao.toString());
		
	}

	public StringProperty getNomeCoachee() {
		return nomeCoachee;
	}

	public void setNomeCoachee(StringProperty nomeCoachee) {
		this.nomeCoachee = nomeCoachee;
	}

	public StringProperty getUltimaSessao() {
		return ultimaSessao;
	}

	public void setUltimaSessao(StringProperty ultimaSessao) {
		this.ultimaSessao = ultimaSessao;
	}

	public StringProperty getNumeroSessao() {
		return numeroSessao;
	}

	public void setNumeroSessao(StringProperty numeroSessao) {
		this.numeroSessao = numeroSessao;
	}

}
