/********************************************************************************************************
 *																										*
 *	Game_Selection by Christoph Rohde 																	*
 *																										*
 *	- Version 2.0																						*
 *																										*
 *	feel free to modify, and have fun to code.							 								*
 *																										*
 ********************************************************************************************************/
import javax.swing.JOptionPane;


public class Game_Selection {		//Schere, Stein, Papier.

private static final int ROCK = 1;
private static final int PAPER = 2;
private static final int SCISSORS = 3;

	public static void game_menu_ssp() {
		String blend_layout;
		int playmodi = RandomGame.rendomNumber(1, 3);

		//This is for a random playmodus, for more variation.
		//refactor to map
		switch(playmodi) {
				//enemy
			case 1: blend_layout = "W�hle deine Waffe: ";
				break;
				//classic 1
			case 2: blend_layout = "Schere Stein oder Papier?";
				break;
				//classic 2
			default: blend_layout = "Schnick, Schnak, Schnuck.";
		}
		
		String choise = JOptionPane.showInputDialog(null, blend_layout + "\n1) Schere" + "\n2) Stein" + "\n3) Papier");
		
		int my_choise = Integer.parseInt(choise);
		
		play_ssp(my_choise);
		
	}

	public static void play_ssp (int myChoise) {

		int comChoise = RandomGame.rendomNumber(1, 3);


		String result = calculateResult(myChoise, comChoise);

		
		JOptionPane.showMessageDialog(null, result);

		String roundMessage = "Next round? ;) \n1)\tYes\n2)\tNo";
		String wantNextRound = JOptionPane.showInputDialog(null,roundMessage);
		int nextRound = wantNextRound.compareToIgnoreCase("Yes");
		
		if (nextRound == 1) {
			game_menu_ssp();
		}
		else {
			JOptionPane.showMessageDialog(null, "See you soon. :) ");
		}
	}

	private static String calculateResult(int myChoise, int comChoise) {

		if (myChoise == comChoise) {
			return "Ha! Unentschieden :D";
		}

		boolean YouWin = myChoise == ROCK & comChoise == SCISSORS
						|| myChoise == PAPER & comChoise == ROCK
						|| myChoise == SCISSORS & comChoise == PAPER;

		//Youlose
		//		|| myChoise == 1 & comChoise == 2
		//		|| myChoise == 2 & comChoise == 3
		//		|| myChoise == 3 & comChoise == 1;

		if(YouWin){
			//comChoise to String
			return "You win!!!/n Your choise was " + myChoise + " and the computer choose " +  comChoise +  ". :)";
		}
		else{
			return "You Lose :(/n Your choise was " + myChoise + " and the computer choose " +  comChoise +  ".";
		}


	}


	public static void main(String[] args) {
		game_menu_ssp();
	}

	
}


