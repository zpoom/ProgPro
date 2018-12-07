package creatures;

import gameboard.Space;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Meeple  extends Circle implements Moveable{
	private int color;
	private Space now;
	public Meeple(int color) {
		this.color = color;
		setRadius(7.5);
		if(color==1) {
			setFill(Color.RED);
		}
		else if(color == 2) {
			setFill(Color.WHITE);
		}
		// random space
	}
	public void moveTo(Space destination) {
		now = destination;
	}
	public int getColor() {
		return this.color;
	}
}
