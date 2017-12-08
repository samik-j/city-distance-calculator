package com.joanna.citydistancecalculator;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CityStorage {

    private Map<String, City> cities;

    public CityStorage() {
        this.cities = new HashMap<>();
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

    public void addCities(Map<String, City> cities) {
        this.cities.putAll(cities);
    }
}
