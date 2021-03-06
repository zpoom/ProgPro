package gameboard;

import java.io.IOException;
import java.util.ArrayList;

import creatures.Bigo;
import creatures.Bigpom;
import creatures.Bigtu;
import creatures.Boat;
import creatures.Meeple;
import creatures.Moveable;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;


public class Space extends StackPane {
	public static final double x = 35;
	public SpaceEffect eff;
	public Polygon bg;
	public ArrayList<Meeple> p1 ,p2 ;
	public int n1,n2,type;
	public boolean tu,pom,bigO;
	public Boat boat;
	
	public Space (int t) {
		eff = new SpaceEffect();
		n1 = 0;
		n2 = 0;
		boat = null;
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
		else if(t == 2) bg.setFill(Color.GREEN);
		else if(t == 3) bg.setFill(Color.BURLYWOOD);
		else if(t == 4) bg.setFill(Color.GREY);
		else if(t == 5)bg.setFill(Color.GOLD);
		DropShadow drop = new DropShadow(1000, Color.WHITE);
		drop.setInput(new Glow());
		getChildren().addAll(bg);	
	}
	// 1,2 player; 3=boat; 4 = tu,5 = pom,6 = O
	public void addObject(Moveable creature) throws IOException {
		// TODO
		if(creature instanceof Meeple ) {
			if(n1+n2>3) return;
			if(((Meeple) creature).getColor()==1) {
				p1.add(((Meeple) creature));
				n1++;
			}
			
			else {
				p2.add(((Meeple) creature));
				n2++;
			}
			
			
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
			boat = (Boat) creature;
		}
		update();
	}
	// 1,2 player; 3=boat; 4 = tu,5 = pom,6 = O
	public void clearSpace() {
		n1 = 0;
		n2 = 0;
		bigO = false;
		tu = false;
		pom = false;
		boat = null;
		p1.clear();
		p2.clear();
		try {
			update();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteObject(Moveable creature) throws IOException {
		if(creature instanceof Meeple ) {
			if(((Meeple) creature).getColor()==1) {
				p1.remove(0);
				n1--;
			}
			else {p2.remove(0);n2--;}
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
			boat = null;
		}
		update();
		
	}
	public boolean isEmpty() {
		if(n1==0&&n2==0&& !bigO && !pom &&boat==null && !tu) return true;
		return false;
	}
	
	public void update() throws IOException {
		// TODO
		int pl1 = 0;
		int pl2 = 0;
		for(Space space : Game.allTile) {
			pl1+=space.n1;
			pl2+=space.n2;
		}
		if(pl1==0) {
			SpaceEffect.showWarningAlert("End game", "The winner is!!!!", (String)Game.p2.getName());
			System.exit(0);
		}
		else if (pl2==0) {
			SpaceEffect.showWarningAlert("End game", "The winner is!!!!", (String)Game.p1.getName());
			System.exit(0);
		}
		else if(pl1==0&&pl2==0) {
			SpaceEffect.showWarningAlert("End game", "DRAW", " ");
			System.exit(0);
		}
		getChildren().clear();
		if(type == 1) bg.setFill(Color.TRANSPARENT);
		else if(type == 2) bg.setFill(Color.GREEN);
		else if(type == 3) bg.setFill(Color.BURLYWOOD);
		else if(type == 4) bg.setFill(Color.GREY);
		getChildren().add(bg);
		if(bigO) {
			// only BigO in Space;
			p1.clear();
			p2.clear();
			n1 = 0;
			n2 = 0;
			boat = null;
			Bigo tmp = new Bigo(this);
			getChildren().add(tmp.dragon);
		}
		// tu = shark , pom = whale , bigo = dragon
		else if(tu && boat==null) {
			// only tu here
			p1.clear();
			p2.clear();
			n1 = 0;
			n2 = 0;
			Bigtu tmp = new Bigtu(this);
			getChildren().add(tmp.shark);
		}
		else if(tu && boat!=null) {
			//meeple on boat next to bigtu
			//shark at left side and boat with meeple right side
			Bigtu tmp1 = new Bigtu(this);
			tmp1.shark.setTranslateX(-15);
			tmp1.shark.setFitHeight(30);
			tmp1.shark.setFitWidth(30);
			boat.boat.setTranslateX(15);
			int x = 0;
			getChildren().addAll(tmp1.shark,boat.boat);
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
			boat = null;
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
		else if (boat!=null) {
			int x = 0;
			boat.boat.setTranslateX(0);
			getChildren().add(boat.boat);
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
				p2.get(0).setRadius(10);
				getChildren().add(p2.get(0));
			}
			else if(p1.size()==1&&p2.size()==0) {
				p1.get(0).setTranslateX(0);
				p1.get(0).setTranslateY(0);
				p1.get(0).setRadius(10);
				getChildren().add(p1.get(0));
			}
			else if(p1.size()==1&&p2.size()==1) {
				p1.get(0).setTranslateX(+15);
				p1.get(0).setTranslateY(0);
				p1.get(0).setRadius(10);
				getChildren().add(p1.get(0));
				p2.get(0).setTranslateX(-15);
				p2.get(0).setTranslateY(0);
				p2.get(0).setRadius(10);
				getChildren().add(p2.get(0));
			}
			else if(p1.size()==2&&p2.size()==0) {
				p1.get(0).setTranslateX(+15);
				p1.get(0).setTranslateY(0);
				p1.get(0).setRadius(10);
				getChildren().add(p1.get(0));
				p1.get(1).setTranslateX(-15);
				p1.get(1).setTranslateY(0);
				p1.get(1).setRadius(10);
				getChildren().add(p1.get(1));
			}
			else if(p1.size()==0&&p2.size()==2) {
				p2.get(0).setTranslateX(+15);
				p2.get(0).setTranslateY(0);
				p2.get(0).setRadius(10);
				getChildren().add(p2.get(0));
				p2.get(1).setTranslateX(-15);
				p2.get(1).setTranslateY(0);
				p2.get(1).setRadius(10);
				getChildren().add(p2.get(1));
			}
			else if(p1.size()==1&&p2.size()==2) {
				p2.get(0).setTranslateX(+15);
				p2.get(0).setTranslateY(5);
				p2.get(0).setRadius(10);
				getChildren().add(p2.get(0));
				p2.get(1).setTranslateX(-15);
				p2.get(1).setTranslateY(5);
				p2.get(1).setRadius(10);
				getChildren().add(p2.get(1));
				p1.get(0).setTranslateX(0);
				p1.get(0).setTranslateY(-15);
				p1.get(0).setRadius(10);
				getChildren().add(p1.get(0));
			}
			else if(p1.size()==2&&p2.size()==1) {
				p2.get(0).setTranslateX(+15);
				p2.get(0).setTranslateY(5);
				p2.get(0).setRadius(10);
				getChildren().add(p2.get(0));
				p1.get(1).setTranslateX(-15);
				p1.get(1).setTranslateY(5);
				p1.get(1).setRadius(10);
				getChildren().add(p1.get(1));
				p1.get(0).setTranslateX(0);
				p1.get(0).setTranslateY(-15);
				p1.get(0).setRadius(10);
				getChildren().add(p1.get(0));
			}
			else if(p1.size()==3&&p2.size()==0) {
				p1.get(0).setTranslateX(+15);
				p1.get(0).setTranslateY(5);
				p1.get(0).setRadius(10);
				getChildren().add(p1.get(0));
				p1.get(1).setTranslateX(-15);
				p1.get(1).setTranslateY(5);
				p1.get(1).setRadius(10);
				getChildren().add(p1.get(1));
				p1.get(2).setTranslateX(0);
				p1.get(2).setTranslateY(-15);
				p1.get(2).setRadius(10);
				getChildren().add(p1.get(2));
			}
			else if(p1.size()==0&&p2.size()==3) {
				p2.get(0).setTranslateX(+15);
				p2.get(0).setTranslateY(5);
				p2.get(0).setRadius(10);
				getChildren().add(p2.get(0));
				p2.get(1).setTranslateX(-15);
				p2.get(1).setTranslateY(5);
				p2.get(1).setRadius(10);
				getChildren().add(p2.get(1));
				p2.get(2).setTranslateX(0);
				p2.get(2).setTranslateY(-15);
				p2.get(2).setRadius(10);
				getChildren().add(p2.get(2));
			}
			
		}
		
		
	}
}
