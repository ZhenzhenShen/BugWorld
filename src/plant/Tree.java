package plant;

import javafx.scene.image.ImageView;

public class Tree extends Plant {
	
	public Tree(double x, double y) {
		super("Tree",350,350,new ImageView("tree1.png"), x, y, 0.03,1000,10);

	}
}
