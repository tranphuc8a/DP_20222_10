package utils.delivery.shipping_fee;

import entity.order.Order;

// Strategy
public abstract class ShippingFeeMethod {
    public abstract int getFee(Order order, int distance);
}
