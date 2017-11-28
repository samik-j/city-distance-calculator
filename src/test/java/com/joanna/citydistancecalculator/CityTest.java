package com.joanna.citydistancecalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CityTest {

    @Test
    public void shouldCreateCity() {
        // given
        double latitude = 51.507222;
        double longitude = -0.1275;

        // when
        City city = new City("London", latitude, longitude);

        // then
        assertEquals("London", city.getName());
        assertEquals(latitude, city.getLatitude());
        assertEquals(longitude, city.getLongitude());
    }

    @Test
    public void shouldThrowExceptionWhenNameIsEmpty() {
        assertThrows(IncorrectInformationException.class, () ->
        {
            new City("", 551.507222, -0.1275);
        });
    }

    @Test
    public void shouldThrowExceptionWhenNameIsNull() {
        assertThrows(IncorrectInformationException.class, () ->
        {
            new City(null, 551.507222, -0.1275);
        });
    }

    @Test
    public void shouldThrowExceptionWhenLatitudeIsOutOfBounds() {
        assertThrows(IncorrectInformationException.class, () ->
        {
            new City("London", 551.507222, -0.1275);
        });
    }

    @Test
    public void shouldThrowExceptionWhenLongitudeIsOutOfBounds() {
        assertThrows(IncorrectInformationException.class, () ->
        {
            new City("London", 51.507222, 200.1275);
        });
    }
}