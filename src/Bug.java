
import javafx.scene.image.ImageView;
import plant.Plant;

public class Bug {

	String name;
	ImageView imageView;
	private double x;
	private double y;
	double speedX;
	double speedY;
	Direction nextMove;
	double width;
	double height;
	private double energy;
	private double energyConsume;

	
	
	public Bug(String name, ImageView imageView,int x,int y,double speedX,double speedY, double width, double height) {
		this.name = name;
		this.imageView = imageView;
		imageView.setFitWidth(width);
		imageView.setFitHeight(height);
		this.x = x;
		this.y = y;
		this.speedX = speedX;
		this.speedY = speedY;
		this.nextMove = Direction.RIGHT;
		this.width = width;
		this.height = height;
		this.energy = 100;
		this.energyConsume = 1;
	}
   
   public boolean getIsHungry() {
	   return getEnergy() <= 80;
   }

	
	public void eat(Plant plant) {
		this.energy += plant.getNutritionPerBite();
		plant.setNutrition(plant.getNutrition() - plant.getNutritionPerBite());	
		
		this.width += 1;
		this.height += 1;
		imageView.setFitHeight(height);
		imageView.setFitWidth(width);
	
	}

	public void move(Direction nextMove) {		

		switch(this.nextMove) {
		case UP: {
		 
			this.y -= speedY;		
			
			break;}
		case DOWN: {		
			
			this.y += speedY;
			
			break;}
		case LEFT: {
    
			this.x -= speedX;
			
			break;}
		case RIGHT: {
			
			this.x += speedX;
			
			break;}
		}
	}
	
	
	
	@Override
	public String toString() {
		return "Bug [name=" + name + ", xLocation=" + x + ", yLocation=" + y + ", speedX=" + speedX + ", speedY=" + speedY
				+ ", nextMove=" + nextMove + ", energy=" + energy + "]";
	}

	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}
	
	public Direction getNextMove() {
		return nextMove;
	}

	public void setNextMove(Direction nextMove) {
		this.nextMove = nextMove;
	}

	public double getEnergy() {
		return energy;
	}

	public void setEnergy(double energy) {
		this.energy = energy;
	}

	public double getEnergyConsume() {
		return energyConsume;
	}	

}
