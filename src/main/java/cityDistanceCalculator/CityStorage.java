package cityDistanceCalculator;

import java.util.Map;

public class CityStorage {

    private Map<String, City> cities;

    public CityStorage(Map<String, City> cities) {
        this.cities = cities;
    }

    public double getDistanceBetween(String name1, String name2) throws CityNotFoundException {
        return DistanceCalculator.calculateDistance(getCityByName(name1), getCityByName(name2));
    }

    private City getCityByName(String name) throws CityNotFoundException {
        if (cities.containsKey(name)) {
            return cities.get(name);
        } else {
            throw new CityNotFoundException("City not found");
        }
    }
}
