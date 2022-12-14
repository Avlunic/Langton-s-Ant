import java.awt.Color;
import java.awt.Graphics;

public class Map {

	String[][] Board;
	
	//Makes a new 2d array to act as the board
	public Map() {
		
		this.Board = new String[192][108];
		generateMap();
		
	}
	
	//Adds initial values to the board
	public void generateMap() {
		
		for (int i = 0; i < 192; i++) {
			
			for (int j = 0; j < 108; j++) {
				
				this.Board[i][j] = "White";
				
			}
			
		}
		
	}
	
	//Returns a value on the board
	public String getValue(int x, int y) {
		
		return this.Board[x][y];
		
	}
	
	//Sets a value on the board
	public void setValue(int x, int y, String s) {
		
		this.Board[x][y] = s;
		
	}
	
	//Paints the each value on the board either white or black depending on the board value
	public void paintBoard(Graphics g) {
		
		for (int i = 0; i < 192; i++) {
			
			for (int j = 0; j < 108; j++) {
				
				if (Board[i][j] == "White") {
					
					g.setColor(new Color(255, 255, 255));
					g.fillRect(i * 10, j * 10, 10, 10);
					
				}
				
				else if (Board[i][j] == "Black") {
					
					g.setColor(new Color(0, 0, 0));
					g.fillRect(i * 10, j * 10, 10, 10);
					
				}
				
			}
			
		}
		
	}
	
}
