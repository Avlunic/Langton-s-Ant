import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Game extends JPanel implements ActionListener, KeyListener{

	private static final long serialVersionUID = 1L;
	Map Map;
	Ant Ant;
	int turnsCompleted;
	double direction;
	double whiteSquare;
	double blackSquare;
	boolean backGround;
	Timer T;
	
	//Initializes a new game
	public Game() {
		
		setPreferredSize(new Dimension(1920, 1080));
		setBackground(new Color(100, 100, 100));
		this.setFocusable(true);
		this.addKeyListener(this);
		
		Map = new Map();
		Ant = new Ant();
		this.whiteSquare = Math.PI/2;
		this.blackSquare = Math.PI/2;
		this.turnsCompleted = 0;
		T = new Timer(1, this);
		this.backGround = true;
		
		repaint();
		
	}
	
	//Runs every time the timer calls an action
	@Override
	public void actionPerformed(ActionEvent e) {

		if (Ant.getX() == 0 || Ant.getX() == 192 || Ant.getY() == 0 || Ant.getY() == 108) {
			
			T.stop();
			
		}
		
		if (Map.getValue(Ant.getX(), Ant.getY()) == "White") {
			
			Map.setValue(Ant.getX(), Ant.getY(), "Black");
			Ant.addTheta(whiteSquare);
			Ant.move();
			
		}
		
		else if (Map.getValue(Ant.getX(), Ant.getY()) == "Black") {
			
			Map.setValue(Ant.getX(), Ant.getY(), "White");
			Ant.addTheta(blackSquare);
			Ant.move();
			
		}
		
		this.turnsCompleted++;
		repaint();
		
	}
	
	//Paints the board, ant, and background if applicable
	@Override
	public void paintComponent(Graphics g) {
		
		Map.paintBoard(g);
		Ant.drawAnt(g);
		
		g.setColor(new Color(0, 0, 0));
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		g.drawString("Turns Completed = " + this.turnsCompleted, 100, 800);
		
		if (backGround == true) {
			
			g.setColor(new Color(0, 0, 0));
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
			g.drawString("Press any key to begin", 500, 450);
			
			g.setColor(new Color(0, 0, 0));
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
			g.drawString("Press the \"R\" key to reset", 575, 500);
			
		}
		
	}

	//Satisfies the actionListner implementation
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	//Starts and resets the game based on user input
	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_R) {
			
			Map.generateMap();
			Ant.resetAnt();
			backGround = true;
			
		}
		
		if (backGround == true) {
			
			T.stop();
			
			try {
				
				this.direction = Double.parseDouble(JOptionPane.showInputDialog(null, "When approaching a white square, should the ant turn Left (1) or Right (2) ?"));
				JOptionPane.getRootFrame().dispose();
			
				if (this.direction == 1.0) {
				
					this.whiteSquare = Math.PI/2*(int)(Double.parseDouble(JOptionPane.showInputDialog(null, "How many times should it turn 90 degrees?")));
					JOptionPane.getRootFrame().dispose();
				
				}
			
				else if (this.direction == 2) {
				
					this.whiteSquare = -Math.PI/2*(int)(Double.parseDouble(JOptionPane.showInputDialog(null, "How many times should it turn 90 degrees?")));
					JOptionPane.getRootFrame().dispose();
				
				}
		
				this.direction = ((int)(Double.parseDouble(JOptionPane.showInputDialog(null, "When approaching a black square, should the ant turn Left (1) or Right (2) ?"))));
				JOptionPane.getRootFrame().dispose();
			
				if (this.direction == 1) {
				
					this.blackSquare = Math.PI/2*(int)(Double.parseDouble(JOptionPane.showInputDialog(null, "How many times should it turn 90 degrees?")));
					JOptionPane.getRootFrame().dispose();
				
				}
			
				else if (this.direction == 2) {
				
					this.blackSquare = -Math.PI/2*(int)(Double.parseDouble(JOptionPane.showInputDialog(null, "How many times should it turn 90 degrees?")));
					JOptionPane.getRootFrame().dispose();
				
				}
			
			}
			
			catch (Exception me) {
				
			}
		
			backGround = false;
			T.start();
		
		}
		
	}

	//Satisfies the actionListner implementation
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
}
