/*
 * File: Game.java
 * -------------------
 * This file contains the Main Algorithm needed to conduct the Baccarat
 * Game.
 *
 * Author: Abdul Wajid Arikattayil, Ahmet Arslan
 * Date: March 12, 2024
 */
package org.project.baccarat;

import java.util.List;

public class Game {
    private int playerCards;                // total value for player
    private int bankerCards;                // total value for banker
    private float ratioForBankerPlayerTie;  // the chosen ratio
    private int placedBetAmount;
    private float amountOfMoney; // change this later

    public int getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(int playerCards) {
        this.playerCards = playerCards;
    }

    public int getBankerCards() {
        return bankerCards;
    }

    public void setBankerCards(int bankerCards) {
        this.bankerCards = bankerCards;
    }

    public float getRatioForBankerPlayerTie() {
        return ratioForBankerPlayerTie;
    }

    /*
     * Method: setRatioForBankerPlayerTie (setter method)
     * --------------------
     * Sets the ratioForBankerPlayerTie based on the users int choice (1,2,3).
     *
     * Parameters:
     * - chosenOption: integers (expected 1,2,3).
     *
     * Returns:
     * - Nothing, but will update the ratioForBankerPlayerTie.
     */

    public void setRatioForBankerPlayerTie(int chosenOption) {
        switch (chosenOption) {
            case 1 -> ratioForBankerPlayerTie = 1;
            case 2 -> ratioForBankerPlayerTie = 8;
            case 3 -> ratioForBankerPlayerTie = (float) 0.95;
            default ->
                    throw new IllegalArgumentException("Please choose a valid " +
                            "option.");
        }
    }

    public int getPlacedBetAmount() {
        return placedBetAmount;
    }

    public void setPlacedBetAmount(int placedBetAmount) {
        this.placedBetAmount = placedBetAmount;
    }

