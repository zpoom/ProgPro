package creatures;

import java.io.IOException;

import gameboard.Space;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bigpom extends Monster {
	public ImageView whale;
	public Bigpom(Space init) throws IOException {
		super(init);
		Image enternamebg = new Image(ClassLoader.getSystemResource("Whale.png").toString());
		whale = new ImageView(enternamebg);
		whale.setFitHeight(50);
		whale.setFitWidth(50);
	}
}
