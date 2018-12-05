package main;

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
		
		root.getChildren().addAll(imgView,menu);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		/*scene.setOnKeyPressed(event -> {
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
		Game t = new Game();
		Game t2 = new Game();
		t2.vBoxTest.setTranslateY(-Space.x*Math.sqrt(3)/2);
		t2.vBoxTest.setTranslateX(-Space.x/2);
		*/
		/*Game game = new Game();
		VBox test = new VBox();
		for(int i=0;i<game.hSpace.size();i++) {
			test.getChildren().addAll(game.hSpace.get(i));
		}
		Scene scene = new Scene(test);
		primaryStage.setScene(scene);
		primaryStage.show();*/
		
	}
	private static class MenuButton extends StackPane {
		private Text text;
		
		public MenuButton(String name) {
			text = new Text(name);
			text.getFont();
			text.setFont(Font.font("Papyrus",25));
			text.setFill(Color.WHITE);
			text.setTranslateX(20);
			text.setTranslateY(4);
			
			Rectangle bg = new Rectangle(250,30);
			bg.setOpacity(0.6);
			bg.setFill(Color.BLACK);
			bg.setEffect(new GaussianBlur(5));
			
			
			this.setOnMouseEntered(event -> {
				bg.setTranslateX(10);
				bg.setFill(Color.WHITE);
				text.setFill(Color.BLACK);
			});
			
			this.setOnMouseExited(event -> {
				bg.setTranslateX(0);
				bg.setFill(Color.BLACK);
				text.setFill(Color.WHITE);
			});
			
			DropShadow drop = new DropShadow(50, Color.WHITE);
			drop.setInput(new Glow());
			
			this.setOnMousePressed(event -> setEffect(drop));
			this.setOnMouseReleased(event -> setEffect(null));
			setAlignment(Pos.CENTER_LEFT);
			setRotate(-0.5);
			getChildren().addAll(bg,text);
		}
	}
	private class Menu extends Parent {
		public Menu() {
			//use VBox as pane to contain each menu page.
			VBox menu1 = new VBox(10);
			
			menu1.setTranslateX(100);
			menu1.setTranslateY(200);
			
			final int offset = 400;
			
			MenuButton btnStart = new MenuButton("START");
			btnStart.setOnMouseClicked(event -> {
				// start game
				Game startGame = new Game();
				
				getChildren().add(Game.vSpace);
				getChildren().remove(menu1);
			});
			
			MenuButton btnHowTo = new MenuButton("HOW TO PLAY");
			btnHowTo.setOnMouseClicked(event -> {
				// how to play
				VBox howToPlay = new VBox(20);
				PlainTextPage howTo = new PlainTextPage("How to play");
				MenuButton btnBack = new MenuButton("BACK");
				btnBack.setOnMouseClicked(e -> {
					getChildren().add(menu1);
;					TranslateTransition t = new TranslateTransition(Duration.seconds(0.25),howToPlay);
					t.setToX(howToPlay.getTranslateX() + offset);
					
					TranslateTransition t1 = new TranslateTransition(Duration.seconds(0.5),menu1);
					t1.setToX(howToPlay.getTranslateX());
					
					t.play();
					t1.play();
					
					t.setOnFinished(evt -> {
						getChildren().remove(howToPlay);
					});
				});
				btnBack.setTranslateY(90);
				howToPlay.getChildren().addAll(howTo,btnBack);
				getChildren().add(howToPlay);
				TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25),menu1);
				tt.setToX(menu1.getTranslateX() + offset);
				
				TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), howToPlay);
				tt1.setToX(menu1.getTranslateX());
				
				tt.play();
				tt1.play();
				
				tt.setOnFinished(evt ->{
					getChildren().remove(menu1);
				});
			});
			
			MenuButton btnOption = new MenuButton("OPTIONS");
			btnOption.setOnMouseClicked(event -> {
				// option
			});
			
			MenuButton btnCredit = new MenuButton("CREDITS");
			btnCredit.setOnMouseClicked(event -> {
				// credits
			});
			
			MenuButton btnExit = new MenuButton("EXIT");
			btnExit.setOnMouseClicked(event ->{
				// exit
				System.exit(0);
			});
			menu1.getChildren().addAll(btnStart,btnHowTo,btnOption,btnCredit,btnExit);
			Rectangle bg = new Rectangle(800,600);
			bg.setFill(Color.GREY);
			bg.setOpacity(0.4);
			
			getChildren().addAll(bg,menu1);
		}
	}
	private class PlainTextPage extends StackPane {
		public PlainTextPage(String data) {
			Rectangle bg = new Rectangle(560,420);
			bg.setFill(Color.BLACK);
			bg.setOpacity(0.8);
			
			Text text = new Text(data);
			text.setFont(Font.font("Papyrus", 20));
			text.setFill(Color.WHITE);
			
			setTranslateY(90);
			setPrefSize(560, 420);
			setAlignment(Pos.CENTER);
			getChildren().addAll(bg,text);
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
