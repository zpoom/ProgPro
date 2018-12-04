package creatures;

import gameboard.Space;

public class Monster implements Moveable {
	private Space now;
	public void moveTo(Space destination) {
		now = destination;
	}
}
