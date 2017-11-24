package cityDistanceCalculator;

import static java.lang.Math.*;

public class DistanceCalculator {

    private static final double R = 6378;

    public static double calculateDistance(City city1, City city2) {
        double lon1 = degToRad(city1.getLongitude());
        double lat1 = degToRad(city1.getLatitude());
        double lon2 = degToRad(city2.getLongitude());
        double lat2 = degToRad(city2.getLatitude());

        double distance = 2 * R * asin(sqrt(
                pow(sin((lat2 - lat1) / 2), 2) +
                        cos(lat1) * cos(lat2) *
                                pow(sin((lon2 - lon1) / 2), 2)));

        return round(distance * 100.00) / 100.00;
    }

    private static double degToRad(double degree) {
        return degree * (PI / 180);
    }
}
