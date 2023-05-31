package controller;

import entity.cart.Cart;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * @author
 */
public class SessionInformation {
    private static User mainUser; //biến mainUser vi phạm common coupling
    private static Cart cartInstance = Cart.getInstance(); //biến cartInstance vi phạm common coupling
    private static LocalDateTime expiredTime;//biến expiredTime vi phạm common coupling

    public static User getMainUser() {
        return mainUser;
    }

    public static void setMainUser(User mainUser) {
        SessionInformation.mainUser = mainUser;
    }

    public static Cart getCartInstance() {
        return cartInstance;
    }

    public static void setCartInstance(Cart cartInstance) {
        SessionInformation.cartInstance = cartInstance;
    }

    public static LocalDateTime getExpiredTime() {
        return expiredTime;
    }

    public static void setExpiredTime(LocalDateTime expiredTime) {
        SessionInformation.expiredTime = expiredTime;
    }

    /*
    Solution: (từ ý tưởng singleton design pattern)
        1: chuyển chỉ định truy cập public -> private cho 3 biến trên
        2: thêm 3 hàm getter & setter cho 3 biến
    */
}
