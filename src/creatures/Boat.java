package creatures;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import gameboard.Space;
public class Boat extends Rectangle implements Moveable{
	int p1 , p2;
	Space now;
	public Boat(Space space) {
		p1 = 0;
		p2 = 0;
		now = space;
		this.setFill(Color.BROWN);
		this.setWidth(17);
		this.setHeight(17);
	}
	public void moveTo(Space destination) {
		
	}
}
