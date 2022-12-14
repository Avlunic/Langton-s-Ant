//Game finalized on 12/13/2022

import java.awt.Color;
import javax.swing.*;

public class App extends JFrame {
	
	private static final long serialVersionUID = 1L;

	//Initializes the game
	public static void newGame() {
		
		JFrame Scene = new JFrame();
		Game Game = new Game();
		Scene.add(Game);
		Scene.setName("Battle Simulator");
		Scene.setBackground(new Color(0, 0, 0));
		Scene.setSize(1920, 1080);
		Scene.setResizable(false);
		Scene.setLocationRelativeTo(null);
		Scene.pack();
		Scene.setContentPane(Game);
		Scene.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Scene.setVisible(true);
		
	}

	//Starts the game sequence
	public static void main(String[] args) {
		
		newGame();

	}

}
