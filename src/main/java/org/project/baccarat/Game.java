package org.project.baccarat;

import java.util.List;

public class Game {
    private int playerCards;
    private int bankerCards;
    private float ratioForBankerPlayerTie;
    private int placedBetAmount;

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


    public int cardsChosen() {
        int cardValue = 0;
        for (int i = 0; i < 2; i++) {
            if ((sevenDeckOfCards.get(0).getRank().getValue() >= 2) &&
                    (sevenDeckOfCards.get(0).getRank().getValue() <= 9)) {
                cardValue += sevenDeckOfCards.get(0).getRank().getValue();
                usedDeckOfCards.add(sevenDeckOfCards.get(0));
                sevenDeckOfCards.remove(0);
            } else if (sevenDeckOfCards.get(0).getRank().getValue() == 1) {
                cardValue++;
                usedDeckOfCards.add(sevenDeckOfCards.get(0));
                sevenDeckOfCards.remove(0);
            } else {
                usedDeckOfCards.add(sevenDeckOfCards.get(0));
                sevenDeckOfCards.remove(0);
            }
        }

        return cardValue % 10;
    }

    public void initializePlayerAndBanker() {
        playerCards = cardsChosen();
        bankerCards = cardsChosen();
    }



    ;

}
