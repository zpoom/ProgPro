package creatures;

import gameboard.Space;

public class Meeple implements Moveable {
	private int color;
	private Space now;
	public Meeple(int color) {
		this.color = color;
		// random space
	}
	public void moveTo(Space destination) {
		now = destination;
	}
}
