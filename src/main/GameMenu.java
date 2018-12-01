package main;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameMenu extends Application {
	private Menu menu;
	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = new Pane();
		root.setPrefSize(800,600);
		InputStream is = Files.newInputStream(Paths.get("res/survive_bg.png"));
		Image img = new Image(is);
		is.close();
		
		ImageView imgView = new ImageView(img);
		imgView.setFitWidth(800);
		imgView.setFitHeight(600);
		
		menu = new Menu();
		//menu.setVisible(false);
		
		root.getChildren().addAll(imgView, menu);
		
		Scene scene = new Scene(root);
		scene.setOnKeyPressed(event -> {
			if(event.getCode() == KeyCode.ESCAPE) {
				if(!menu.isVisible()) {
					FadeTransition ft = new FadeTransition(Duration.seconds(0.5),menu);
					ft.setFromValue(0);
					ft.setToValue(1);
					
					menu.setVisible(true);
					ft.play();
				}
				else {
					FadeTransition ft = new FadeTransition(Duration.seconds(0.5),menu);
					ft.setFromValue(1);
					ft.setToValue(0);
					ft.setOnFinished(evt -> menu.setVisible(false));
					ft.play();
				}
			}
		});
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	private static class MenuButton extends StackPane {
		private Text text;
		
		public MenuButton(String name) {
			text = new Text(name);
			text.setFont(text.getFont().font(20));
			text.setFill(Color.WHITE);
			
			Rectangle bg = new Rectangle(250,30);
			bg.setOpacity(0.6);
			bg.setFill(Color.BLACK);
			bg.setEffect(new GaussianBlur(3.5));
			
			setAlignment(Pos.CENTER_LEFT);
			setRotate(-0.5);
			getChildren().addAll(bg,text);
			
			setOnMouseDragEntered(event -> {
				bg.setTranslateX(10);
				text.setTranslateX(10);
				bg.setFill(Color.WHITE);
				text.setFill(Color.BLACK);
			});
			
			setOnMouseExited(event -> {
				bg.setTranslateX(0);
				text.setTranslateX(0);
				bg.setFill(Color.BLACK);
				text.setFill(Color.WHITE);
			});
			
			DropShadow drop = new DropShadow(50, Color.WHITE);
			drop.setInput(new Glow());
			
			setOnMousePressed(event -> setEffect(drop));
			setOnMouseReleased(event -> setEffect(null));
		}
	}
	private class Menu extends Parent {
		public Menu() {
			VBox menu0 = new VBox(10);
			VBox menu1 = new VBox(10);
			VBox menu2 = new VBox(10);
			
			menu0.setTranslateX(100);
			menu0.setTranslateY(200);
			
			menu1.setTranslateX(100);
			menu1.setTranslateY(200);
			
			menu2.setTranslateX(100);
			menu2.setTranslateY(200);
			
			final int offset = 400;
			
			//menu1.setTranslateX(offset);
			
			MenuButton btnStart = new MenuButton("START");
			btnStart.setOnMouseClicked(event -> {
				
			});
			
			MenuButton btnCredits = new MenuButton("CREDITS");
			btnCredits.setOnMouseClicked(event -> {
				
			});
			
			
			MenuButton btnResume = new MenuButton("RESUME");
			btnResume.setOnMouseClicked(event -> {
				FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
				ft.setFromValue(1);
				ft.setToValue(0);
				ft.setOnFinished(evt -> setVisible(false));
				ft.play();
			});
			
			MenuButton btnOptions = new MenuButton("OPTIONS");
			btnOptions.setOnMouseClicked(event -> {
				getChildren().add(menu1);
				
				TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25),menu0);
				tt.setToX(menu0.getTranslateX() - offset);
				
				TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5),menu1);
				tt1.setToX(menu0.getTranslateX());
				
				TranslateTransition tt2 = new TranslateTransition(Duration.seconds(0.25),menu2);
				tt2.setToX(menu2.getTranslateX() - offset);
				
				tt.play();
				tt1.play();
				tt2.play();
				
				tt.setOnFinished(evt -> {
					getChildren().removeAll(menu0,menu2);
				});
			});
			
			MenuButton btnExit = new MenuButton("EXIT");
			btnExit.setOnMouseClicked(event -> {
				System.exit(0);
			});
			
			MenuButton btnBack = new MenuButton("Back");
			btnBack.setOnMouseClicked(event -> {
				getChildren().add(menu0);
				TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25),menu1);
				tt.setToX(menu1.getTranslateX() + offset);
				
				TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
				tt1.setToX(menu1.getTranslateX());
				
				tt.play();
				tt1.play();
				
				tt.setOnFinished(evt ->{
					getChildren().remove(menu1);
				});
			});
			MenuButton btnSound = new MenuButton("SOUND");
			MenuButton btnVideo = new MenuButton("VIDEO");
			
			menu0.getChildren().addAll(btnResume,btnOptions,btnExit);
			menu1.getChildren().addAll(btnBack,btnSound,btnVideo);
			menu2.getChildren().addAll(btnStart,btnOptions,btnCredits,btnExit);
			
			Rectangle bg = new Rectangle(800,600);
			bg.setFill(Color.GREY);
			bg.setOpacity(0.4);
			
			getChildren().addAll(bg, menu2);
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
