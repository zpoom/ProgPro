package creatures;

import java.io.IOException;

import gameboard.Space;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bigtu extends Monster {
	public ImageView shark;
	public Bigtu(Space init) throws IOException {
		super(init);
		Image enternamebg = new Image(ClassLoader.getSystemResource("shark.png").toString());
		shark = new ImageView(enternamebg);
		shark.setFitHeight(45);
		shark.setFitWidth(50);
	}
}
