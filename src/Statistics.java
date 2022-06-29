import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Statistics {

    private static ArrayList<Player> playerList = Player.playerList;
    private static int wins = 0;
    private static int loses = 0;
    private static int gameCount = 0;

    public static String score = "";

    public Statistics() {
        //Start statistics
    }


    public static void show() {
        for (Player player : playerList) {
            String statisticMessage = player.getName() + " hat " + player.getStatistics().getWin() + " von seinen " +
                    (player.getStatistics().getWin() + player.getStatistics().getLose()) + " Spiele gewonnen," + "\n dass sind " +
                    player.getStatistics().winPercentage((player.getStatistics().getWin() + player.getStatistics().getLose())) + "% of all Games.";

            JOptionPane.showMessageDialog(null, statisticMessage);
        }
    }


    /*
     * Increase won games counter
     */
    public int wonGame() {
        wins++;
        gameCount++;

        return wins;
    }

    /*
     * Increase lose games counter
     */
    public int loseGame() {
        loses++;
        gameCount++;

        return loses;
    }

    /*
     * Calculate the percentage of wins of played games.
     */
    public double winPercentage(int games) {
        if(games == 0) {
            return 0;
        }

        double temp = 100 / games;
        double result = (temp * wins);

        return result;
    }

    /*
     * Write the score for every member and do a return to txt out.
     */
    public static String score(Player player, String winOrLose) {
        String score = "Game Nr." + gameCount + "\t" + "Player: " + player.getName() + "\n\t\t" + "Your choice was "
                + player.getHeadOrNumber() + ".";

        return score;
    }


    /*
     * write and read the Game_Statistic.txt
     */
    public void txtOut(String score) {
        try (FileWriter outputStream = new FileWriter("\\Game_Statistic.txt")) {
            outputStream.write(score);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Scanner scan = new Scanner(new File("Game_Statistic.txt"))) {

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                JOptionPane.showMessageDialog(null, line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // -------Get & Set------------------

    public int getWin() {
        return wins;
    }

    public int getLose() {
        return loses;
    }

    public int getGameNumber() {
        return gameCount;
    }


}
