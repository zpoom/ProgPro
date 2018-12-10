package main;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import menu.Menu;
public class Main extends Application {
	private Menu menu;
	private static MediaPlayer bgm;
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Pane root = new Pane();
		root.setPrefSize(1280,720);
		
		menu = new Menu();
		root.getChildren().addAll(menu);
		
		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		playBGM();
		launch(args);
	}
	private static void playBGM() {
		Thread playBGM = new Thread(() ->  {
			bgm = new MediaPlayer(new Media(new File("res/bgm.mp3").toURI().toString()));
			bgm.setOnReady(() -> {
				bgm.setOnEndOfMedia(() -> {
					bgm.seek(Duration.ZERO);
				});
				bgm.play();
			});
		});
		playBGM.start();
	}

}

