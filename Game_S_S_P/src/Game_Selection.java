/********************************************************************************************************
*																										*
*							Christoph Rohde - Schere, Stein, Papier Class								*
*																										*
*									All rights reserved - Version 1.0									*
*																										*
*									Fehlermeldung bei keinern Eingabe!									*																
*																										*
********************************************************************************************************/
import javax.swing.JOptionPane;

public class Game_Selection {		//Schere, Stein, Papier.
	
	public static void game_menu_ssp() {
		String blend_layout;
		int choise_blend = RandomGame.rendomNumber(1, 3);

		//This is for a random Playmodus, for more Variation.
		switch(choise_blend) {
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

	public static void play_ssp (int my_choise) {	
		String game_out = "";
		int com_choise = RandomGame.rendomNumber(1, 3);
		
		if (my_choise == com_choise ){
			game_out = "Ha! Unentschieden :D";
		}
		else if (my_choise == 1 & com_choise == 3){
			game_out = "Du hast Gewonnen, ich hatte das Papier. :( ";
		}
		else if (my_choise == 2 & com_choise == 1){
			game_out = "Du hast Gewonnen, ich hatte die Schere. :( ";
		}
		else if (my_choise == 3 & com_choise == 2){
			game_out = "Du hast Gewonnen, ich hatte den Stein. :( ";
		}
		else if (my_choise == 1 & com_choise == 2){
			game_out = "Ich hab Gewonnen, ich hatte den Stein. :) ";
		}
		else if (my_choise == 2 & com_choise == 3){
			game_out = "Ich hab Gewonnen, ich hatte das Papier. :) ";
		}
		else if (my_choise == 3 & com_choise == 1){
			game_out = "Ich hab Gewonnen, ich hatte die Schere. :) ";
		}
		else {//if(my_choise != 1 | my_choise != 2| my_choise != 3){
			game_out = "Hay, nicht schummeln. :P ";
		}
		
		JOptionPane.showMessageDialog(null, game_out);

		String roundMessage = "Noch eine Runde? ;) \n1)\tJa\n2)\tNein";
		String runde = JOptionPane.showInputDialog(null,roundMessage);
		int runde_int = Integer.parseInt(runde);
		
		if (runde_int == 1) {
			game_menu_ssp();
		}
		else {
			JOptionPane.showMessageDialog(null, "Bis zum n�chsten mal. :) ");	
		}
	}

	
	public static void main(String[] args) {
		game_menu_ssp();
	}

	
}


