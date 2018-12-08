package menu;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import gameboard.Game;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import player.Player;

public class Menu extends Parent {
	private Text tx1,tx2;
	
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
			//ping
			try {
				InputStream island = Files.newInputStream(Paths.get("res/Namepage.jpeg"));
				Image enternamebg = new Image(island);
				island.close();
				ImageView enterNameview = new ImageView(enternamebg);
				enterNameview.setFitHeight(720);
				enterNameview.setFitWidth(1280);
				getChildren().add(enterNameview);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//enterNamePage.setBackground((Paths.get("res/Namepage.jpeg"));
			//enterNamePage.setTranslateX(125);
			
			VBox name = new VBox(30);
			tx1 = new Text();
			tx1.setFont(Font.font("Papyrus", 40));
			tx1.setFill(Color.BROWN);
			tx2 = new Text();
			tx2.setFont(Font.font("Papyrus", 40));
			tx2.setFill(Color.BROWN);
			
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
			p2Name.setStyle("-fx-background-color: rgba(0,0, 0, 0);");
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
				TranslateTransition t = new TranslateTransition(Duration.seconds(0.5),name);
				t.setToX(menu1.getTranslateX() + 400);
				
				TranslateTransition t1 = new TranslateTransition(Duration.seconds(0.5),Game.vSpace);
				/*t1.setToX(choosePlayer.getTranslateX()+240);
				t1.setToY(choosePlayer.getTranslateY()-120);*/
				t.play();
				t1.play();
				
				try {
					startGame();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				t.setOnFinished(e -> {
					getChildren().remove(name);
				});
			});
			name.getChildren().addAll(btnOk);
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
		
		MenuButton btnExit = new MenuButton("EXIT");
		btnExit.setOnMouseClicked(event ->{
			// exit
			System.exit(0);
		});
		menu1.getChildren().addAll(btnStart,btnExit);
		getChildren().addAll(imgView,bg,menu1);
	}
	private void startGame() throws IOException {
		Player p1 = new Player(tx1.getText());
		Player p2 = new Player(tx2.getText());
		ArrayList<Player> temp = new ArrayList<Player>();
		temp.add(p1);
		temp.add(p2);
		Game game = new Game(2,temp);
		game.randomPosition1();
		game.randomPosition2();
		getChildren().addAll(Game.vSpace);
		Game.vSpace.setTranslateX(300);
		Game.vSpace.setTranslateY(20);
		game.gameLoop();
	}
}
