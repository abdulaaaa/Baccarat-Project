/*
 * File: Card.java
 * -------------------
 * This file contains the structure followed for each and every card. Each
 * card contains a Rank (number,ace,king,queen or jack) or Suit (diamond,
 * spades, clubs, or hearts).
 *
 * Author: Abdul Wajid Arikattayil
 * Date: March 11, 2024
 */

package org.project.baccarat;

class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
}

enum Suit {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES
}

enum Rank {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING
}
