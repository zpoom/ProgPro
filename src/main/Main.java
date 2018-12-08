package main;

import java.awt.TextArea;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

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
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Pane root = new Pane();
		root.setPrefSize(1280,720);
		/*InputStream is = Files.newInputStream(Paths.get("res/survive_bg.png"));
		Image img = new Image(is);
		is.close();
		
		ImageView imgView = new ImageView(img);
		imgView.setFitWidth(800);
		imgView.setFitHeight(600);*/
		
		menu = new Menu();
		//menu.setVisible(false);
		
		root.getChildren().addAll(menu);
		
		Scene scene = new Scene(root);
		scene.setOnKeyPressed(event -> {
			if(event.getCode() == KeyCode.ESCAPE && Game.step == 1) {
				Game.step = 0;
				for(Space a : Game.AllAdj.get(Space.justClicked)) {
					if(a.type == 1) a.bg.setFill(Color.TRANSPARENT);
					if(a.type == 2) a.bg.setFill(Color.GREEN);
					if(a.type == 3) a.bg.setFill(Color.BURLYWOOD);
					if(a.type == 4) a.bg.setFill(Color.GREY);
					a.setOnMouseClicked(evt -> {
						if(Game.step == 0) {
							Space.justClicked = a;
							Game.step = 1;
							for(Space x : Game.AllAdj.get(a)) {
								x.bg.setFill(Color.WHITE);
								x.setOnMouseClicked(e ->{
									//TODO set onclick for move to this space
									x.eff.effect(x.type);
								});
							}
						}
					});
				}
			}
		});
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
