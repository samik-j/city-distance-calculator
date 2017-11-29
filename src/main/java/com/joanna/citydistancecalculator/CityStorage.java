package com.joanna.citydistancecalculator;

import java.util.Map;

public class CityStorage {

    private Map<String, City> cities;

    public CityStorage(Map<String, City> cities) {
        this.cities = cities;
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
