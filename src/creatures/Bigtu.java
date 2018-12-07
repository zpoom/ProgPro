package creatures;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import gameboard.Space;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bigtu extends Monster {
	public ImageView shark;
	public Bigtu(Space init) throws IOException {
		super(init);
		move = 2;
		InputStream Bigtu = Files.newInputStream(Paths.get("res/shark.png"));
		Image enternamebg = new Image(Bigtu);
		Bigtu.close();
		shark = new ImageView(enternamebg);
		shark.setFitHeight(50);
		shark.setFitWidth(50);
	}
}
