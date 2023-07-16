package utils.delivery.shipping_fee;

import entity.order.Order;

public class DefaultShippingFeeMethod extends ShippingFeeMethod{
    static final double DEFAULT_FEE_MULTIFLY = 1.2;
    @Override
    public int getFee(Order order, int distance) {
        return (int) (distance*DEFAULT_FEE_MULTIFLY);
    }
}
