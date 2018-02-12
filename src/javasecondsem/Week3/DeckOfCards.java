package javasecondsem.Week3;

import javasecondsem.Week2.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Keon Muellerchen
 */
public class DeckOfCards {
    private ArrayList<Card> deck;
    
    public DeckOfCards()
    {
        //creating a deck of cards
        deck = new ArrayList<>();
        String[] faceNames = { "2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
        String[] validSuits = {"hearts","spades","clubs","diamonds"}; 
        
        for (String suit : validSuits)
        {
            for (String faceName : faceNames)
                deck.add(new Card(faceName, suit));
        }
    }//end of method deckOfCards
    
    /**
     * This displays the deck to the console
     */
    public void displayDeck()
    {
        for (Card card:deck)
        {
            System.out.println(card);
        }
    }//end of method displayDeck
    
    /**
     * This method will return the top card in the deck
     */
    public Card dealTopCard()
    {
        return deck.remove(0);
    }//end of Card
    
    /**
     * This will randomize the order of the Cards objects in the deck
     */
    public void shuffle()
    {
        Collections.shuffle(deck);
    }//end of shuffle
    
    /**
     * This method will return a random card from the deck
     */
    public Card getRandomCard()
    {
        SecureRandom rng = new SecureRandom();
        return deck.remove(rng.nextInt(deck.size()));
    }//end of getRandomCard
    
    /**
     * This method returns the number of Cards objects in the deck.
     */
    public int getNumberOfCardsRemaining()
    {
        return deck.size();
    }//end of getNumberOfCardsRemaining
}
