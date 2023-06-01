package controller;

import java.util.List;

import entity.cart.Cart;
import entity.cart.CartItem;
import entity.media.Media;

/**
 * This class is the base controller for our AIMS project
 * @author nguyenlm
 */
// Communicational cohesion: The methods that work with the shared data SessionInformation.cartInstance
public class BaseController {
    /* SRP:
        Đang có 2 trách nhiệm ở đây:
          - Trách nhiệm quản lý cart
          - Trách nhiệm chính của lớp này là định nghĩa 1 khuôn dạng chung nhất cho các controller cụ thể
     */
    /**
     * The method checks whether the Media in Cart, if it were in, we will return the CartMedia else return null
     * @param media
     * @return CartMedia or null
     */
    public CartItem checkMediaInCart(Media media){
        return SessionInformation.getCartInstance().checkMediaInCart(media); //biến cartInstance vi phạm common coupling
    }

    /**
     * This method gets the list of items in cart
     * @return List[CartMedia]
     */
    public List getListCartMedia(){
        return SessionInformation.getCartInstance().getListMedia();
    }
}
