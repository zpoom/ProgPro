package gameboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Space extends StackPane {
	public static final double x = 30;
	public ArrayList<Space> adjacentSpace;
	private int type;
	public SpaceEffect eff;
	public Space (int t) {
		Polygon bg = new Polygon();
		bg.setStroke(Color.BLACK);
		bg.setStrokeWidth(2.0);
		bg.getPoints().addAll(new Double[]{
			    0.0, 0.0,
			    0.0, -x,
			    x*Math.sqrt(3)/2, -3*x/2,
			    x*Math.sqrt(3),-x,
			    x*Math.sqrt(3),0.0,
			    x*Math.sqrt(3)/2,x/2,
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
		DropShadow drop = new DropShadow(50, Color.WHITE);
		drop.setInput(new Glow());
		setOnMouseEntered(event -> {
			
		});
		setOnMouseExited(event -> {
			
		});
		setOnMouseClicked(event -> {
			for(Space a : Game.AllAdj.get(this)) {
				a.setEffect(drop);
			}
		});
		//this.setOnMousePressed(event -> setEffect(drop));
		//this.setOnMouseReleased(event -> setEffect(null));
		getChildren().addAll(bg);	
	}
	public void addAdjacentSpace(List<Space> sp) {
		for(int i=0;i<sp.size();i++) {
			adjacentSpace.add((Space) sp.get(i));
		}
	}
}
