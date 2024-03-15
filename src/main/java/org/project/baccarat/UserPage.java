/*
 * File: UserPage.java
 * ------------------
 * This file contains the fields that will be displayed on a user's home
 * page. This file also contains a method addMoney which allows the user to
 * add money into their account given certain conditions.
 *
 * Author: Ahmet Arslan
 * Date: March 11, 2024
 */
package org.project.baccarat;

public class UserPage {
    private String username;
    private int amountOfMoney;
    private boolean userAddedMoney;
    private float winningRatio;
    private int totalGames;
    private int totalWins;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public boolean isUserAddedMoney() {
        return userAddedMoney;
    }

    public void setUserAddedMoney(boolean userAddedMoney) {
        this.userAddedMoney = userAddedMoney;
    }

    public float getWinningRatio() {
        return winningRatio;
    }

    public void setWinningRatio() {
        if (totalGames == 0) {
            winningRatio = 0;
        } else {
            winningRatio =
                    Math.round((float) totalWins /totalGames * 100) / 100f;
        }
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public UserPage(String username, int amountOfMoney, boolean userAddedMoney,
                    float winningRatio, int totalGames, int totalWins) {
        this.username = username;
        this.amountOfMoney = amountOfMoney;
        this.userAddedMoney = userAddedMoney;
        this.winningRatio = winningRatio;
        this.totalGames = totalGames;
        this.totalWins = totalWins;
    }

    /*
     * Method: addMoney
     * --------------------
     * Checks if the input value, money is at least $1000 and at most $50000.
     * If it is the value amountOfMoney will be updated and the database will
     * also be updated.
     *
     * Parameters:
     * - money: an integer value
     *
     * Returns:
     * a boolean. This will allow us to print out a success message in main
     * by checking if the method returned true.
     */
    public boolean addMoney(int money) {
        if (money >= 1000 && money <= 50000) {
            amountOfMoney += money;
            System.out.println("Money has been successfully added!");
            return true;
            // need to update the amountOfMoney value in the database when this
            // method is called
        } else {
            throw new IllegalArgumentException("Please ensure you add at " +
                                               "least $1000 and at most " +
                                               "$50000 to proceed.");
        }
    }


    public void deleteAccount() {
        System.out.println("Account Deleted.");
    }


}
