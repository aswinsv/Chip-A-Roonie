/*
AUTHOR: S.V.Aswin ram
Original Creation Date: 06/09/2017
Last modification Date: 06/10/2017
Description: This program has the following functionalities:
						 1) It gets the name of the user as input
						 2) Prints a customized welcome message for the user.
						 3) Displays the game's author name and the game instructions
						 4) There is a function named RollDie, which generates a random number between given min and max value
						 5) There is a function named playGame, using which the user can play the game
*/
import java.util.*;

import java.util.Random;

class P1A2_SIVARAMANVENKATARAMAN_aswinras
{

/* The below function accepts the username as argument and does the following:
	1) Customized welcome message
	2) Game's author name
	3) Game Instructions
*/	
	public static void welcome(String name)
	{
		System.out.println("*********Let's see if you can get lucky!!**********");
		System.out.println("Hello "+name);
		System.out.println("\n\nGame's Author:S.V.Aswin ram");
		System.out.println("\nGame instructions: A new player begins with his first dice roll (4 die = 1 set of dice). This is known as the starting roll");
		System.out.println("1) If the player rolls a 6, 12, 18, or 24 the player wins");
		System.out.println("2) If the player rolls a 9, 11, 17, 19, or 23 the player loses.");
		System.out.println("3) If the player rolls any other number, the starting roll becomes the goal number.");	
		System.out.println("\t3a)The player must continue to roll the dice until either one of two things happens:");
		System.out.println("\t\t a) The player rolls an 11, and he loses.");
		System.out.println("\t\t b) The player rolls the goal number again, and he wins");

	}

/* Below function accepts two integers as parameter and generates a random number between them. 
	In this game, minimum value is 4 and maximum value is 24, since we have 4 die.*/

	public static int rollDie(int min, int max) {


		Random ran=new Random(); // This is a object of java.util.Random Class

		int randomNum = ran.nextInt((max - min) + 1) + min; // the random number generated between min,max is stored in randomNum variable

    	return randomNum;
	}

// Below function, initiates the game. Based on the user input, either he can continue the game or stop playing it
	public static void playGame()
	{
		/*
			roll_value= The random value generated when the die is thrown is stored in roll_value
			
			goal_number= If a die value which is not equal to [6, 12, 18,24,9, 11, 17, 19,23] is generated, it is stored in 
			this variable. The next time die is thrown, the die result is checked against this variable. The user wins, if the new
			die result equals the goal_number
		*/	

		int roll_value,goal_number,continueGame=1;

		Scanner sc=new Scanner(System.in);


		while(continueGame!=0)
		{
			System.out.println("\nRolling the die!!");

			roll_value=rollDie(4,24);  // Since there are 4 die, the minimum value we can get is 4 and maximum is 24

			System.out.println("\nValue after rolling:"+roll_value);

			if(roll_value==6 || roll_value==12 || roll_value==18 || roll_value==24 )
			{
				System.out.println("\nYou win!!");
			}	
			else if(roll_value==9 || roll_value==11 || roll_value==17 ||roll_value==19 || roll_value==23 )
			{
				System.out.println("\nYou lose!!");
			}	

			else
			{
				
				boolean gameEnded=false; // this variable is used to check if game has ended

				goal_number=roll_value; // Next time when die is thrown, if the roll_value equals this goal_number, the user wins

				while(gameEnded==false)
				{
					System.out.println("\nGoal Number for the next roll:"+goal_number);

					roll_value=rollDie(4,24);

					System.out.println("\nValue after rolling:"+roll_value);

					if(roll_value==11)
						{
							System.out.println("\nYou lose!!");
							gameEnded=true;
						}	
					else if(roll_value==goal_number)
						{
							System.out.println("\nYou win!!");
							gameEnded=true;
						}
					else
					{
						System.out.println("\nNo result has been obtained yet!!");
					}		
				}	
			}	

			System.out.println("\nDo you want to roll the die again? (yes=1,no=0)");
			continueGame=sc.nextInt();

		}	

	} 

	public static void main(String[] args)
	{
		System.out.println("Please enter your name?");

		Scanner sc=new Scanner(System.in);

		String name=sc.next(); // The username entered by the user, is stored in this variable

		welcome(name);

		playGame();
	}
}					

