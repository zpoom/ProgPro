package gameboard;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Space extends StackPane {
	public static final double x = 50;
	public Space () {
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
		bg.setFill(Color.LIGHTBLUE);
		
		Text text = new Text("H");
		text.setFont(Font.font("TH Sarabun New", 16));
		
		getChildren().addAll(bg,text);
		
	}
}
