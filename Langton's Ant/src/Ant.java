import java.awt.Color;
import java.awt.Graphics;

public class Ant {
	
	int x;
	int y;
	double theta;

	//Makes a new ant object
	public Ant() {
		
		this.x = 50;
		this.y = 50;
		this.theta = 0;
		
	}
	
	//Draws the ant red at its current location on the 2d array
	public void drawAnt(Graphics g) {
		
		g.setColor(new Color (100, 0, 0));
		g.fillRect(this.x * 10, this.y * 10, 10, 10);
		
	}
	
	//Moves the ant along the 2d array depending on its direction
	public void move() {
		
		this.x += (int)Math.cos(this.theta);
		this.y += (int)Math.sin(this.theta);
		
	}
	
	//Builds upon the theta by adding a new value to the old value
	public void addTheta(double theta) {
		
		this.theta+=theta;
		
	}
	
	//Returns the current theta
	public int getTheta() {
		
		return (int)this.theta;
		
	}
	
	//Returns the current location on the x axis
	public int getX() {
		
		return this.x;
		
	}
	
	//Returns the current location on the y axis
	public int getY() {
		
		return this.y;
		
	}
	
	//Resets the ant to its initial position and theta values
	public void resetAnt() {
		
		this.x = 50;
		this.y = 50;
		this.theta = 0;
		
	}
	
}
