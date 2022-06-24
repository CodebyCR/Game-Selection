import javax.swing.*;
import java.util.ArrayList;

public class Menu {

    private static ArrayList<Player> playerList = Player.playerList;

    public static void getMenu() {

        String menuChoose = "";
        menuChoose = JOptionPane.showInputDialog("Welcome to the Game Selection!\n"
                + "Please choose an option:\n"
                + "1. Rock Paper Scissors\n"
                + "2. Coin Throw\n"
                + "3. Statistic\n"
                + "4. Add / Remove_Player\n"
                + "5. Exit\n");


        boolean chooseIsValid = true;

        while (chooseIsValid) {

            Player.addPlayers(true);

            switch (menuChoose) {
                case "Rock Paper Scissors":
                    new RockPaperScissorsGame();
                    //add multipayer..
                    break;

                case "Coin Throw":
                    new CoinThrowGame();
                    break;

                case "Statistic":
                    if (JOptionPane.showInputDialog("You want to see the statistics? [ yes | no ].").equalsIgnoreCase("yes")) {
                        Statistics.show();
                    }else{
                        chooseIsValid = false;
                    }
                    break;

                case "Add_/_Remove_Player":
                    Player.addOrRemove();
                    break;

                case "Exit":
                    JOptionPane.showMessageDialog(null, "See you soon. :) ");
                    break;

                default:
                    chooseIsValid = false;
                    JOptionPane.showMessageDialog(null, "Invalid Input.\nPleace menuChoose an Option.");
            }
        }
    }

}
