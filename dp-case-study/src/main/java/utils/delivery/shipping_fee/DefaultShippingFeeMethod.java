package utils.delivery.shipping_fee;

import entity.order.Order;

public class DefaultShippingFeeMethod extends ShippingFeeMethod{
    @Override
    public int getFee(Order order, int distance) {
        return (int) (distance*1.2);
    }
}
