package com.joanna.citydistancecalculator;

import java.util.Map;

public class CityStorage {

    private CityStorageReader reader;
    private Map<String, City> cities;

    public CityStorage(CityStorageReader reader) throws Exception {
        this.reader = reader;
        this.cities = reader.read();
    }

    public double calculateDistanceBetween(String name1, String name2) throws CityNotFoundException {
        return DistanceCalculator.calculateDistance(getCity(name1), getCity(name2));
    }

    private City getCity(String name) throws CityNotFoundException {
        if (cities.containsKey(name)) {
            return cities.get(name);
        } else {
            throw new CityNotFoundException("City not found");
        }
    }
}
