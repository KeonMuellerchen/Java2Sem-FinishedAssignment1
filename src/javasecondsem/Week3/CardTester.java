package javasecondsem.Week3;

import javasecondsem.Week2.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Keon Muellerchen
 */
public class CardTester {
    public static void main(String[] args)
    {
        //example of instantiating objects
        //class     variable name     calling the constructor with an argument  
        Scanner     keyboard        = new Scanner(System.in);
        Card        card1           = new Card("ace", "spades");
        Card        card2           = new Card("2","hearts");
        
        System.out.printf("card1:  suit: %s   face name: %-5s  value: %d %n", card1.getSuit(), 
                                                    card1.getFaceName(), card1.getFaceValue());
        System.out.printf("card2:  suit: %s   face name: %-5s  value: %d %n", card2.getSuit(), 
                                                    card2.getFaceName(), card2.getFaceValue());
        
        //this should throw an exception
        Card card3 = new Card("ace","JDub");
        System.out.printf("card3:  suit: %s   face name: %-5s  value: %d %n", card3.getSuit(), 
                                                    card3.getFaceName(), card3.getFaceValue());      
        
        DeckOfCards myDeck = new DeckOfCards();
        myDeck.displayDeck();
        
    }//end of main
}
