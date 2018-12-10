package creatures;

import gameboard.Space;

public class Monster implements Moveable {
	private  Space now;
	public Monster(Space init) {
		now = init;
	}
	public void moveTo(Space destination) {
		now = destination;
	}
}
