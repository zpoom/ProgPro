package creatures;

import java.io.IOException;

import gameboard.Space;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bigo extends Monster{
	public ImageView dragon;
	public Bigo(Space init) throws IOException {
		super(init);
		Image enternamebg = new Image(ClassLoader.getSystemResource("dragon.png").toString());
		dragon = new ImageView(enternamebg);
		dragon.setFitHeight(50);
		dragon.setFitWidth(50);
		
	}
}
