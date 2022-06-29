import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class RockPaperScissorsGame {

    private static ArrayList<Player> playerList = Player.playerList;

    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSORS = 3;
    private final static HashMap<Integer, String> signSelection = new HashMap<Integer, String>() {{
        put(ROCK, "Rock");
        put(PAPER, "Paper");
        put(SCISSORS, "Scissors");
    }};


    public RockPaperScissorsGame() {
        runRockPaperScissors();
    }

    private void runRockPaperScissors() {


        String[] playmodis = {
                "Choose your weapon:\n",
                "Rock Paper or Scissors?\n",
                "Schnick, Schnak, Schnuck.\n"};

        String currentPlayMode = playmodis[RandomReturn.fromRangeOf(0, 2)];

        playRockPaperScissors(currentPlayMode);
    }

    public void playRockPaperScissors(String currentPlayMode) {
        boolean nextRound = true;

        while (nextRound) {
            for (Player currentPlayer : playerList) {

                String choice = JOptionPane.showInputDialog(null, currentPlayMode
                        + "\n1) Rock"
                        + "\n2) Paper"
                        + "\n3) Scissors");
                currentPlayer.setHandSign(choice);


                int comChoice = RandomReturn.fromRangeOf(ROCK, SCISSORS);

                String result = calculateResult(currentPlayer, comChoice);

                JOptionPane.showMessageDialog(null, result);
            }

            String roundMessage = "Do you want to play again? ;) \n1)\tYes\n2)\tNo";
            String wantNextRound = JOptionPane.showInputDialog(null, roundMessage);
            nextRound = wantNextRound.equalsIgnoreCase("1");
        }

        JOptionPane.showMessageDialog(null, "Back to the menu.\n");
    }

    private String calculateResult(Player currentPlayer, int comChoise) {
        Statistics currentStatistics = currentPlayer.getStatistics();
        int playerChoice = currentPlayer.getHandSign();
        String playerSign = signSelection.get(playerChoice);
        String comSign = signSelection.get(comChoise);
        String chooses = "Your choice was " + playerSign + " and the computer choose " + comSign + ".";


        if (playerChoice == comChoise) {
            return "Ha! undecided :D\n";
        }

        boolean YouWin = playerChoice == ROCK & comChoise == SCISSORS
                || playerChoice == PAPER & comChoise == ROCK
                || playerChoice == SCISSORS & comChoise == PAPER;


        if (YouWin) {
            currentStatistics.wonGame();
            return "You win!!!/n " + chooses + " :)";

        } else {
            currentStatistics.loseGame();
            return "You Lose :(/n " + chooses + ".";
        }

    }


}
