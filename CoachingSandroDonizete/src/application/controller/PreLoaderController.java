package application.controller;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class PreLoaderController extends AbstraticController {

	// Variaveis Gerais
	private ProgressBar barraProgresso;
	private Pane layoutTelaAbertura;
	private Label textoProgresso;
	
	@Override
	public void init() {
		try {
			ImageView imagemAbertura = new ImageView(new Image(IMAGEM_ABERTURA));
			imagemAbertura.setFitWidth(TAMANHO_ABERTURA_COMPRIMENTO);
			
			barraProgresso = new ProgressBar();
			barraProgresso.setPrefWidth(TAMANHO_ABERTURA_COMPRIMENTO);

			textoProgresso = new Label("Iniciando Aplicacao . . .");
			textoProgresso.setAlignment(Pos.CENTER);

			layoutTelaAbertura = new VBox();
			layoutTelaAbertura.getChildren().addAll(imagemAbertura,barraProgresso, textoProgresso);
			layoutTelaAbertura.setEffect(new DropShadow());
			layoutTelaAbertura.setStyle(
				"-fx-padding: 5; " +
				"-fx-background-color: cornsilk; " +
				"-fx-border-width:5; " + 
				"-fx-border-color: linear-gradient( to bottom, blue,  derive(blue, 50%));"
			);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage initStage) {

		final Task<ObservableList<String>> taskMensagens = new Task<ObservableList<String>>() {

			@Override
			protected ObservableList<String> call() throws InterruptedException {
				ObservableList<String> mensagensCarregadas  = FXCollections.<String> observableArrayList();
				ObservableList<String> mensagensDisponiveis = FXCollections.observableArrayList("10%", "20%", "30%","40%","60%","80%","100%");

				updateMessage("Iniciando Aplicativo . . .");
				for (int i = 0; i < mensagensDisponiveis.size(); i++) {
					Thread.sleep(400);
					updateProgress(i + 1, mensagensDisponiveis.size());
					String proximaMsg = mensagensDisponiveis.get(i);
					mensagensCarregadas.add(proximaMsg);
					updateMessage("Carregando Aplicativo . . . " + proximaMsg);
				}
				Thread.sleep(400);
				updateMessage("Aplicativo Iniciado");

				return mensagensCarregadas;
			}
		};

		mostrarTelaAbertura(initStage, taskMensagens,() -> mostrarTelaBoasVindas());
		new Thread(taskMensagens).start();

	}

	private void mostrarTelaBoasVindas() {
		try {
			Stage mainStage = new Stage(StageStyle.DECORATED);
			
			PrincipalController.getInstance().start(mainStage);
			
		} catch (Exception e) {
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
		initStage.setX(bounds.getMinX() + bounds.getWidth()  / 2 - TAMANHO_ABERTURA_COMPRIMENTO / 2);
		initStage.setY(bounds.getMinY() + bounds.getHeight() / 2 - TAMANHO_ABERTURA_ALTURA / 2);
		initStage.show();
	}

	public interface InitCompletionHandler {
		public void complete();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
