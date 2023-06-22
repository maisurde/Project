/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author User
 */
// GoFishGame.java

import java.util.ArrayList;

/**
 * A class that represents a Go Fish player.
 */
public class GoFishGame extends Player {

    private GroupOfCards hand;
    private int score;

    public GoFishGame(String name) {
        super(name);
        hand = new GroupOfCards(0); // Update the argument to specify the size of the hand
        score = 0;
    }

    public GroupOfCards getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void play() {
        // Implement the logic for a player's turn in the Go Fish game
        // ...
    }
}



