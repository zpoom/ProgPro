package main;

import java.awt.TextArea;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.File;

import gameboard.Game;
import gameboard.Space;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;
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

