/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author User
 */
// GoFishPlayer.java

import java.util.ArrayList;

public class GoFishPlayer extends Player {

    private GroupOfCards hand;
    private int score;

    public GoFishPlayer(String name) {
        super(name);
        hand = new GroupOfCards(0);
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

    @Override
    public void play() {
        // The logic for a player's turn in the Go Fish game will be implemented in the GoFishGame class
    }

    public boolean hasCardWithRank(String rank) {
        for (Card card : hand.getCards()) {
            if (card.getRank().equalsIgnoreCase(rank)) {
                return true;
            }
        }
        return false;
    }

    public void transferCards(GoFishPlayer otherPlayer, String rank) {
        ArrayList<Card> cardsToTransfer = new ArrayList<>();
        for (Card card : hand.getCards()) {
            if (card.getRank().equalsIgnoreCase(rank)) {
                cardsToTransfer.add(card);
            }
        }

        for (Card card : cardsToTransfer) {
            hand.getCards().remove(card);
        }

        otherPlayer.getHand().getCards().addAll(cardsToTransfer);
        score++;
    }
}
