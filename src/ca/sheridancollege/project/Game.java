/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

// Game.java
import java.util.ArrayList;

public abstract class Game {
    private final String name;
    private ArrayList<GoFishPlayer> players;

    public Game(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<GoFishPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<GoFishPlayer> players) {
        this.players = players;
    }

    public abstract void play();

    public abstract void declareWinner();
}
