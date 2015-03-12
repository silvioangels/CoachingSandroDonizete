package application.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class WelcomeController extends Application {
	
	private static final String IMAGE_ABERTURA ="/application/view/images/coach_logo.jpg";
	private static final int TAMANHO_ABERTURA_COMPRIMENTO = 676;
	private static final int TAMANHO_ABERTURA_ALTURA = 227;
	private ProgressBar barraProgresso;
	private Pane layoutTelaAbertura;
	private Label textoProgresso;
	private Stage mainStage;
		
	@Override
	public void init() {
		try {
			ImageView imagemAbertura = new ImageView(new Image(IMAGE_ABERTURA));
			imagemAbertura.setFitWidth(TAMANHO_ABERTURA_COMPRIMENTO);
			barraProgresso = new ProgressBar();
			barraProgresso.setPrefWidth(TAMANHO_ABERTURA_COMPRIMENTO);
			textoProgresso = new Label("Iniciando Aplicacao . . .");
			layoutTelaAbertura = new VBox();
			layoutTelaAbertura.getChildren().addAll(imagemAbertura, barraProgresso, textoProgresso);
			textoProgresso.setAlignment(Pos.CENTER);
			layoutTelaAbertura.setStyle("-fx-padding: 5; "
					+ "-fx-background-color: cornsilk; " + "-fx-border-width:5; "
					+ "-fx-border-color: " + "linear-gradient(" + "to bottom, "
					+ "chocolate, " + "derive(chocolate, 50%)" + ");");
			layoutTelaAbertura.setEffect(new DropShadow());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage initStage) {
			
			final Task<ObservableList<String>> taskMensagens = new Task<ObservableList<String>>() {
				
				@Override
				protected ObservableList<String> call() throws InterruptedException {
					ObservableList<String> mensagensCarregadas = FXCollections.<String> observableArrayList();
					ObservableList<String> mensagensDisponiveis = FXCollections.observableArrayList(
						"Tela", "Imagens", "Links", "lista de mensagens"
					);
					
					updateMessage("Iniciando Sistema . . .");
					for (int i = 0; i < mensagensDisponiveis.size(); i++) {
						Thread.sleep(400);
						updateProgress(i + 1, mensagensDisponiveis.size());
						String proximaMsg = mensagensDisponiveis.get(i);
						mensagensCarregadas.add(proximaMsg);
						updateMessage("Carregando Sistema . . . carregado " + proximaMsg);
					}
					Thread.sleep(400);
					updateMessage("Sistema Carregado.");

					return mensagensCarregadas;
				}
			};
			
			mostrarTelaAbertura(initStage, taskMensagens,() -> mostrarTelaBoasVindas());
			new Thread(taskMensagens).start();
		
	}
	
	private void mostrarTelaBoasVindas() {
		try {
			mainStage = new Stage(StageStyle.DECORATED);
			Parent parent = FXMLLoader.load(getClass().getResource("/application/view/fxml/welcome.fxml"));
			mainStage.setScene(new Scene(parent));
			mainStage.setTitle("Tela de Boas Vindas");
			mainStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void mostrarTelaAbertura(final Stage initStage, Task<?> task,InitCompletionHandler initCompletionHandler) {
		
		textoProgresso.textProperty().bind(task.messageProperty());
		barraProgresso.progressProperty().bind(task.progressProperty());
		
		task.stateProperty().addListener(
				(observableValue, oldState, newState) -> {
					if (newState == Worker.State.SUCCEEDED) {
						barraProgresso.progressProperty().unbind();
						barraProgresso.setProgress(1);
						initStage.toFront();
						FadeTransition fadeSplash = new FadeTransition(Duration.seconds(1.2), layoutTelaAbertura);
						fadeSplash.setFromValue(1.0);
						fadeSplash.setToValue(0.0);
						fadeSplash.setOnFinished(actionEvent -> initStage.hide());
						fadeSplash.play();

						initCompletionHandler.complete();
					} 
				});

		Scene splashScene = new Scene(layoutTelaAbertura);
		initStage.initStyle(StageStyle.UNDECORATED);
		final Rectangle2D bounds = Screen.getPrimary().getBounds();
		initStage.setScene(splashScene);
		initStage.setX(bounds.getMinX() + bounds.getWidth() / 2 - TAMANHO_ABERTURA_COMPRIMENTO/ 2);
		initStage.setY(bounds.getMinY() + bounds.getHeight() / 2- TAMANHO_ABERTURA_ALTURA / 2);
		initStage.show();
	}
	
	public interface InitCompletionHandler {
		public void complete();
	}
	
	@FXML
    private void OpenWebSite(MouseEvent event) {
        try {
            java.awt.Desktop.getDesktop().browse(new URI("http://www.sandrodonizete.com/"));
        } catch (IOException | URISyntaxException e) {
        	e.printStackTrace();
        }
    }
	
	@FXML
    private void OpenFacebook(MouseEvent event) {
        try {
            java.awt.Desktop.getDesktop().browse(new URI("https://www.facebook.com/pages/Dicas-do-Coach-Sandro-Donizete/1408975239395175"));
        } catch (IOException | URISyntaxException e) {
        	e.printStackTrace();
        }
    }
	
	@FXML
    private void OpenYouTube(MouseEvent event) {
        try {
            java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/user/Sandrocoach"));
        } catch (IOException | URISyntaxException e) {
        	e.printStackTrace();
        }
    }


	public static void main(String[] args) {
		launch(args);
	}
}
