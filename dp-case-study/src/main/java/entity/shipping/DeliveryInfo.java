package entity.shipping;

import entity.order.Order;
import org.example.DistanceCalculator;

public class DeliveryInfo {
    //functional cohesion
    protected String name;
    protected String phone;
    protected String province;
    protected String address;
    protected String shippingInstructions;
    protected DistanceCalculator distanceCalculator; //coincidental cohesion: không nên là thành phần của lớp này -> nên tạo mới khi dùng đến nó

    public DeliveryInfo(String name, String phone, String province, String address, String shippingInstructions, DistanceCalculator distanceCalculator) {
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.address = address;
        this.shippingInstructions = shippingInstructions;
        this.distanceCalculator = distanceCalculator;
    }

    public int calculateShippingFee(Order order) { // biến order vi phạm stamp coupling vì không được sử dụng trong hàm
        int distance = distanceCalculator.calculateDistance(address, province);
        return (int) (distance * 1.2);
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
