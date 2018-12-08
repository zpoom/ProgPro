package creatures;

import java.io.IOException;

import gameboard.Space;

public interface Moveable {
	public void moveTo(Space destination) throws IOException;
}
