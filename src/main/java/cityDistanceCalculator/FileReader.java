package cityDistanceCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    private final String filePath;

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    public List<City> readFile() throws IOException {
        List<City> cities = new ArrayList<>();
        String currentLine = "";

        BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath));

        while ((currentLine = reader.readLine()) != null) {
            String[] cityInfo = currentLine.split(";");
            try {
                cities.add(new City(cityInfo[0], Double.parseDouble(cityInfo[1]), Double.parseDouble(cityInfo[2])));
            } catch (IncorrectInformationException e) {
                throw new IncorrectInformationException(cityInfo[0] + ": " + e.getMessage());
            } catch (RuntimeException e) {
                throw new RuntimeException("Wrong file format");
            }
        }

        reader.close();

        return cities;
    }
}
