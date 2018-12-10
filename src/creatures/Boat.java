package creatures;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import gameboard.Game;
import gameboard.Space;
public class Boat  implements Moveable{
	public Space now;
	public ImageView boat;
	public boolean canMove;
	public Boat(Space init) throws IOException {
		now = init;
		canMove = true;
		InputStream bt = Files.newInputStream(Paths.get("res/Boat.png"));
		Image enternamebg = new Image(bt);
		bt.close();
		boat = new ImageView(enternamebg);
		boat.setFitHeight(67);
		boat.setFitWidth(30);
		
	}
	public void moveTo(Space destination) throws IOException {
		int t1,t2;
		t1 = now.n1;
		t2 = now.n2;
		if(destination.type!=5) {
		for(int j = 0; j <t1;j++) {
			now.p1.get(0).moveTo(destination);
		}
		for(int i = 0; i < t2;i++) {
			now.p2.get(0).moveTo(destination);
		}
		now.deleteObject(this);
		now = destination;
		now.addObject(this);
		}
		else {
			if(Game.turn%2==1) {
				Game.p1.score++;
				now.deleteObject(this);
			}
			else {
				Game.p2.score++;
				now.deleteObject(this);
			}
		}
	}
}
