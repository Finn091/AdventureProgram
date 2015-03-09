package main;

import java.util.Random;

import javax.swing.JOptionPane;

/**To do:
 * Add while loop to allow user to go back to previous screen
 * Add graphics for each character
 * Add random name generator
 * Add difficulty scaling
 * Add save data
 * Finish commenting code
 * Solve suppressed warnings annotations
 * Add tooltips
 * 
 * @version 0.1
 * @author Jackson Murrell
 * @author J. L. Finley
 */
public class Player 
{
	final byte BASE_HEALTH = 50;
	short MAX_HEALTH;
	final short MAX_MANA = 100;
	private int difficultyNumber;
	final byte MIN_HEALTH = 0;
	final byte MIN_MANA = 0;
	public String playerName;
	public String playerClass;
	public String difficultyName;
	private byte chanceOfAttack;
	private int initialAttackDamage;	
	private final byte BASIC_ATTACK = 10;
	private final byte HEAVY_ATTACK = 50;
	private final byte PERCENT = 100;

	Random randomNum = new Random();
	
	public Player(int difficultyNumber, String difficultyName, String name, String className)
	{
		this.difficultyNumber = difficultyNumber;
		MAX_HEALTH = (short) (BASE_HEALTH * difficultyNumber);
		playerName = name;
		playerClass = className;
		this.difficultyName = difficultyName;
	}
	public String getPlayerName()
	{
		return playerName;
	}
	public String getPlayerClass()
	{
		return playerClass;
	}
	public int getMAX_HEALTH()
	{
		//For testing purposes only
		System.out.println("Inside getMAX_HEALTH method var MAX_HEALTH line 57 class Player> " + MAX_HEALTH);
		
		return MAX_HEALTH;
	}
	public int damagePlayer(int damage, int health)
	{
		health -= damage;
		
		if(health < 0)
			health = 0;
		
		return health;
	}
	public int healPlayer(int regen, int health)
	{
		health += regen;
		
		if(health > MAX_HEALTH)
			health = MAX_HEALTH;
		
		return health;
	}
	public int getMAX_MANA()
	{
		return MAX_MANA;
	}
	public int getDifficultyNumber()
	{
		return difficultyNumber;
	}
	//This method determines how much damage a basic attack does.
	public int basicAttack(int playerLevel)
	{
		initialAttackDamage = randomNum.nextInt(BASIC_ATTACK);
		
		initialAttackDamage++;
		
		//This makes the player's damage increase with their level.
		initialAttackDamage *= playerLevel;
		
		return initialAttackDamage;
	}
	//This method determines how much damage a heavy attack does, and if it hits.
	public int heavyAttack(int playerLevel)
	{
		chanceOfAttack = (byte)randomNum.nextInt(PERCENT);
	
		chanceOfAttack++;
	
		//For bug testing only
		System.out.println("Percentage chance to hit: " + chanceOfAttack);
	
		//A 50% to hit.
		if (chanceOfAttack >= 50)
		{
			initialAttackDamage = randomNum.nextInt(HEAVY_ATTACK);
			
			initialAttackDamage++;
			
			//This makes the player's damage increase with their level.
			initialAttackDamage *= playerLevel;
			
			return initialAttackDamage;
		}
		else
		{
			//The player missed so their attack damage is zero.
			initialAttackDamage = 0;
			
			JOptionPane.showMessageDialog(null,"Your attack missed.");
		
			return initialAttackDamage;
		}
	}

}
