package creatures;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import gameboard.Space;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bigpom extends Monster {
	public ImageView whale;
	public Bigpom(Space init) throws IOException {
		super(init);
		move = 3;
		InputStream BigO = Files.newInputStream(Paths.get("res/Whale.png"));
		Image enternamebg = new Image(BigO);
		BigO.close();
		whale = new ImageView(enternamebg);
		whale.setFitHeight(50);
		whale.setFitWidth(50);
	}
}
