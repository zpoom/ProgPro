package gameboard;

import javafx.scene.layout.VBox;

public class Game {
	public VBox vBoxTest;
	public Game() {
		vBoxTest = new VBox();
		Space sp1 = new Space();
		Space sp2 = new Space();
		Space sp3 = new Space();
		Space sp4 = new Space();
		Space sp5 = new Space();
		vBoxTest.getChildren().addAll(sp1,sp2,sp3,sp4,sp5);
	}
}
