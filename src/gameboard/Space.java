package gameboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import creatures.Meeple;
import creatures.Monster;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Space extends StackPane {
	public static final double x = 35;
	private int type;
	public SpaceEffect eff;
	public Map<Integer,Integer> mp;  // 1,2 player; 3=boat; 4 = tu,5 = pom,6 = O
	
	public Space (int t) {
		mp = new HashMap<Integer,Integer>();
		mp.put(1, 0);
		mp.put(2, 0);
		mp.put(3, 0);
		mp.put(4, 0);
		mp.put(5, 0);
		mp.put(6, 0);
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
		DropShadow drop = new DropShadow(1000, Color.WHITE);
		drop.setInput(new Glow());
		setOnMouseEntered(event -> {
			
		});
		setOnMouseExited(event -> {
			
		});
		//this.setOnMousePressed(event -> setEffect(drop));
		//this.setOnMouseReleased(event -> setEffect(null));
		getChildren().addAll(bg);	
	}
	public void addObject(Integer creature) {
		// TODO
		mp.put(creature, mp.get(creature)+1);
	}
	public void deleteObject(Integer creature) {
		mp.put(creature, mp.get(creature)-1);
	}
	
	public void update() {
		// TODO
		for(int i=1;i<=6;i++) {
			for(int j=0;j<mp.get(i);j++) {
				getChildren().add(new Meeple(i));
			}
		}
	}
}
