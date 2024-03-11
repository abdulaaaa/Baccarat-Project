/*
 * File: LogIn.java
 * ------------------
 * This file contains the username and password values for a user. It also handles user verification and initiates
 * a user session upon successful authentication.
 *
 * Author: Ahmet Arslan
 * Date: March 11, 2024
 */

package org.project.baccarat;

public class LogIn {
    private String username;
    private String password;
//    private boolean isAuthorized;

    public LogIn(String username, String password, boolean isAuthorized) {
        this.username = username;
        this.password = password;
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

    /*
     * Method: userAuthroize
     * --------------------
     * Compares the inputs with the database to see if there is a match
     * and will return error messages accordingly if not.
     *
     * Parameters:
     * - username: a string
     * - password: a string
     *
     * Returns:
     * Nothing. Will provide print statements when the method is called.
     */

    void userAuthorize(String username, String password) {
        /*
        * This method will cross-reference the username and password inputs
        * with the database. If the username doesn't match,
        * then print out an error message stating the username is invalid
        * same for password.
        */
    }


}
