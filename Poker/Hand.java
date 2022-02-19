package com.company;

import java.util.ArrayList;

public class Hand {

    public static final int HAND_SIZE = 13;

    private ArrayList<Card> cardsHand = new ArrayList<>();

    public Hand() {

    }

    public void fillHand (Deck deck) {

       // Deck deck = new Deck();
        cardsHand.add(deck.getTopCard());

        boolean flag = false;

       for (int j = 0; j < HAND_SIZE ; j++) {

            Card nextCard = deck.getTopCard();
            for (int i = cardsHand.size()-1; i >= 0; i--) {

                if (cardsHand.get(i).getSuit() == nextCard.getSuit()) {
                  flag = true;

                }

            }
            if (flag==false) {
                cardsHand.add(nextCard);
                flag = true;
            }




/*

        for (int i = cardsHand.size(); i > 0; i--) {

            if (cardsHand.get(i - 1).getSuit() == cardsHand.get(i).getSuit()) {


                if (cardsHand.get(i).getRank() < cardsHand.get(i-1).getRank() )
                {
                    Card temp = cardsHand.get(i);
                    cardsHand.remove(i);
                    cardsHand.add(i-1,temp);
                }

            }

        }
*/

    }




       /* for (int i = 0; i < HAND_SIZE; i++) {
            cardsHand.add(deck.getTopCard());

        }*/

    }




    /**
     * Print the hand
     * @return the string representation for the 13 cards of the hand
     */
    @Override
    public String toString()
    {
        return "Hand: " + cardsHand;
    }


}
