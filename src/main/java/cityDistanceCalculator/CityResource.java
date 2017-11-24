package cityDistanceCalculator;

import java.io.IOException;
import java.util.List;

public class CityResource {

    private List<City> cityList;
    private FileReader reader;

    public CityResource(FileReader reader) throws IOException {
        this.reader = reader;
        this.cityList = this.reader.readFile();
    }

    public double getDistanceBetween(String name1, String name2) throws CityNotFoundException {
        return DistanceCalculator.calculateDistance(getCityByName(name1), getCityByName(name2));
    }

    private City getCityByName(String name) throws CityNotFoundException {
        for(City city : cityList) {
            if(name.equals(city.getName())) {
                return city;
            }
        }
        throw new CityNotFoundException("City not found");
    }
}
