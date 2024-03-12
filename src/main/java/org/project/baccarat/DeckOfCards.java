/*
 * File: DeckOfCards.java
 * -------------------
 * This file uses the Cards class and generates a List of Cards equivalent
 * to 7 deck of cards.
 *
 * Author: Abdul Wajid Arikattayil
 * Date: March 11, 2024
 */

package org.project.baccarat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    private List<Card> sevenDeckOfCards;

    public List<Card> getSevenDeckOfCardsDeck() {
        return sevenDeckOfCards;
    }

    public DeckOfCards() {
        sevenDeckOfCards = new ArrayList<>();
        initializeDeck();
        shuffleDeck();
    }

    /*
     * Method: initializeDeck
     * ---------------------
     * This method will create the seven deck of cards based on the suits and
     *  ranks.
     *
     * Parameters:
     *  none
     *
     * Returns:
     *   none
     */

    private void initializeDeck() {
        for (int i = 0; i < 7; i++) {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    sevenDeckOfCards.add(new Card(rank, suit));
                }
            }
        }
    }

    /*
     * Method: shuffleDeck
     * ---------------------
     * This method shuffles the arrayList(sevenDeckOfCards)
     *
     * Parameters:
     *   none
     *
     * Returns:
     *   none
     */

    private void shuffleDeck() {
        Collections.shuffle(sevenDeckOfCards);
    }

}
