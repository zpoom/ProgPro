package gameboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import creatures.Bigo;
import creatures.Bigpom;
import creatures.Bigtu;
import creatures.Meeple;
import creatures.Monster;
import creatures.Moveable;
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
	public ArrayList<Meeple> meeple;
	public Polygon bg;
	public ArrayList<Meeple> p1 ,p2;
	public boolean boat,tu,pom,bigO;
	public Space (int t) {
		mp = new HashMap<Integer,Integer>();
		mp.put(1, 0);
		mp.put(2, 0);
		mp.put(3, 0);
		mp.put(4, 0);
		mp.put(5, 0);
		mp.put(6, 0);
		bg = new Polygon();
		p1 = new ArrayList<Meeple>();
		p2 = new ArrayList<Meeple>();
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
		DropShadow drop = new DropShadow(1000, Color.WHITE);
		drop.setInput(new Glow());
		setOnMouseClicked(event ->{
			if(Game.step == 0) {
				Game.step = 1;
				for(Space a : Game.AllAdj.get(this)) {
					a.bg.setFill(Color.WHITE);
					a.setOnMouseClicked(evt ->{
						//TODO set onclick for move to this space
					});
				}
			}
			else {
				Game.step = 0;
				for(Space a : Game.AllAdj.get(this)) {
					if(a.type == 1) a.bg.setFill(Color.TRANSPARENT);
					if(a.type == 2) a.bg.setFill(Color.GREEN);
					if(a.type == 3) a.bg.setFill(Color.BURLYWOOD);
					if(a.type == 4) a.bg.setFill(Color.GREY);
					a.setOnMouseClicked(evt ->{
						//TODO set onclick for move to this space
					});
				}
			}
		});
		getChildren().addAll(bg);	
	}
	// 1,2 player; 3=boat; 4 = tu,5 = pom,6 = O
	public void addObject(Moveable creature) {
		// TODO
		if(creature instanceof Meeple ) {
			Meeple tmp = (Meeple) creature;
			if(tmp.getColor()==1) p1.add(tmp);
			else p2.add(tmp);
		}
		else if(creature instanceof Bigo) {
			bigO = true;
		}
		else if (creature instanceof Bigpom) {
			pom = true;
		}
		else if(creature instanceof Bigtu) {
			tu = true;
		}
		else {
			boat = true;
		}
	}
	// 1,2 player; 3=boat; 4 = tu,5 = pom,6 = O
	public void deleteObject(Moveable creature) {
		if(creature instanceof Meeple ) {
			Meeple tmp = (Meeple) creature;
			if(tmp.getColor()==1) {
				p1.remove(creature);
			}
			else p2.remove(creature);
		}
		else if(creature instanceof Bigo) {
			bigO = false;
		}
		else if (creature instanceof Bigpom) {
			pom = false;
		}
		else if(creature instanceof Bigtu) {
			tu = false;
		}
		else {
			boat = false;
		}
	}
	
	public void update() {
		// TODO
		/*for(int i=1;i<=6;i++) {
			for(int j=0;j<mp.get(i);j++) {
				getChildren().add(new Meeple(i));
			}
		}*/
		
	}
}
