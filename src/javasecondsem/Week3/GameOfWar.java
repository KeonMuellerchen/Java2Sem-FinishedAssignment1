package javasecondsem.Week3;

import java.util.ArrayList;

/**
 *
 * @author Keon Muellerchen
 */
public class GameOfWar {
    private ArrayList<Card> p1Hand;
    private ArrayList<Card> p2Hand;
    
    /**
     * The constructor will initialize the hands and deal the 
     * cards
     */
    public GameOfWar()
    {
        p1Hand = new ArrayList<>();
        p2Hand = new ArrayList<>();
        
        //create an instance of a DeckOfCards
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        
        //deal all the cards to the players
        while (deck.getNumberOfCardsRemaining()>0)
        {
            p1Hand.add(deck.dealTopCard());
            p2Hand.add(deck.dealTopCard());
        }
    }
    
    /**
     * This method will run continuously until the game is over
     */
    public void playGame()
    {
        while (p1Hand.size()>0 && p2Hand.size()>0)
        {
            ArrayList<Card> warPile = new ArrayList<>();
            playHand(warPile);
        }
        
        if (p1Hand.size()>0)
            System.out.println("Player 1 wins!!");
        else
            System.out.println("Player 2 wins");
    }
    
    /**
     * This method will simulate playing 1 hand of war.  Whoever plays the
     * higher card wins all of the cards from the warPile
     */
    public void playHand(ArrayList<Card> warPile)
    {
        Card p1Card = p1Hand.remove(0);
        Card p2Card = p2Hand.remove(0);
        
        //player 1 wins hand
        if (p1Card.getFaceValue()>p2Card.getFaceValue())
        {
            p1Hand.add(p1Hand.size(), p1Card);  //put the card at the bottom
                                                //of the deck
            p1Hand.add(p1Hand.size(), p2Card);
            p1Hand.addAll(p1Hand.size(), warPile);
            return;
        }
        //player 2 wins hand
        else if (p2Card.getFaceValue()>p1Card.getFaceValue())
        {
            p2Hand.add(p2Hand.size(), p1Card);  //put the card at the bottom
                                                //of the deck
            p2Hand.add(p2Hand.size(), p2Card);
            p2Hand.addAll(p2Hand.size(), warPile);
            return;
        }
        //must be a tie
        else
        {
            warPile.add(p1Card);
            warPile.add(p2Card);
            
            //p1 doesn't have enough cards to play war and loses
            if (p1Hand.size()<4)
            {
               p2Hand.addAll(warPile);
               p2Hand.addAll(p1Hand);
               p1Hand.clear();
               return;
            }
            else if (p2Hand.size()<4)
            {
               p1Hand.addAll(warPile);
               p1Hand.addAll(p2Hand);
               p2Hand.clear();
               return;
            }
            //both players have enough cards for WAR
            for (int i=1; i<=3; i++)
            {
                warPile.add(p1Hand.remove(0));
                warPile.add(p2Hand.remove(0));    
            }
            
            playHand(warPile);
        }
    }
    
    /**
     * This method returns the status of the game
     */
    public String getStatus()
    {
        String p1Status = String.format("P1 # of cards: %2d, %15s",p1Hand.size(),
                                                        p1Hand.get(0));
        String p2Status = String.format("P2 # of cards: %2d, %15s%n",p2Hand.size(),
                                                        p2Hand.get(0));
        return p1Status + "   " + p2Status;
          
    }
}
