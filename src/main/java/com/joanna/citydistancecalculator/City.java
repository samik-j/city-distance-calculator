package cityDistanceCalculator;

public class City {

    private String name;
    private final double latitude;
    private final double longitude;

    public City(String name, double latitude, double longitude) {
        this.name = assertName(name);
        this.latitude = assertLat(latitude);
        this.longitude = assertLon(longitude);
    }

    private String assertName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IncorrectInformationException("Empty name for city");
        } else {
            return name;
        }
    }

    private double assertLat(double latitude) {
        if (latitude <= 90.00 && latitude >= -90.00) {
            return latitude;
        } else {
            throw new IncorrectInformationException("Wrong latitude value");
        }
    }

    private double assertLon(double longitude) {
        if (longitude <= 180.00 && longitude >= -180.00) {
            return longitude;
        } else {
            throw new IncorrectInformationException("Wrong longitude value");
        }
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
