package com.joanna.citydistancecalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileReader implements CityStorageReader{

    private final String filePath;

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    public Map<String, City> read() throws IOException {
        Map<String, City> cities = new HashMap<>();
        String currentLine = "";
        int line = 0;

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {

            while ((currentLine = reader.readLine()) != null) {
                String[] cityInfo = currentLine.split(";");
                line++;
                try {
                    cities.put(cityInfo[0], new City(cityInfo[0], Double.parseDouble(cityInfo[1]), Double.parseDouble(cityInfo[2])));
                } catch (IncorrectInformationException e) {
                    throw new IncorrectInformationException("Line " + line + ": " + e.getMessage());
                } catch (RuntimeException e) {
                    throw new RuntimeException("Line " + line + ": Wrong information format");
                }
            }
        }

        return cities;
    }
}
