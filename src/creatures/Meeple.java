package creatures;

import java.io.IOException;

import gameboard.Game;
import gameboard.Space;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Meeple  extends Circle implements Moveable{
	private int color; // 1 = p1   2 = p2
	private Space now;
	public Meeple(int color) {
		this.color = color;
		setRadius(10);
		if(color==1) {
			setFill(Color.RED);
		}
		else if(color == 2) {
			setFill(Color.WHITE);
		}
		// random space
	}
	public void moveTo(Space destination) throws IOException {
		if(destination.type!=5) {
		now.deleteObject(this);
		now = destination;
		now.addObject(this);
		return;
		}
		now.deleteObject(this);
		if(Game.turn%2==1) Game.p1.score++;
		else Game.p2.score++;
		destination.clearSpace();
		
		
	}
	public void setInit(Space init) {
		now = init;
	}
	public int getColor() {
		return this.color;
	}
}
