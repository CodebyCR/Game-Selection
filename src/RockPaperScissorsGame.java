import javax.swing.*;

public class RockPaperScissorsGame {

    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSORS = 3;

    public RockPaperScissorsGame() {
        runRockPaperScissors();
    }

    private void runRockPaperScissors() {

        String[] playmodis = {
                "Choose your weapon:\n",
                "Rock Paper or Scissors?\n",
                "Schnick, Schnak, Schnuck.\n"};

        String currentPlayMode = playmodis[RandomGame.rendomNumber(0, 2)];

        playRockPaperScissors(currentPlayMode);
    }

    public  void playRockPaperScissors (String currentPlayMode) {
        boolean nextRound = true;

        while(nextRound){
            String choise = JOptionPane.showInputDialog(null, currentPlayMode
                    + "\n1) Rock"
                    + "\n2) Paper"
                    + "\n3) Scissors");

            int myChoise = Integer.parseInt(choise);
            int comChoise = RandomGame.rendomNumber(1, 3);

            String result = calculateResult(myChoise, comChoise);

            JOptionPane.showMessageDialog(null, result);

            String roundMessage = "Next round? ;) \n1)\tYes\n2)\tNo";
            String wantNextRound = JOptionPane.showInputDialog(null,roundMessage);
            nextRound = wantNextRound.equalsIgnoreCase("1");
        }

        JOptionPane.showMessageDialog(null, "Back to the menu.\n");
    }

    private String calculateResult(int myChoise, int comChoise) {

        if (myChoise == comChoise) {
            return "Ha! undecided :D\n";
        }

        boolean YouWin = myChoise == ROCK & comChoise == SCISSORS
                || myChoise == PAPER & comChoise == ROCK
                || myChoise == SCISSORS & comChoise == PAPER;

        String[] selection = {
                "Rock",
                "Paper",
                "Scissors"};

        if(YouWin){
            //comChoise to String
            return "You win!!!/n Your choise was " + selection[myChoise -1] + " and the computer choose " +  selection[comChoise -1] +  ". :)";
        }
        else{
            return "You Lose :(/n Your choise was " + selection[myChoise -1] + " and the computer choose " +  selection[comChoise -1 ] +  ".";
        }

    }



}
