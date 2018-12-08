package gameboard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import creatures.Bigo;
import creatures.Bigpom;
import creatures.Bigtu;
import creatures.Boat;
import creatures.Meeple;
import creatures.Monster;
import creatures.Moveable;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Space extends StackPane {
	public static final double x = 35;
	public int type;
	public SpaceEffect eff;
	public Map<Integer,Integer> mp;  // 1,2 player; 3=boat; 4 = tu,5 = pom,6 = O
	public ArrayList<Meeple> meeple;
	public Polygon bg;
	public ArrayList<Meeple> p1 ,p2;
	public static Space justClicked;
	public boolean tu,pom,bigO;
	public Boat boat;
	
	public Space (int t) {
		eff = new SpaceEffect();
		boat = null;
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
				justClicked = this;
				Game.step = 1;
				for(Space a : Game.AllAdj.get(this)) {
					a.bg.setFill(Color.WHITE);
					a.setOnMouseClicked(evt ->{
						//TODO set onclick for move to this space
						if(a.boat) {
							for(int i = 0; i < this.p1.size();i++) {
								this.p1.get(i).moveTo(a);
							}
							for(int i = 0; i < now.p2.size();i++) {
								this.p2.get(i).moveTo(a);
							}
							now.deleteObject(new boat());
							now = destination;
							now.addObject(this);
						}
					});
				}
			}
		});
		getChildren().addAll(bg);	
	}
	// 1,2 player; 3=boat; 4 = tu,5 = pom,6 = O
	public void addObject(Moveable creature) throws IOException {
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
			boat = new Boat(this);
		}
		update();
	}
	// 1,2 player; 3=boat; 4 = tu,5 = pom,6 = O
	public void deleteObject(Moveable creature) throws IOException {
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
		update();
		
	}
	
	public void update() throws IOException {
		// TODO
		getChildren().clear();
		getChildren().add(bg);
		if(bigO) {
			// only BigO in Space;
			p1.clear();
			p2.clear();
			boat = false;
			Bigo tmp = new Bigo(this);
			getChildren().add(tmp.dragon);
		}
		// tu = shark , pom = whale , bigo = dragon
		else if(tu && !boat) {
			// only tu here
			p1.clear();
			p2.clear();
			Bigtu tmp = new Bigtu(this);
			getChildren().add(tmp.shark);
			
		}
		else if(tu && boat) {
			//meeple on boat next to bigtu
			//shark at left side and boat with meeple right side
			Bigtu tmp1 = new Bigtu(this);
			Boat tmp2 = new Boat(this);
			tmp1.shark.setTranslateX(-15);
			tmp1.shark.setFitHeight(30);
			tmp1.shark.setFitWidth(30);
			tmp2.boat.setTranslateX(15);
			int x = 0;
			getChildren().addAll(tmp1.shark,tmp2.boat);
			for(int i = 0;i<p1.size();i++) {
				p1.get(i).setRadius(6);
				p1.get(i).setTranslateY(-13+x);
				p1.get(i).setTranslateX(15);
				getChildren().add(p1.get(i));
				x+=13;
				
			}
			for(int i = 0;i<p2.size();i++) {
				p2.get(i).setRadius(6);
				p2.get(i).setTranslateY(-13+x);
				p2.get(i).setTranslateX(15);
				getChildren().add(p2.get(i));
				x+=13;
			}
		}
		else if (pom) {
			boat = false;
			int x = 0;
			Bigpom tmp = new Bigpom(this);
			if(p1.size()!=0||p2.size()!= 0) {
				tmp.whale.setFitWidth(35);
				tmp.whale.setTranslateX(-10);
			}
			getChildren().add(tmp.whale);
			for(int i = 0;i<p1.size();i++) {
				p1.get(i).setRadius(6);
				p1.get(i).setTranslateY(-13+x);
				p1.get(i).setTranslateX(15);
				getChildren().add(p1.get(i));
				x+=13;
				
			}
			for(int i = 0;i<p2.size();i++) {
				p2.get(i).setRadius(6);
				p2.get(i).setTranslateY(-13+x);
				p2.get(i).setTranslateX(15);
				getChildren().add(p2.get(i));
				x+=13;
			}
		}
		else if (boat) {
			Boat tmp = new Boat(this);
			int x = 0;
			getChildren().add(tmp.boat);
			for(int i = 0;i<p1.size();i++) {
				p1.get(i).setRadius(7);
				p1.get(i).setTranslateY(-18+x);
				p1.get(i).setTranslateX(0);
				getChildren().add(p1.get(i));
				x+=17;
				
			}
			for(int i = 0;i<p2.size();i++) {
				p2.get(i).setRadius(7);
				p2.get(i).setTranslateY(-18+x);
				p2.get(i).setTranslateX(0);
				getChildren().add(p2.get(i));
				x+=17;
			}
		}
		else {
			if(p1.size()==0&&p2.size()==1) {
				p2.get(0).setTranslateX(0);
				p2.get(0).setTranslateY(0);
				getChildren().add(p2.get(0));
			}
			else if(p1.size()==1&&p2.size()==0) {
				p1.get(0).setTranslateX(0);
				p1.get(0).setTranslateY(0);
				getChildren().add(p1.get(0));
			}
			else if(p1.size()==1&&p2.size()==1) {
				p1.get(0).setTranslateX(+15);
				p1.get(0).setTranslateY(0);
				getChildren().add(p1.get(0));
				p2.get(0).setTranslateX(-15);
				p2.get(0).setTranslateY(0);
				getChildren().add(p2.get(0));
			}
			else if(p1.size()==2&&p2.size()==0) {
				p1.get(0).setTranslateX(+15);
				p1.get(0).setTranslateY(0);
				getChildren().add(p1.get(0));
				p1.get(1).setTranslateX(-15);
				p1.get(1).setTranslateY(0);
				getChildren().add(p1.get(1));
			}
			else if(p1.size()==0&&p2.size()==2) {
				p2.get(0).setTranslateX(+15);
				p2.get(0).setTranslateY(0);
				getChildren().add(p2.get(0));
				p2.get(1).setTranslateX(-15);
				p2.get(1).setTranslateY(0);
				getChildren().add(p2.get(1));
			}
			else if(p1.size()==1&&p2.size()==2) {
				p2.get(0).setTranslateX(+15);
				p2.get(0).setTranslateY(5);
				getChildren().add(p2.get(0));
				p2.get(1).setTranslateX(-15);
				p2.get(1).setTranslateY(5);
				getChildren().add(p2.get(1));
				p1.get(0).setTranslateX(0);
				p1.get(0).setTranslateY(-15);
				getChildren().add(p1.get(0));
			}
			else if(p1.size()==2&&p2.size()==1) {
				p2.get(0).setTranslateX(+15);
				p2.get(0).setTranslateY(5);
				getChildren().add(p2.get(0));
				p1.get(1).setTranslateX(-15);
				p1.get(1).setTranslateY(5);
				getChildren().add(p1.get(1));
				p1.get(0).setTranslateX(0);
				p1.get(0).setTranslateY(-15);
				getChildren().add(p1.get(0));
			}
			
		}
		
		
	}
}
