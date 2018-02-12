package javasecondsem.Week3;

import javasecondsem.Week2.*;

/**
 *
 * @author Keon Muellerchen
 */
public class DeckOfCardsTester {
    public static void main(String[] args) {
        
        DeckOfCards deck = new DeckOfCards();   //this calls our constructor and creates a valid deck of cards
        
        deck.shuffle(); 
       
        
        deck.displayDeck();
        System.out.printf("The top card is %s%n", deck.dealTopCard());
        
        System.out.printf("A random card is %s%n", deck.getRandomCard());
        
    }//end of main
}
