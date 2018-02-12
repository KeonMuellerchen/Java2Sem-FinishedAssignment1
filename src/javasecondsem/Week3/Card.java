package javasecondsem.Week3;

import javasecondsem.Week2.*;

/**
 * Card Game
 * @author Keon Muellerchen
 */
public class Card {
    private String faceName, suit;
    private int faceValue;
    private static final String[] faceNames = { "2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
    private static final String[] validSuits = {"hearts","spades","clubs","diamonds"}; 
    
    public Card(String faceName, String suit)
    {
        setFaceName(faceName);
        setSuit(suit);
        setFaceValue();
    }//end of card

    public String getFaceName() {
        return faceName;
    }//end of getFaceName

    public void setFaceName(String faceName) {
        for (String validFaceName : faceNames)
        {
            if (validFaceName.equalsIgnoreCase(faceName))
            {
                this.faceName = faceName;
                return;
            }
        }
        throw new IllegalArgumentException("Valid face names are 2-10, jack, queen, and king");
        
    }//end of setFaceName

    public String getSuit() {
        return suit;
    }//end of getSuit

    /**
     * This method will validate the suit entered as an argument to be hearts,
     * diamonds, spades or clubs and set the suit instance variable
     * @param suit 
     */
    public void setSuit(String suit) {
        for (String validSuit : validSuits)
        {
            if (validSuit.equalsIgnoreCase(suit)){
                this.suit = suit.toLowerCase();
                return;
            }
        }
        throw new IllegalArgumentException("Suit must be hearts, diamonds, spades or clubs");
    }//end of setSuit

    public int getFaceValue() {
        return faceValue;
    }//end of getFaceValue

    private void setFaceValue() {
        
        for (int index=0; index<faceNames.length; index++)
        {
            if (faceNames[index].equalsIgnoreCase(faceName))
            {
                faceValue = index+2;
                return;
            }
        }
        throw new IllegalArgumentException("face name of card is invalid");
    }//end of setFaceValue
    
    /**
     * This method will override the toString() method in the object class and represent a card as "faceName of suit".
     * @return 
     */
    @Override
    public String toString()
    {
        return faceName + " of " + suit;
    }// end of toString
}//end of class
