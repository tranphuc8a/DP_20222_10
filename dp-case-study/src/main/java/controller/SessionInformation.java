package controller;

import entity.cart.Cart;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * @author
 */
public class SessionInformation {
<<<<<<< HEAD
    // Common coupling: mainUser, cartInstance, expiredTime
    // => Change public to private, create setter and getter for each variable
    public static User mainUser;
    public static Cart cartInstance = new Cart();
    public static LocalDateTime expiredTime;
=======
    public static User mainUser; //biến mainUser vi phạm common coupling
    public static Cart cartInstance = new Cart(); //biến cartInstance vi phạm common coupling
    public static LocalDateTime expiredTime;//biến expiredTime vi phạm common coupling

    /*
    Giải pháp: (từ ý tưởng singleton design pattern)
        1: chuyển chỉ định truy cập public -> private cho 3 biến trên
        2: thêm 3 hàm getter cho 3 biến, trong hàm getter kiểm tra nếu biến = null thì khởi tạo giá trị và return biến
        3: thêm 3 hàm setter cho 3 biến
    */
>>>>>>> c402dd343b6ccc208c17ddb2a8e63903b3db22a1
}

