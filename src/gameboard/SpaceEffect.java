package gameboard;

import java.util.ArrayList;

public class SpaceEffect {
	public static ArrayList<Integer> effectsSandCount;
	public static ArrayList<Integer> effectsWildCount;
	public static ArrayList<Integer> effectsMtCount;
	public SpaceEffect() {
		effectsSandCount.add(4);
		effectsSandCount.add(2);
		effectsSandCount.add(3);
		effectsSandCount.add(0);
		effectsSandCount.add(0);
		effectsSandCount.add(2);
		effectsSandCount.add(2);
		effectsSandCount.add(2);
		effectsSandCount.add(1);
		
		effectsWildCount.add(3);
		effectsWildCount.add(3);
		effectsWildCount.add(4);
		effectsWildCount.add(0);
		effectsWildCount.add(0);
		effectsWildCount.add(2);
		effectsWildCount.add(1);
		effectsWildCount.add(2);
		effectsWildCount.add(1);
		
		effectsMtCount.add(0);
		effectsMtCount.add(0);
		effectsMtCount.add(0);
		effectsMtCount.add(3);
		effectsMtCount.add(1);
		effectsMtCount.add(1);
		effectsMtCount.add(1);
		effectsMtCount.add(1);
		effectsMtCount.add(1);
	}
	public void effect(int t) {
		if(t==1) return;
		if(t==2) {
			//wild
			
			return;
		}
		if(t==3) {
			// sand
			
			return;
		}
		
		// Mt
		
		return;
	}
}
