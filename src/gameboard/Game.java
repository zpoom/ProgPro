package gameboard;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.layout.VBox;

public class Game {
	public VBox vBoxTest;
	public Game() {
		ArrayList<Space> tmp;
		Space A49 = new Space(1);
		tmp = Arrays.asList(A48,A39,A40,A50,A59,A58);
		A49.addAdjacentSpace(tmp);
	}
}
