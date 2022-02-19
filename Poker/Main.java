package com.company;

public class Main {

    public static void main(String[] args) {

        //Card card = new Card(11,"Heart");

      //  System.out.print(card.toString());

        Deck deck = new Deck();
        System.out.println(deck.toString());
        deck.shuffle();
        System.out.println(deck.toString());

        Hand hand = new Hand();
        hand.fillHand(deck);
        System.out.println(hand.toString());



    }
}
