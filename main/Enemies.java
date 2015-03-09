package main;

import java.util.Random;

public class Enemies 
{
	byte temp = 0;
	int enemyHealth;
	int chanceToHit = 0;
	double healthMultiplier;
	int difficultyNumber;
	int enemyLevel = 1;
	int enemyDamage = 0;
	int healPoints = 0;
	int initialEnemyHealth = 100;
	int intialEnemyDamage = 10;
	int playerHealth;
	
	public String[] enemyTypeArray = {"Bore", "Skeleton", "Spider", "Gelatinous Blob", "Undead", "Fire Elemental", "Water Elemental", "Earth Elemental", "Air Elemental", "Light Elemental", "Shadow Elemental"};
	
	Random randomNum = new Random();
	
	Player playerClass;
	
	Enemies enemyClass;
	
	//Defines the Enemy's initial health
	public Enemies(Player playerClass)
	{
		this.playerClass = playerClass;
		difficultyNumber = this.playerClass.getDifficultyNumber();
		enemyHealth = initialEnemyHealth;
		
	}
	
	public int attackPlayer(int enemyLevel)
	{
		//For bug testing only
	 	System.out.println("Creature level: " + enemyLevel);
	 	
	 	//WRONG Need to fix the logic. The value incrementing is going the wrong way.
		switch(enemyLevel)
		{
		case 1: chanceToHit = 75; break;
		
		case 2: chanceToHit = 65; break;
		
		case 3: chanceToHit = 55; break;
		
		case 4: chanceToHit = 45; break;
		
		case 5: chanceToHit = 35; break;
		
		case 6: chanceToHit = 25; break;
		
		case 7: chanceToHit = 15; break;
		
		case 8: chanceToHit = 5; break;
			
		case 9: chanceToHit = 0; break;
		
		default: chanceToHit = 100; break;
		}
		//For bug testing only.
		System.out.println("Creature's Chance to Hit: " + chanceToHit); 

		temp = (byte)randomNum.nextInt(100);
	 	
		if (temp >= chanceToHit)
		{
			enemyDamage = enemyLevel * intialEnemyDamage;
			//For bug testing only
		 	System.out.println("Creature Damage: " + enemyDamage);
		}
		else
		{
			enemyDamage = 0;
		}
		return enemyDamage;
	}
	
	public int getEnemyHealth()
	{
		System.out.println("Inside getEnemyHealth Method line 79>" + enemyHealth);
		return enemyHealth;
	}
	public int doDamage()
	{
		return intialEnemyDamage;
	}
	
	public int damageEnemy(int attackDamage, int initialEnemyHealth)
	{
		enemyHealth = initialEnemyHealth;
		
		enemyHealth -= attackDamage;
				
		return enemyHealth;
	}
	public int healEnemy(int healPoints, int initialEnemyHealth )
	{
		enemyHealth = initialEnemyHealth;
		
		enemyHealth -= healPoints;
				
		return enemyHealth;
	}
	
	
}
