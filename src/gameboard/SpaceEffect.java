package gameboard;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

import creatures.Bigpom;
import creatures.Bigtu;
import creatures.Boat;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SpaceEffect {
	public static ArrayList<Integer> effectsSandCount;
	public static ArrayList<Integer> effectsWildCount;
	public static ArrayList<Integer> effectsMtCount;
	public static Thread boat;
	public SpaceEffect() {

		  boat = new Thread(() -> {
			Game.clearAllSpace();
			try {
				Game.showBoatmoveable();
				Thread.sleep(30000);
			} catch (InterruptedException e3) {
				// TODO Auto-generated catch block
				//e3.printStackTrace();
				System.out.println("Boat Event");
			}
			Game.clearAllSpace();
			try {
				Game.showBoatmoveable();
				Thread.sleep(30000);
			} catch (InterruptedException e3) {
				// TODO Auto-generated catch block
				//e3.printStackTrace();
				System.out.println("Boat Event");
			}
			Game.clearAllSpace();
			try {
				Game.showBoatmoveable();
				Thread.sleep(30000);
			} catch (InterruptedException e3) {
				// TODO Auto-generated catch block
				//e3.printStackTrace();
				System.out.println("Boat Event");
			}
			Game.clearAllSpace();
			Game.t.interrupt();
			
		  });
		effectsSandCount = new ArrayList<Integer>();
		effectsSandCount.add(4);
		effectsSandCount.add(2);
		effectsSandCount.add(3);
		effectsSandCount.add(0);
		effectsSandCount.add(0);
		effectsSandCount.add(2);
		effectsSandCount.add(2);
		effectsSandCount.add(2);
		effectsSandCount.add(1);
		
		effectsWildCount = new ArrayList<Integer>();
		effectsWildCount.add(3);
		effectsWildCount.add(3);
		effectsWildCount.add(4);
		effectsWildCount.add(0);
		effectsWildCount.add(0);
		effectsWildCount.add(2);
		effectsWildCount.add(1);
		effectsWildCount.add(2);
		effectsWildCount.add(1);
		
		effectsMtCount = new ArrayList<Integer>();
		effectsMtCount.add(0);
		effectsMtCount.add(0);
		effectsMtCount.add(0);
		effectsMtCount.add(3);
		effectsMtCount.add(1);
		effectsMtCount.add(1);
		effectsMtCount.add(1);
		effectsMtCount.add(1);
		effectsMtCount.add(1);
	}
	public int effect(int t,Space space) throws IOException {
		if(t==2) {
			//wild
			int idx;
			Random rd = new Random();
			while(true) {
			 idx = rd.nextInt(effectsWildCount.size());
			if (effectsWildCount.get(idx)==0) continue;
			break;
			}
			return showEffect(idx , space);
		}
		if(t==3) {
			// sand
			int idx;
			Random rd = new Random();
			while(true) {
			 idx = rd.nextInt(effectsSandCount.size());
			if (effectsSandCount.get(idx)==0) continue;
			break;
			}
			return showEffect(5,space);
			
		}
		else{
			int idx;
			Random rd = new Random();
			while(true) {
				idx = rd.nextInt(effectsMtCount.size());
				if (effectsMtCount.get(idx)==0) continue;
				break;
			}
			return showEffect(idx,space);
			// Mt
		
		}
	}
	public int showEffect(int t , Space space) throws IOException {
		if(t == 0) {
			try {
				InputStream Bigtu = Files.newInputStream(Paths.get("res/shark.png"));
				Image enternamebg = new Image(Bigtu);
				Bigtu.close();
				showWarningAlert("Shark is coming !!!!", "Spacial event", "Hungryyyy .......",enternamebg);
				space.addObject(new Bigtu(space));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
			
		}
		else if(t==1) {
			try {
				InputStream BigO = Files.newInputStream(Paths.get("res/Whale.png"));
				Image enternamebg = new Image(BigO);
				BigO.close();
				showWarningAlert("Whale Time!!", "Spacial event", "Get out of here!!!",enternamebg);
				space.addObject(new Bigpom(space));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 1;
		}
		else if(t==2) {
			try {
				InputStream BigO = Files.newInputStream(Paths.get("res/Boat.png"));
				Image enternamebg = new Image(BigO);
				BigO.close();
				showWarningAlert("Hi there, I am a boat !!!", "Life Saver??!!", "come on , fast!!!",enternamebg);
				space.addObject(new Boat(space));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 2;
		}
		else if(t==3){
			showWarningAlert("Look out, Tornado!!!!!???? ", "Rest In Peace.", "Whirlpool: remove from the game all Swimmers, Dragon , Sharks, Whales, Ships and Explorers from the sea space the Terrain tile used to occupy, as well as from all adjacent sea spaces");
			space.clearSpace();
			for(Space e : Game.AllAdj.get(space)) {
				if(e.type == 1) e.clearSpace();
			}
			return 3;
		}
		else if(t==4) {
			// end game ; Show the winner 
			return 4;
		}
		else if(t==5) {
			//boat move 3 action 
			showWarningAlert("The winds favor you!", "Life Saver??!!", "Move a Ship you control 1 to 3 sea spaces.");
			boat.start();
			return 5;
		}
		else if(t==6) {
			return 6;
		}
		else if(t==7) {
			return 7;
		}
		
			return 8;
		
	}
	public void showWarningAlert(String header,String title, String content , Image img ) {
        Alert alert = new Alert(AlertType.WARNING);
        ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(img);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
        
    }
	public void showWarningAlert(String title,String header, String content ) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
        
    }
	
}
