package utils.delivery.distance;

import org.example.AlternativeDistanceCalculator;

// adapter
public class AltDistanceMethod implements DistanceMethod {
    private AlternativeDistanceCalculator altDistanceCalculator;

    public AltDistanceMethod() {
        this.altDistanceCalculator = new AlternativeDistanceCalculator();
    }

    @Override
    public int getDistance(String address, String province) {
        String fullAddress = address + "/" + province;
        return altDistanceCalculator.calculateDistance(fullAddress);
    }
}
