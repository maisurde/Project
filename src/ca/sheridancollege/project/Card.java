/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * @author Denish Maisuriya
 */
public class Card 
{

    private final String rank;
    private final String suit;

    public Card(String rank, String suit) 
    {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() 
    {
        return rank;
    }

    public String getSuit() 
    {
        return suit;
    }

    @Override
    public String toString() 
    {
        return rank + " of " + suit;
    }
}


