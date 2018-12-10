package creatures;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

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
		for(int j = 0; j <now.n1;j++) {
			now.p1.get(j).moveTo(destination);
		}
		for(int i = 0; i < now.n2;i++) {
			now.p2.get(i).moveTo(destination);
		}
		now.deleteObject(this);
		now = destination;
		now.addObject(this);
	}
}
