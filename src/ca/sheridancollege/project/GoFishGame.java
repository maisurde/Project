/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
* @author Denish Maisuriya

 */

import java.util.Scanner;

public class GoFishGame extends Game 
{

    public GoFishGame(String name) 
    {
        super(name);
    }

    @Override
    public void play() 
    {
        Scanner scanner = new Scanner(System.in);
        int currentPlayerIndex = 0;

        
        GroupOfCards deck = createAndShuffleDeck();

        
        dealInitialCards(deck);

        while (!isGameOver(deck)) 
        {
            GoFishPlayer currentPlayer = getPlayers().get(currentPlayerIndex);
            GoFishPlayer otherPlayer = getOtherPlayer(currentPlayerIndex);

            System.out.println(currentPlayer.getName() + "'s turn.");
            System.out.println("Your hand: " + currentPlayer.getHand().getCards());
            System.out.println("Ask " + otherPlayer.getName() + " for a rank (e.g., 'Ace', 'King'): ");
            String rankToAskFor = scanner.nextLine();

            if (otherPlayer.hasCardWithRank(rankToAskFor)) 
            {
                
                currentPlayer.transferCards(otherPlayer, rankToAskFor);
                System.out.println("You received the requested card(s).");
            } 
            else 
            {
               
                Card drawnCard = drawCardFromDeck(deck);
                currentPlayer.getHand().getCards().add(drawnCard);
                System.out.println("You drew a card: " + drawnCard);
            }

           
            System.out.println("Scores: " + getPlayerScores());

           
            currentPlayerIndex = (currentPlayerIndex + 1) % getPlayers().size();
        }

      
        System.out.println("Game Over!");
        declareWinner();
    }

    private GroupOfCards createAndShuffleDeck() 
    {
        GroupOfCards deck = new GroupOfCards(52);
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) 
        {
            for (String rank : ranks) 
            {
                deck.getCards().add(new Card(rank, suit));
            }
        }

        deck.shuffle();
        return deck;
    }

    private void dealInitialCards(GroupOfCards deck) 
    {
        int numCardsToDeal = 5;
        for (GoFishPlayer player : getPlayers()) 
        {
            for (int i = 0; i < numCardsToDeal; i++) 
            {
                Card drawnCard = drawCardFromDeck(deck);
                player.getHand().getCards().add(drawnCard);
            }
        }
    }

    private boolean isGameOver(GroupOfCards deck) 
    {
        return deck.getSize() == 0 || allPlayersHandEmpty();
    }

    private Card drawCardFromDeck(GroupOfCards deck) 
    {
        if (deck.getSize() > 0) 
        {
            return deck.getCards().remove(0);
        }
        return null;
    }

    private GoFishPlayer getOtherPlayer(int currentPlayerIndex) 
    {
        int otherPlayerIndex = (currentPlayerIndex + 1) % getPlayers().size();
        return (GoFishPlayer) getPlayers().get(otherPlayerIndex);
    }

    private boolean allPlayersHandEmpty() 
    {
        for (GoFishPlayer player : getPlayers()) 
        {
            if (!player.getHand().getCards().isEmpty()) 
            {
                return false;
            }
        }
        return true;
    }

    private String getPlayerScores() 
    {
        StringBuilder scores = new StringBuilder();
        for (Player player : getPlayers()) 
        {
            scores.append(player.getName()).append(": ").append(((GoFishPlayer) player).getScore()).append(" ");
        }
        return scores.toString();
    }

    @Override
    public void declareWinner() 
    {
        GoFishPlayer winner = (GoFishPlayer) getPlayers().get(0);
        for (GoFishPlayer player : getPlayers()) 
        {
            if (player.getScore() > winner.getScore()) 
            {
                winner = player;
            }
        }
        System.out.println("The winner is: " + winner.getName() + " with a score of " + winner.getScore());
    }
}


