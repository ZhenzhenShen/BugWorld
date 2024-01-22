
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import plant.Flower;
import plant.Grass;
import plant.Plant;
import plant.Tree;


public class BugWorld extends Application {

	ArrayList<Bug> bugs = new ArrayList<Bug>();
	ArrayList<Plant> plants = new ArrayList<Plant>();
	Timeline timeline = new Timeline();
	Scene scene;
	BorderPane root;
	Pane center;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
        root = new BorderPane();
	    scene = new Scene(root,600,900);
		
        Bug ant = new Ant(100, 100);
        Bug bee = new Bee(200, 100);
        Bug beetle = new Beetle(300, 100);
        Bug butterfly = new Butterfly(400, 400);
        Bug caterpillar = new Caterpillar(500, 400);
        Bug dragonfly = new Dragonfly(600, 400);
        Bug grasshopper = new Grasshopper(600, 800);
        Bug ladyBug = new Ladybug(700, 800);
        Bug worm = new Worm(800, 800);
        
        bugs.add(ant);		
		bugs.add(bee);
		bugs.add(beetle);
		bugs.add(butterfly);
		bugs.add(caterpillar);
		bugs.add(dragonfly);
		bugs.add(grasshopper);
		bugs.add(ladyBug);
		bugs.add(worm);
		
		Sun sun = new Sun(1100, 0);
		
		Plant tree = new Tree(1000, 550);
		
		Plant flower1 = new Flower(10, 400);
		Plant flower2 = new Flower(10, 750);
		Plant flower3 = new Flower(10, 100);
		
		Plant grass1 = new Grass(200, 800);
		Plant grass2 = new Grass(450, 800);
		Plant grass3 = new Grass(700, 800);
		Plant grass4 = new Grass(200, 400);
		Plant grass5 = new Grass(450, 400);
		Plant grass6 = new Grass(700, 400);
	    Plant grass7 = new Grass(200, 100);
	    Plant grass8 = new Grass(450, 100);
	    Plant grass9 = new Grass(700, 100);
				
		plants.add(tree);
		plants.add(flower1);
		plants.add(flower2);
		plants.add(flower3);
		plants.add(grass1);
		plants.add(grass2);
		plants.add(grass3);
		plants.add(grass4);
		plants.add(grass5);
		plants.add(grass6);
		plants.add(grass7);
		plants.add(grass8);
		plants.add(grass9);
        
		VBox left = new VBox();
		center = new Pane();
		
		ImageView s = new ImageView(new Image("start.png"));
		s.setFitWidth(80);
		s.setFitHeight(50);
		Button startButton = new Button();
        startButton.setGraphic(s);
        startButton.setOnAction(e->start());
        
        ImageView p = new ImageView(new Image("pause.png"));
		p.setFitWidth(80);
		p.setFitHeight(50);
        Button pauseButton = new Button();
        pauseButton.setGraphic(p);;
        pauseButton.setOnAction(e->pause());
        
        ImageView f = new ImageView(new Image("flower6.png"));
        f.setFitWidth(80);
        f.setFitHeight(50);
        Button addFlower = new Button();
        addFlower.setGraphic(f);;
        addFlower.setOnAction(e -> addFlower());
        
        ImageView g = new ImageView(new Image("grass1.png"));
        g.setFitWidth(80);
        g.setFitHeight(50);
        Button addGrass = new Button();
        addGrass.setGraphic(g);;
        addGrass.setOnAction(e -> addGrass());
		
        ImageView t = new ImageView(new Image("tree1.png"));
        t.setFitWidth(80);
        t.setFitHeight(50);
        Button addTree = new Button();
        addTree.setGraphic(t);;
        addTree.setOnAction(e -> addTree());
        
		left.getChildren().addAll(startButton,pauseButton,addFlower,addGrass,addTree);
		
		root.setLeft(left);

		root.setCenter(center);
		
		left.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
		center.setBackground(new Background(new BackgroundFill(Color.WHEAT, CornerRadii.EMPTY, Insets.EMPTY)));
		
