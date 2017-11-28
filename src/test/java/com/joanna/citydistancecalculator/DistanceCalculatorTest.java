package com.joanna.citydistancecalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistanceCalculatorTest {

    @Test
    public void shouldCalculateDistance() {
        // given
        City city1 = new City("London", 51.507222, -0.1275);
        City city2 = new City("Warsaw", 52.233333, 21.016667);

        // when
        double result = DistanceCalculator.calculateDistance(city1, city2);

        // then
        assertEquals(1453, result, 5);
    }

    @Test
    public void shouldCalculateDistanceAt0ForSameCities() {
        // given
        City city1 = new City("London", 51.507222, -0.1275);
        City city2 = new City("London", 51.507222, -0.1275);

        // when
        double result = DistanceCalculator.calculateDistance(city1, city2);

        // then
        assertEquals(0.0, result);
    }

}