package controller;

import entity.cart.Cart;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * @author
 */
public class SessionInformation {
    // Common coupling: mainUser, cartInstance, expiredTime
    // => Chuyển public thành private, thêm getter và setter cho 3 biến
    public static User mainUser;
    public static Cart cartInstance = new Cart();
    public static LocalDateTime expiredTime;
}

