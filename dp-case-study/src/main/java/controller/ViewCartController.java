package controller;

import java.sql.SQLException;

import entity.cart.Cart;

/**
 * This class controls the flow of events when users view the Cart
 * @author nguyenlm
 */
// Communicational cohesion: Due to the shared usage of data in SessionInformation.cartInstance
public class ViewCartController extends BaseController{
    /**
     * This method checks the available products in Cart
     * @throws SQLException
     */
    public void checkAvailabilityOfProduct() throws SQLException{
        SessionInformation.getCartInstance().checkAvailabilityOfProduct(); //biến cartInstance vi phạm common coupling
    }

    /**
     * This method calculates the cart subtotal
     * @return subtotal
     */
    public int getCartSubtotal(){
        int subtotal = SessionInformation.getCartInstance().calSubtotal(); //biến cartInstance vi phạm common coupling
        return subtotal;
    }

}
