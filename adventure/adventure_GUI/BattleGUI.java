package adventure.adventure_GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.Enemies;
import main.Player;

/**To do:
 * Add while loop to allow user to go back to previous screen
 * Add graphics for each character
 * Add random name generator
 * Add difficulty scaling
 * Add save data
 * Finish commenting code
 * Solve suppressed warnings annotations
 * 
 * @version 0.1
 * @author Jackson Murrell
 * @author J. L. Finley
 */
public class BattleGUI extends JFrame implements ActionListener
{
	final short WINDOW_HEIGHT = 300;
	final short WINDOW_WIDTH = 500;
	
	Player playerClass;
	
	Enemies enemyClass;
		
	JPanel mainPanel, buttonPanel, displayPanel;
	
	JButton basicAttack, heavyAttack, specialAttack, potions;
	
	JLabel playerStatus, enemyStatus;
	
	public BattleGUI(Player playerClass)
	{
		super("Adventures in Auraxia");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.playerClass = playerClass;
		
		enemyClass = new Enemies(this.playerClass);
		System.out.println("Inside BattleGUI var enemyClass> " + this.playerClass.getMAX_HEALTH());
		//Initializing panels.
		mainPanel = new JPanel();
		displayPanel = new JPanel();
		buttonPanel = new JPanel();
		
		basicAttack = new JButton("Basic Attack");
		basicAttack.addActionListener(this);
		
		heavyAttack = new JButton("Heavy Attack");
		heavyAttack.addActionListener(this);
		
		specialAttack = new JButton("Special Attack");
		specialAttack.addActionListener(this);
		
		potions = new JButton("Potions");
		potions.addActionListener(this);
		
		playerStatus = new JLabel("Health: " + this.playerClass.getMAX_HEALTH() + "  Mana: " + playerClass.getMAX_MANA());
		enemyStatus = new JLabel("<html><left>Enemy Health: " + enemyClass.getEnemyHealth() + "</left>");
		
		System.out.print("Enemy health line 63> " + enemyClass.getEnemyHealth());
		
		displayPanel.add(playerStatus);
		displayPanel.add(buttonPanel);
		displayPanel.add(enemyStatus);
		displayPanel.setLayout(new GridLayout(3,1));
		
		buttonPanel.add(potions);
		buttonPanel.add(basicAttack);
		buttonPanel.add(heavyAttack);
		buttonPanel.add(specialAttack);
		
		
		mainPanel.add(displayPanel);
		
		add(mainPanel);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == basicAttack)
		{
			playerClass.basicAttack(1);
		}
		else if(e.getSource() == heavyAttack)
		{
			
		}
	}

}
