package gameboard;

import java.util.ArrayList;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Space extends StackPane {
	public static final double x = 50;
	private ArrayList<Space> adjacentSpace;
	private int type;
	public SpaceEffect eff;
	public Space (int t) {
		Polygon bg = new Polygon();
		bg.setStroke(Color.BLACK);
		bg.setStrokeWidth(2.0);
		bg.getPoints().addAll(new Double[]{
			    0.0, 0.0,
			    x, 0.0,
			    x+x/2, -Math.sqrt(3)*x/2,
			    x,-x*Math.sqrt(3),
			    0.0,-x*Math.sqrt(3),
			    -x/2,-Math.sqrt(3)*x/2,
		});
		type = t;
		if(t == 1) bg.setFill(Color.TRANSPARENT);
		if(t == 2) bg.setFill(Color.GREEN);
		if(t == 3) bg.setFill(Color.BURLYWOOD);
		if(t == 4) bg.setFill(Color.GREY);
		/*setOnMouseDragEntered(event -> {
			bg.setFill(Color.BLACK);
		});
		setOnDragExited(event ->{
			bg.setFill(Color.TRANSPARENT);
		});*/
		setOnMouseEntered(event -> {
			bg.setFill(Color.PINK);
		});
		setOnMouseExited(event -> {
			bg.setFill(Color.TRANSPARENT);
		});
		setOnMouseClicked(event -> {
			bg.setFill(Color.RED);
		});
		getChildren().addAll(bg);
		
	}
}
