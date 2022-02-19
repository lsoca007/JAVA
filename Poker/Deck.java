package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    public static final int DECK_SIZE = 52;
    private ArrayList<Card> cardsDeck = new ArrayList<>();

    public Deck() {
        while (cardsDeck.size() < DECK_SIZE) {
            fill_suit("Heart");
            fill_suit("Spade");
            fill_suit("Club");
            fill_suit("Diamond");
        }


    }

    private void fill_suit (String suit) {

        for (int i = 2; i < 15; i++) {
            Card card = new Card(i,suit);
            cardsDeck.add(card);

        }
    }


    /**
     * Get the last card from the deck
     * @return last card
     */
    public Card getTopCard () {

        // get the last card from the deck
        Card topCard = cardsDeck.get( cardsDeck.size() - 1 );

        // remove the last card from the deck
        cardsDeck.remove(cardsDeck.size() - 1 );

        return topCard;
    }

    public void shuffle () {

        Random ran = new Random();  //creates a random object
        for (int i = 0; i < cardsDeck.size(); i++) {

            Card currentCard = cardsDeck.get(i);
            cardsDeck.remove(i);
            int randomIndex = ran.nextInt(cardsDeck.size());

            cardsDeck.add(randomIndex,currentCard);
        }

    }

    /**
     * Print the deck of cards
     * @return the deck representation with 52 cards
     */
    @Override
    public String toString()
    {
        return "Deck: " + cardsDeck;

    }


}
