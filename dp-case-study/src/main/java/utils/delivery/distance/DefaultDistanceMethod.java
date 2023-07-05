package utils.delivery.distance;

import org.example.DistanceCalculator;

// adapter
public class DefaultDistanceMethod implements DistanceMethod {
    private DistanceCalculator distanceCalculator;

    public DefaultDistanceMethod() {
        this.distanceCalculator = new DistanceCalculator();
    }

    @Override
    public int getDistance(String address, String province) {
        return distanceCalculator.calculateDistance(address, province);
    }
}
