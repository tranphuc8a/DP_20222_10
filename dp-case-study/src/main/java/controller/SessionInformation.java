package controller;

import entity.cart.Cart;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * @author
 */
public class SessionInformation {
    // Common coupling: mainUser, cartInstance, expiredTime
    // => Change public to private, create setter and getter for each variable
    public static User mainUser;
    public static Cart cartInstance = new Cart();
    public static LocalDateTime expiredTime;
}

