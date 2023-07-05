package entity.shipping;

import entity.order.Order;
import org.example.DistanceCalculator;
import utils.delivery.distance.DistanceMethod;
import utils.delivery.shipping_fee.ShippingFeeMethod;

public class DeliveryInfo {
    protected String name;
    protected String phone;
    protected String province;
    protected String address;
    protected String shippingInstructions;
//    protected DistanceCalculator distanceCalculator;
    protected DistanceMethod distanceMethod;
    protected ShippingFeeMethod shippingFeeMethod;

    public DeliveryInfo(String name, String phone, String province,
                        String address, String shippingInstructions,
                        DistanceMethod distanceMethod, ShippingFeeMethod shippingFeeMethod) {
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.address = address;
        this.shippingInstructions = shippingInstructions;
//        this.distanceCalculator = distanceCalculator;
        this.distanceMethod = distanceMethod;
        this.shippingFeeMethod = shippingFeeMethod;
    }

    // SRP: vi phạm vì trách nhiệm tính toán phí vận chuyển và cách tính phí vận chuyển không phải của DeliveryInfo
    // OCP: vi phạm vì đây chỉ là 1 cách tính phí thôi, trong tương lai cách tính phí rất có thể bị thay đổi
    public int calculateShippingFee(Order order) { // biến order vi phạm stamp coupling vì không được sử dụng trong hàm
//        int distance = distanceCalculator.calculateDistance(address, province);
//        return (int) (distance * 1.2);
        return this.shippingFeeMethod.getFee(order, this.distanceMethod.getDistance(address, province));
    }

    public void setDistanceMethod(DistanceMethod distanceMethod) {
        this.distanceMethod = distanceMethod;
    }

    public void setShippingFeeMethod(ShippingFeeMethod shippingFeeMethod) {
        this.shippingFeeMethod = shippingFeeMethod;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getProvince() {
        return province;
    }

    public String getAddress() {
        return address;
    }

    public String getShippingInstructions() {
        return shippingInstructions;
    }
}
