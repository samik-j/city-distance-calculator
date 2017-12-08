package com.joanna.citydistancecalculator;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CityStorageTest {

    private CityStorage cityStorage = createCityStorage();

    CityStorageTest() throws Exception {
    }

    private CityStorage createCityStorage() throws Exception {
        Map<String, City> cities = new HashMap<>();

        cities.put("London", new City("London", 51.507222, -0.1275));
        cities.put("Warsaw", new City("Warsaw", 52.233333, 21.016667));

        CityStorageReader reader = mock(FileReader.class);
        when(reader.read()).thenReturn(cities);

        return new CityStorage(reader);
    }

    @Test
    public void shouldCalculateDistance() throws IOException, CityNotFoundException {
        // when
        double result = cityStorage.calculateDistanceBetween("London", "Warsaw");

        // then
        assertEquals(1453, result, 5);
    }

    @Test
    public void shouldThrowCityNotFoundException() throws CityNotFoundException {
        assertThrows(CityNotFoundException.class, () ->
        {
            cityStorage.calculateDistanceBetween("London", "Wroclaw");
        });
    }
}