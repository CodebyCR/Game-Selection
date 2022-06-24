import javax.swing.*;
import java.util.ArrayList;

public class Player {
    public static ArrayList<Player> playerList = new ArrayList<Player>();

    //Attributes
    private String playername;

    private String handSign;
    private Statistics statistics;
    private Coin coin;
    private String headOrNumber;

    //default constructor
    public Player() {

    }

    //construkter for new Players.
    public Player(String playername) {
        this.playername = playername;
        statistics = new Statistics();
        coin = new Coin();
    }

    /**
     * Add new Players to the playerList.
     *
     * @param playerReady
     */
    public static void addPlayers(boolean playerReady) {
        while (!playerList.isEmpty() && playerReady) {
            String playerName = JOptionPane.showInputDialog("Pleace enter your name.");

            if (playerList.add(new Player(playerName))) {
                playerReady = !JOptionPane.showInputDialog("Do you want to add more players?\n [ yes | no ].")
                        .equalsIgnoreCase("yes");
            }
        }
    }

    public static void addOrRemove() {
        boolean addPlayer = !JOptionPane.showInputDialog("Want you to add or remove players?\n [ add | remove ].")
                .equalsIgnoreCase("add");

        if (addPlayer) {
            Player.addPlayers(false);
        } else {
            //remove player(s)
        }
    }

    //-------Get & Set------------------

    public String getPlayername() {
        return playername;
    }

    public String setPlayername(String playername) {
        return this.playername = playername;
    }

    public String getHeadOrNumber() {
        return headOrNumber;
    }

    public String setHeadOrNumber(String headOrNumber) {
        return this.headOrNumber = headOrNumber;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public Coin getCoin() {
        return coin;
    }

}

