package com.company;

public class Card {

    private int rank;
    private String suit;

    public Card(int value, String suit) {

        if (value==1){
            this.rank = 14;
        }
        else if  (value< 1 || value > 14) {
            return;
        } else {
            this.rank = value;
        }
        this.suit = suit;

    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {

        String str = " ";

        switch (rank) {
            case 11:
                str = "J";
                break;
            case 12:
                str = "Q";
                break;
            case 13:
                str = "K";
                break;
            case 14:
                str = "A";
                break;
            default:
                str = ""+rank;

        }
/*        if ( rank == 11) {
            str = "J";
        } else if (rank == 12) {
            str = "Q";
        } else if (rank == 13) {
            str = "K";
        } else if ( rank == 14) {
            str = "A";
        } else {
            str = ""+rank;
        }*/

/*

        switch (suit) {
            case "Heart":
                str += "\u2665";
            case "Spade":
                str += "\u2660";
            case "Club":
                str += "\u2663";
            case "Diamond":
                str += "\u2666";

        }
*/


       if (suit == "Heart"){
            str += "\u2665";
        }
        if (suit == "Spade"){
            str += "\u2660";
        }
        if (suit == "Club"){
            str += "\u2663";
        }
        if (suit == "Diamond"){
            str += "\u2666";
        }

        return str;

    }
}
