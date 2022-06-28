import javax.swing.*;
import java.util.ArrayList;

public class Menu {

    private static ArrayList<Player> playerList = Player.playerList;

    public static void getMenu() {

        String menuChoose = "";
        Integer choose = 0;
        boolean chooseIsValid = true;

        Player.addPlayers();

        while (chooseIsValid) {

            menuChoose = JOptionPane.showInputDialog("Welcome to the Game Selection!\n"
                    + "Please choose an option:\n"
                    + "1. Rock Paper Scissors\n"
                    + "2. Coin Throw\n"
                    + "3. Statistic\n"
                    + "4. Add / Remove_Player\n"
                    + "5. Exit\n");


            choose = Integer.valueOf(menuChoose);

            switch (choose) {
                case 1:
                    new RockPaperScissorsGame();
                    //add multipayer..
                    break;

                case 2:
                    new CoinThrowGame();
                    break;

                case 3:
                    if (JOptionPane.showInputDialog("You want to see the statistics? [ yes | no ].").equalsIgnoreCase("yes")) {
                        Statistics.show();
                    }else{
                        chooseIsValid = false;
                    }
                    break;

                case 4:
                    Player.addOrRemove();
                    break;

                case 5:
                    chooseIsValid = false;
                    JOptionPane.showMessageDialog(null, "See you soon. :) ");
                    break;

                default:
                    chooseIsValid = true;
                    JOptionPane.showMessageDialog(null, "Invalid Input.\nPleace choose an Option.");
            }
        }
    }

}
