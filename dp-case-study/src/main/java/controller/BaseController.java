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
    /**
     * The method checks whether the Media in Cart, if it were in, we will return the CartMedia else return null
     * @param media
     * @return CartMedia or null
     */
    public CartItem checkMediaInCart(Media media){
<<<<<<< HEAD
        // Common coupling: cartInstance
        return SessionInformation.cartInstance.checkMediaInCart(media);
=======
        return SessionInformation.cartInstance.checkMediaInCart(media); //biến cartInstance vi phạm common coupling
>>>>>>> c402dd343b6ccc208c17ddb2a8e63903b3db22a1
    }

    /**
     * This method gets the list of items in cart
     * @return List[CartMedia]
     */
    public List getListCartMedia(){
        // Common coupling: cartInstance
        return SessionInformation.cartInstance.getListMedia();
    }
}
