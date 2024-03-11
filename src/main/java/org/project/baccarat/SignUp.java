/*
 * File: SignUp.java
 * -------------------
 * This file contains the SignUp class, which represents the basic layout
 * necessary to create a signup feature for the program. Some functionality
 * is stubbed out and needs to be implemented.
 *
 * Author: Abdul Wajid Arikattayil
 * Date: March 11, 2024
 */

package org.project.baccarat;

public class SignUp {
    private String username;
    private String password;
    private int amountOfMoney;
    private boolean userInfoSaved;
    private static final int MIN_USERNAME_LENGTH = 6;
    private static final int MAX_USERNAME_LENGTH = 15;

    public SignUp(String username, String password, int amountOfMoney,
                  boolean userInfoSaved) {
        this.username = username;
        this.password = password;
        this.amountOfMoney = amountOfMoney;
        this.userInfoSaved = userInfoSaved;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(int amountOfMoney) {

        // amountOfMoney can't less than 1000 nor greater than 100000.

        if (amountOfMoney >= 1000 && amountOfMoney <= 100000) {
            this.amountOfMoney = amountOfMoney;
        } else {
            throw new IllegalArgumentException(
                    "Amount of money must be between " + 1000 + " and " +
                            100000 + " inclusive.");
        }
    }

    public boolean isUserInfoSaved() {
        return userInfoSaved;
    }

    public void setUserInfoSaved(boolean userInfoSaved) {
        this.userInfoSaved = userInfoSaved;
    }

    /*
     * Method: checkUserInputLength
     * ---------------------
     * This method checks if the username and password meet the right length
     * requirements or else it throws an
     * IllegalArgumentException.
     *
     * Parameters:
     *   - username: String username the player types in.
     *   - password: String password the player types in.
     *
     * Returns:
     *   Boolean value if whether the username and password meets the right
     *   requirements.
     */

    public boolean checkUserInputLength(String username, String password) {
        if (username.length() < 6 || username.length() > 15) {
            throw new IllegalArgumentException("Username must be between " + 6
                    + " and " + 15 + " characters inclusive.");
        }
        if (password.length() < 8 || password.length() > 30) {
            throw new IllegalArgumentException("Password must be between " + 8
                    + " and " + 30 + " characters inclusive.");
        }
        return true;
    }

    /*
     * Method: userInfoAdded
     * ---------------------
     * This method checks if userInfo has been added to the database. This
     * method is still being worked on and isn't.
     * finished.
     *
     * Parameters:
     *   - username: String username the player types in.
     *   - password: String password the player types in.
     *   - amountOfMoney: integer value of the amount of money the user
     *     wishes to have
     *
     * Returns:
     *   Boolean value on whether the userInfo has been added or not.
     */

    public boolean userInfoAdded(String username, String password,
                                 int amountOfMoney) {
        // Save user info to the database.
        // Set the winning ratio to 0% (float) in the database
        return false;
    }
}