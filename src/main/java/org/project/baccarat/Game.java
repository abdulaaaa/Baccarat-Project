package org.project.baccarat;

import java.util.List;

public class Game {
    private int playerCards;
    private int bankerCards;
    private float ratioForBankerPlayerTie;
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

    DeckOfCards deck = new DeckOfCards();
    List<Card> sevenDeckOfCards = deck.getSevenDeckOfCards();
    List<Card> usedDeckOfCards = deck.getUsedCards();
    Card playerHitCard;

    public void transferCards() {
        usedDeckOfCards.add(sevenDeckOfCards.get(0));
        sevenDeckOfCards.remove(0);
    }


    public int cardsChosen() {
        int cardValue = 0;
        for (int i = 0; i < 2; i++) {
            if ((sevenDeckOfCards.get(0).getRank().getValue() >= 2) &&
                    (sevenDeckOfCards.get(0).getRank().getValue() <= 9)) {
                cardValue += sevenDeckOfCards.get(0).getRank().getValue();
                transferCards();
            } else if (sevenDeckOfCards.get(0).getRank().getValue() == 1) {
                cardValue++;
                transferCards();
            } else {
                transferCards();
            }
        }

        return cardValue % 10;
    }

    public void initializePlayerAndBanker() {
        playerCards = cardsChosen();
        bankerCards = cardsChosen();
    }

    public void determineTheWinner() {
        if ((playerCards > bankerCards) && (ratioForBankerPlayerTie == 1)) {
            amountOfMoney += placedBetAmount + placedBetAmount *
                    ratioForBankerPlayerTie;
            System.out.println("Congratulations you won: " +
                    (placedBetAmount * ratioForBankerPlayerTie));
        } else if ((bankerCards > playerCards) &&
                (ratioForBankerPlayerTie == 0.95)) {
            amountOfMoney += placedBetAmount + placedBetAmount *
                    ratioForBankerPlayerTie;
            System.out.println("Congratulations you won: " +
                    (placedBetAmount * ratioForBankerPlayerTie));
        } else if ((bankerCards == playerCards) &&
                ratioForBankerPlayerTie == 8) {
            amountOfMoney += placedBetAmount + placedBetAmount *
                    ratioForBankerPlayerTie;
            System.out.println("Congratulations you won: " +
                    (placedBetAmount * ratioForBankerPlayerTie));
        } else {
            amountOfMoney -= placedBetAmount;
            System.out.println("You Lost");
        }
    }

    public void updateAmountOfMoney() {
        if ((playerCards == 8) || (playerCards == 9) || (bankerCards == 8) ||
                (bankerCards == 9)) {
            determineTheWinner();
            return;
        }
        if ((playerCards >= 0) && (playerCards <= 5)) {
            if (sevenDeckOfCards.get(0).getRank().getValue() < 10) {
                // this is hit logic
                playerHitCard = sevenDeckOfCards.get(0);
                playerCards += sevenDeckOfCards.get(0).getRank().getValue();
                transferCards();
                playerCards %= 10;
            }

            if ((bankerCards >= 0) && (bankerCards <= 2)) {
                if (sevenDeckOfCards.get(0).getRank().getValue() < 10) {
                    // this is hit logic
                    bankerCards += sevenDeckOfCards.get(0).getRank().getValue();
                    transferCards();
                    bankerCards %= 10;
                    determineTheWinner();
                    return;
                }
            } else if ((bankerCards >= 3) && (bankerCards <= 6)) {
                switch (bankerCards) {
                    case 3:
                        if ((playerHitCard.getRank().getValue() >= 1) &&
                                (playerHitCard.getRank().getValue() <= 10) &&
                                (playerHitCard.getRank().getValue() != 8)) {

                        }

                }
            }
        }
    }


    ;

}
