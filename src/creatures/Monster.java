package creatures;

import gameboard.Space;

public class Monster implements Moveable {
	private  Space now;
	protected int move;
	public Monster(Space init) {
		now = init;
	}
	public void moveTo(Space destination) {
		now = destination;
	}
}
