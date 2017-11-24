package cityDistanceCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public List<City> readFile(String filePath) throws IOException {
        List<City> cities = new ArrayList<>();
        String currentLine = "";

        BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath));

        while((currentLine = reader.readLine()) != null) {
            String[] cityInfo = currentLine.split(";");
            cities.add(new City(cityInfo[0], Double.parseDouble(cityInfo[1]), Double.parseDouble(cityInfo[2])));
        }

        reader.close();

        return cities;
    }
}
