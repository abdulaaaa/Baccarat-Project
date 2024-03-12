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
    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

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
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private final int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        if (value >= 10) {
            return 0;
        }
        return value;
    }
}
