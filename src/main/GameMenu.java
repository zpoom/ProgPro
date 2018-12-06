package main;

import java.awt.TextArea;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import gameboard.Game;
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

public class GameMenu extends Application {
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
		});*/
		primaryStage.setScene(scene);
		primaryStage.show();

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
		public Rectangle bg;
		public MenuButton(String name) {
			text = new Text(name);
			text.getFont();
			text.setFont(Font.font("Papyrus",25));
			text.setFill(Color.WHITE);
			text.setTranslateX(20);
			text.setTranslateY(4);
			
			bg = new Rectangle(250,30);
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
		public Menu() throws IOException {
			//use VBox as pane to contain each menu page.
			
			InputStream is = Files.newInputStream(Paths.get("res/survive_bg.png"));
			Image img = new Image(is);
			is.close();
			
			ImageView imgView = new ImageView(img);
			imgView.setFitWidth(1280);
			imgView.setFitHeight(720);
			
			Rectangle bg = new Rectangle(1280,720);
			bg.setFill(Color.GREY);
			bg.setOpacity(0.4);
			
			VBox menu1 = new VBox(10);
			VBox choosePlayer = new VBox(20);
			
			MenuButton btn2Players = new MenuButton("2 PLAYERS");
			MenuButton btn3Players = new MenuButton("3 PLAYERS");
			MenuButton btn4Players = new MenuButton("4 PLAYERS");
			btn2Players.setOnMouseClicked(event -> {
				// get playername
				getChildren().remove(imgView);
				getChildren().remove(bg);
				getChildren().remove(choosePlayer);
				
				PlainTextPage enterNamePage = new PlainTextPage("");
				enterNamePage.setTranslateX(125);
				
				VBox name = new VBox(30);
				Text tx1 = new Text();
				tx1.setFont(Font.font("Papyrus", 40));
				tx1.setFill(Color.BROWN);
				Text tx2 = new Text();
				tx2.setFont(Font.font("Papyrus", 40));
				tx2.setFill(Color.BROWN);
				
				HBox hLine1 = new HBox(20);
				TextField p1Name = new TextField();
				p1Name.setFont(Font.font("Papyrus",40));
				tx1.setText("PLAYER1'S NAME :");
				p1Name.setStyle("-fx-background-color: rgba(225, 225, 225, 225);");
				p1Name.setTranslateY(-30);
				p1Name.setMaxWidth(5000.0);
				hLine1.getChildren().addAll(tx1,p1Name);
				
				HBox hLine2 = new HBox(20);
				TextField p2Name = new TextField();
				p2Name.setFont(Font.font("Papyrus",40));
				p2Name.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
				tx2.setText("PLAYER2'S NAME :");
				p2Name.setTranslateY(-30);
				p2Name.setMaxWidth(5000.0);
				hLine2.getChildren().addAll(tx2,p2Name);
				
				name.getChildren().addAll(hLine1);
				name.getChildren().addAll(hLine2);
				
				name.setTranslateX(200);
				name.setTranslateY(200);
				
				MenuButton btnOk = new MenuButton("OK");
				//btnOk.setTranslateX();
				btnOk.setTranslateY(50);
				btnOk.setOnMouseClicked(evt -> {
					// TODO start here
				});
				name.getChildren().addAll(btnOk);
				enterNamePage.getChildren().addAll(name);
				getChildren().addAll(enterNamePage);
			});
			btn3Players.setOnMouseClicked(event -> {
				//TODO start game with 3 players
				getChildren().remove(imgView);
				getChildren().remove(bg);
				getChildren().remove(choosePlayer);
				
				VBox name = new VBox(30);
				Text tx1 = new Text();
				tx1.setFont(Font.font("Papyrus", 40));
				tx1.setFill(Color.BROWN);
				Text tx2 = new Text();
				tx2.setFont(Font.font("Papyrus", 40));
				tx2.setFill(Color.BROWN);
				Text tx3 = new Text();
				tx3.setFont(Font.font("Papyrus", 40));
				tx3.setFill(Color.BROWN);
				
				HBox hLine1 = new HBox(20);
				TextField p1Name = new TextField();
				p1Name.setFont(Font.font("Papyrus",40));
				tx1.setText("PLAYER1'S NAME :");
				p1Name.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
				p1Name.setTranslateY(-30);
				p1Name.setMaxWidth(5000.0);
				hLine1.getChildren().addAll(tx1,p1Name);
				
				HBox hLine2 = new HBox(20);
				TextField p2Name = new TextField();
				p2Name.setFont(Font.font("Papyrus",40));
				p2Name.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
				tx2.setText("PLAYER2'S NAME :");
				p2Name.setTranslateY(-30);
				p2Name.setMaxWidth(5000.0);
				hLine2.getChildren().addAll(tx2,p2Name);
				
				HBox hLine3 = new HBox(20);
				TextField p3Name = new TextField();
				p3Name.setFont(Font.font("Papyrus",40));
				p3Name.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
				tx3.setText("PLAYER3'S NAME :");
				p3Name.setTranslateY(-30);
				p3Name.setMaxWidth(5000.0);
				hLine3.getChildren().addAll(tx3,p3Name);
				
				name.getChildren().addAll(hLine1);
				name.getChildren().addAll(hLine2);
				name.getChildren().addAll(hLine3);
				
				name.setTranslateX(200);
				name.setTranslateY(100);
				
				MenuButton btnOk = new MenuButton("OK");
				btnOk.setTranslateX(300);
				btnOk.setOnMouseClicked(evt -> {
					// TODO start here
				});
				name.getChildren().addAll(btnOk);
				getChildren().addAll(name);
			});
			btn4Players.setOnMouseClicked(event -> {
				//TODO start game with 4 players
				getChildren().remove(imgView);
				getChildren().remove(bg);
				getChildren().remove(choosePlayer);
				
				VBox name = new VBox(20);
				Text tx1 = new Text();
				tx1.setFont(Font.font("Papyrus", 40));
				tx1.setFill(Color.BROWN);
				Text tx2 = new Text();
				tx2.setFont(Font.font("Papyrus", 40));
				tx2.setFill(Color.BROWN);
				Text tx3 = new Text();
				tx3.setFont(Font.font("Papyrus", 40));
				tx3.setFill(Color.BROWN);
				Text tx4 = new Text();
				tx4.setFont(Font.font("Papyrus", 40));
				tx4.setFill(Color.BROWN);
				
				HBox hLine1 = new HBox(20);
				TextField p1Name = new TextField();
				p1Name.setFont(Font.font("Papyrus",40));
				tx1.setText("PLAYER1'S NAME :");
				p1Name.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
				p1Name.setTranslateY(-30);
				p1Name.setMaxWidth(5000.0);
				hLine1.getChildren().addAll(tx1,p1Name);
				
				HBox hLine2 = new HBox(20);
				TextField p2Name = new TextField();
				p2Name.setFont(Font.font("Papyrus",40));
				p2Name.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
				tx2.setText("PLAYER2'S NAME :");
				p2Name.setTranslateY(-30);
				p2Name.setMaxWidth(5000.0);
				hLine2.getChildren().addAll(tx2,p2Name);
				
				HBox hLine3 = new HBox(20);
				TextField p3Name = new TextField();
				p3Name.setFont(Font.font("Papyrus",40));
				p3Name.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
				tx3.setText("PLAYER3'S NAME :");
				p3Name.setTranslateY(-30);
				p3Name.setMaxWidth(5000.0);
				hLine3.getChildren().addAll(tx3,p3Name);
				
				HBox hLine4 = new HBox(20);
				TextField p4Name = new TextField();
				p4Name.setFont(Font.font("Papyrus",40));
				p4Name.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
				tx4.setText("PLAYER4'S NAME :");
				p4Name.setTranslateY(-30);
				p4Name.setMaxWidth(5000.0);
				hLine4.getChildren().addAll(tx4,p4Name);
				
				name.getChildren().addAll(hLine1);
				name.getChildren().addAll(hLine2);
				name.getChildren().addAll(hLine3);
				name.getChildren().addAll(hLine4);
				
				name.setTranslateX(200);
				name.setTranslateY(100);
				
				MenuButton btnOk = new MenuButton("OK");
				btnOk.setOnMouseClicked(evt -> {
					// TODO start here
				});
				name.getChildren().addAll(btnOk);
				//name.setTranslateY(-);
				getChildren().addAll(name);
			});
	
			choosePlayer.getChildren().addAll(btn2Players,btn3Players,btn4Players);
			menu1.setTranslateX(100);
			menu1.setTranslateY(200);
			
			choosePlayer.setTranslateX(100);
			choosePlayer.setTranslateY(200);
			
			final int offset = 400;
			
			MenuButton btnStart = new MenuButton("START");
			btnStart.setOnMouseClicked(event -> {
				// start game
				getChildren().add(choosePlayer);
				TranslateTransition t = new TranslateTransition(Duration.seconds(0.25),menu1);
				t.setToX(menu1.getTranslateX() + offset);
				
				TranslateTransition t1 = new TranslateTransition(Duration.seconds(0.5),choosePlayer);
				t1.setToX(choosePlayer.getTranslateX());
				
				t.play();
				t1.play();
				
				t.setOnFinished(evt -> {
					getChildren().remove(menu1);
				});
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
			
			getChildren().addAll(imgView,bg,menu1);
		}
	}
	private class PlainTextPage extends StackPane {
		public PlainTextPage(String data) {
			Rectangle bg = new Rectangle(1000,500);
			bg.setFill(Color.BLACK);
			bg.setOpacity(0.8);
			
			Text text = new Text(data);
			text.setFont(Font.font("Papyrus", 20));
			text.setFill(Color.WHITE);
			
			setTranslateY(90);
			setPrefSize(1000, 500);
			setAlignment(Pos.CENTER);
			getChildren().addAll(bg,text);
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