		//add the plants to the center and set the initial position
		for (int i = 0; i < plants.size(); i++) {
			center.getChildren().add(plants.get(i).imageView);
			plants.get(i).imageView.setLayoutX(plants.get(i).x);
			plants.get(i).imageView.setLayoutY(plants.get(i).y);
		}
		
		
		//add all the bugs to the center and set the initial position
		for (int i = 0; i < bugs.size(); i++) {
			center.getChildren().add(bugs.get(i).imageView);
			bugs.get(i).imageView.setLayoutX(bugs.get(i).getX());
			bugs.get(i).imageView.setLayoutY(bugs.get(i).getY());
		}
		
		//add the sun to the center
		center.getChildren().add(sun.imageView);
		sun.imageView.setLayoutX(sun.x);
		sun.imageView.setLayoutY(sun.y);
		
		
		KeyFrame frame = new KeyFrame(Duration.millis(16), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent t) {
								
				for (Plant plant : plants) {
					plant.grow();
				}
				
				for(Bug bug : bugs) {
					
					// boundary check, if the bug goes out of bound, change speed negative.
					if (bug.getX() < 5
							|| (bug.getX() + bug.imageView.getFitWidth()) > scene.getWidth() - 100) {
						bug.speedX = -bug.speedX;
					}
					if (bug.getY() < 0
							|| (bug.getY() + bug.imageView.getFitHeight()) > scene.getHeight() - 10) {
						bug.speedY = -bug.speedY;
					}																							
							
					bug.move(bug.getNextMove());
					bug.setNextMove(getNextDirection(bug));
						
					bug.setEnergy(bug.getEnergy() - bug.getEnergyConsume());
			
					bug.imageView.setLayoutX(bug.getX());
					bug.imageView.setLayoutY(bug.getY());
					
					//The centerX and centerY of the bug
					double bugCenterX = bug.getX() + bug.width/2;
					double bugCenterY = bug.getY() + bug.height/2;
					
					//If the center of the bug comes into the bound of the plant, the bug will eat the plant
					//When the plant is being eaten, the plant will shrink.
					//There is a chance of 5% that the plant will be eaten.
					for (int i = 0; i < plants.size(); i++) {
						if(plants.get(i).isTouched(bugCenterX, bugCenterY)) {
							if(Math.random() < 0.05) {
								bug.eat(plants.get(i));
								plants.get(i).shrink();
							}
							
						}
						
					}
					
				}
			}			
		});
				
		timeline.setCycleCount(javafx.animation.Animation.INDEFINITE);
		timeline.getKeyFrames().add(frame);
		timeline.play();


		primaryStage.setScene(scene);
		primaryStage.setTitle("Bug World");
		primaryStage.show();
		
		
	}
	
	public Direction getNextDirection(Bug bug) {
	// set the direction of the bug
	// 80% of chance that the bug will follow its former direction.	
		Direction nextDir;
		double random = Math.random();
		if (random < 0.8) {
			nextDir = bug.getNextMove();
		} else if (random < 0.85) {
			nextDir = Direction.UP;
		} else if (random < 0.9) {
			nextDir = Direction.DOWN;
		} else if (random < 0.95) {
			nextDir = Direction.LEFT;
		} else {
			nextDir = Direction.RIGHT;
		}		
			return nextDir;
	}
	
	
    public void start() {
	  timeline.play();	
    }

   public void pause() {
	  timeline.pause();;	
    }
		
   
		
	public void addFlower() {
		double x = (int)(Math.random()*scene.getWidth());
		double y = (int)(Math.random()*scene.getHeight());
		Plant newFlower = new Flower(x, y);
		plants.add(newFlower);
		center.getChildren().add(newFlower.imageView);
		newFlower.imageView.setLayoutX(newFlower.x);
		newFlower.imageView.setLayoutY(newFlower.y);
	}
	
	public void addGrass() {
		double x = (int)(Math.random()*scene.getWidth());
		double y = (int)(Math.random()*scene.getHeight());
		Plant newGrass = new Grass(x, y);
		plants.add(newGrass);
		center.getChildren().add(newGrass.imageView);
		newGrass.imageView.setLayoutX(newGrass.x);
		newGrass.imageView.setLayoutY(newGrass.y);
	}
	
	public void addTree() {
		double x = (int)(Math.random()*scene.getWidth());
		double y = (int)(Math.random()*scene.getHeight());
		Plant newTree = new Tree(x, y);
		plants.add(newTree);
		center.getChildren().add(newTree.imageView);
		newTree.imageView.setLayoutX(newTree.x);
		newTree.imageView.setLayoutY(newTree.y);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launch(args);
	}

}
