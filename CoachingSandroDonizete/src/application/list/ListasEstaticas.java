package application.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListasEstaticas {
	
	private static ObservableList<String> escolaridade =  FXCollections.observableArrayList(
									                "Ensino Fundamental",
									                "Ensino Medio",
									                "Profissionalizante",
									                "Técnico",
									                "Técnologo",
									                "Ensino Superior Incompleto",
									                "Ensino Superior Completo",
									                "Pós Graduação Incompleto",
									                "Pós Graduação Completo",
									                "Mestrado Incompleto",
									                "Mestrado Completo",
									                "PHD. Incompleto",
									                "PHD. Completo"
									            );

	private static ObservableList<String> siglasEstadosBrasileiros =  FXCollections.observableArrayList(
														            "AC",
														            "AL",
														            "AP",
														            "AM",
														            "BA",
														            "CE",
														            "DF",
														            "ES",
														            "GO",
														            "MA",
														            "MT",
														            "MS",
														            "MG",
														            "PA",
														            "PB",
														            "PR",
														            "PE",
														            "PI",
														            "RJ",
														            "RN",
														            "RS",
														            "RO",
														            "RR",
														            "SC",
														            "SP",
														            "SE",
														            "TO"
														        );
	
	public static ObservableList<String> getListaEscolaridade() {
		return escolaridade;
	}

	public static ObservableList<String> getSiglasEstadosBrasileiros() {
		return siglasEstadosBrasileiros;
	}	
	
}
