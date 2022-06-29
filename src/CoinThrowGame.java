import javax.swing.*;
import java.util.ArrayList;

public class CoinThrowGame {
    boolean play = true;
    private static ArrayList<Player> playerList = Player.playerList;

    public CoinThrowGame() {
        //Start coinThrowGame
        runCoinThrowGame();
    }


    private void runCoinThrowGame() {

        while (play) {

            for (Player player : playerList) {
                player.setHeadOrNumber(JOptionPane.showInputDialog(player.getName() + " choose 'Head' or 'Number'.\n"));

                String winOrLose = winOrLose(player);
                JOptionPane.showMessageDialog(null, winOrLose);

                //Add result of player game
                Statistics.score += Statistics.score(player, winOrLose) + "\n";

            }

            play = JOptionPane.showInputDialog("Are you ready for the next round? [ yes | no ].").equalsIgnoreCase("yes");

            if (!play) {
                JOptionPane.showMessageDialog(null, "Back to menu.\n");
            }

        }
    }


    /**
     * Calculate the result of the game.
     *
     * @param player
     * @return
     */
    public static String winOrLose(Player player) {
        String winOrLose;

        String result = player.getCoin().flip();

        if (result.equalsIgnoreCase(player.getHeadOrNumber())) {
            winOrLose = "Win!!!\n";
            player.getStatistics().wonGame();
        } else {
            winOrLose = "Lose.. :(\n";
            player.getStatistics().loseGame();
        }

        return winOrLose;

    }

}