    public float getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(float amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public Game(int playerCards, int bankerCards, float ratioForBankerPlayerTie,
                int placedBetAmount) {
        this.playerCards = playerCards;
        this.bankerCards = bankerCards;
        this.ratioForBankerPlayerTie = ratioForBankerPlayerTie;
        this.placedBetAmount = placedBetAmount;
    }

    // Initializes the deck of cards and the used cards deck.

    DeckOfCards deck = new DeckOfCards();
    List<Card> sevenDeckOfCards = deck.getSevenDeckOfCards();
    List<Card> usedDeckOfCards = deck.getUsedCards();

    // Keeps track of the players third hit card.

    Card playerHitCard;

    public int HitThirdCard(int bankerOrPlayerCards) {
        bankerOrPlayerCards += sevenDeckOfCards.get(0).getRank().getValue();
        transferCards();

        // remove the 1st digit for playerCards.
        return bankerOrPlayerCards % 10;
    }

    /*
     * Method: transferCards
     * --------------------
     * This is a helper method that will take the first card in
     * sevenDeckOfCards and remove it while simultaneously add it into the
     * usedDeckOfCards.
     *
     * Parameters:
     * - none
     *
     * Returns:
     * - Nothing, but will update the both the usedDeckOfCards and
     *   sevenDeckOfCards.
     */

    public void transferCards() {
        usedDeckOfCards.add(sevenDeckOfCards.get(0));
        sevenDeckOfCards.remove(0);
    }

    /*
     * Method: cardsChosen
     * --------------------
     * This method will be used to retrieve two card from the beginning of
     * the sevenDeckOfCards
     *
     * Parameters:
     * - none
     *
     * Returns:
     * - The cardValue of based on both cards.
     */

    public int cardsChosen() {

        // cardValue keeps track of the total value of both cards.

        int cardValue = 0;

        // Loop twice to retrieve two cards.

        for (int i = 0; i < 2; i++) {

            // If the card is 1-9 (1 is Ace) (2-9 us number value

            if ((sevenDeckOfCards.get(0).getRank().getValue() >= 1) &&
                    (sevenDeckOfCards.get(0).getRank().getValue() <= 9)) {

                // increment cardValue based on the rank

                cardValue += sevenDeckOfCards.get(0).getRank().getValue();
                transferCards();
            } else {

                /* No need to increment cardValue is it is either 10, King,
                   Queen, or Jack. */

                transferCards();
            }
        }

        // Remove the 1st digit of the card and return it.

        return cardValue % 10;
    }

    /*
     * Method: initializePlayerAndBanker
     * --------------------
     * This will set the value of the two initial cards to both player and
     * banker.
     *
     * Parameters:
     * - none
     *
     * Returns:
     * - Nothing but changes the value of playerCards and bankerCards.
     */

    public void initializePlayerAndBanker() {
        playerCards = cardsChosen();
        bankerCards = cardsChosen();
    }

    /*
     * Method: determineTheWinner
     * --------------------
     * This compare the value between playerCards and bankerCards and checks
     * if the won/loss and would increment/decrement their amountOfMoney
     * based on the rules.
     *
     * Parameters:
     * - none
     *
     * Returns:
     * - Nothing but changes the value of playerCards and bankerCards.
     */

    public void determineTheWinner() {

        // Player won and Player chosen.

        if ((playerCards > bankerCards) && (ratioForBankerPlayerTie == 1)) {
            amountOfMoney += placedBetAmount + placedBetAmount *
                    ratioForBankerPlayerTie;
            System.out.println("Congratulations you won: " +
                    (placedBetAmount * ratioForBankerPlayerTie));

            // Banker won and Banker chosen.

        } else if ((bankerCards > playerCards) &&
                (ratioForBankerPlayerTie == 0.95)) {
            amountOfMoney += placedBetAmount + placedBetAmount *
                    ratioForBankerPlayerTie;
            System.out.println("Congratulations you won: " +
                    (placedBetAmount * ratioForBankerPlayerTie));

            // Tie and Tie chosen

        } else if ((bankerCards == playerCards) &&
                ratioForBankerPlayerTie == 8) {
            amountOfMoney += placedBetAmount + placedBetAmount *
                    ratioForBankerPlayerTie;
            System.out.println("Congratulations you won: " +
                    (placedBetAmount * ratioForBankerPlayerTie));

            // User chose wrong

        } else {
            amountOfMoney -= placedBetAmount;
            System.out.println("You Lost");
        }
    }

    public void updateAmountOfMoney() {

        // Natural win Scenario

        if ((playerCards == 8) || (playerCards == 9) || (bankerCards == 8) ||
                (bankerCards == 9)) {
            determineTheWinner();
            return;
        }

        // playerCard is 0-5 then player hits.

        if ((playerCards >= 0) && (playerCards <= 5)) {

            // track the player hit third card.

            playerHitCard = sevenDeckOfCards.get(0);
            playerCards = HitThirdCard(playerCards);

            if ((bankerCards >= 0) && (bankerCards <= 2)) {
                bankerCards = HitThirdCard(bankerCards);
                determineTheWinner();
                return;
            } else if ((bankerCards >= 3) && (bankerCards <= 7)) {
                switch (bankerCards) {
                    case 3:
                        if (playerHitCard.getRank().getValue() != 8) {
                            bankerCards = HitThirdCard(bankerCards);
                            determineTheWinner();
                            return;
                        }
                        break;
                    case 4:
                        if ((playerHitCard.getRank().getValue() != 1) &&
                                (playerHitCard.getRank().getValue() != 8) &&
                                (playerHitCard.getRank().getValue() != 9) &&
                                (playerHitCard.getRank().getValue() != 0)) {
                            bankerCards = HitThirdCard(bankerCards);
                            determineTheWinner();
                            return;
                        }
                        break;
                    case 5:
                        if ((playerHitCard.getRank().getValue() != 1) &&
                                (playerHitCard.getRank().getValue() != 2) &&
                                (playerHitCard.getRank().getValue() != 3) &&
                                (playerHitCard.getRank().getValue() != 8) &&
                                (playerHitCard.getRank().getValue() != 9) &&
                                (playerHitCard.getRank().getValue() != 0)) {
                            bankerCards = HitThirdCard(bankerCards);
                            determineTheWinner();
                            return;
                        }
                        break;
                    case 6:
                        if ((playerHitCard.getRank().getValue() == 6) ||
                                (playerHitCard.getRank().getValue() == 7)) {
                            bankerCards = HitThirdCard(bankerCards);
                            determineTheWinner();
                            return;
                        }
                        break;
                    case 7:
                        determineTheWinner();
                        return;
                    default:
                        throw new IllegalArgumentException("Erro with the " +
                                "third card chosen");

                }
            }
        } else {
            if ((bankerCards >= 0) && (bankerCards <= 5)) {
                bankerCards = HitThirdCard(bankerCards);
                determineTheWinner();
                return;
            } else {
                determineTheWinner();
            }
        }
    }


    ;

}
