package gameboard;

import javafx.scene.layout.VBox;

public class Game {
	public VBox vBoxTest;
	public Game() {
		vBoxTest = new VBox();
		Space sp1 = new Space(1);
		Space sp2 = new Space(2);
		Space sp3 = new Space(3);
		Space sp4 = new Space(4);
		Space sp5 = new Space(1);
		vBoxTest.getChildren().addAll(sp1,sp2,sp3,sp4,sp5);
	}
}
