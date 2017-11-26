package cityDistanceCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CityTest {

    @Test
    public void shouldCreateCity() {
        // when
        City city = new City("London", 51.507222, -0.1275);

        // then
        assertEquals("London", city.getName());
        assertEquals(51.507222, city.getLatitude());
        assertEquals(-0.1275, city.getLongitude());
    }

    @Test
    public void shouldThrowExceptionWhenLatitudeIsOutOfBounds() {
        assertThrows(IncorrectInformationException.class, () ->
        {
            City city = new City("London", 551.507222, -0.1275);
        });
    }

    @Test
    public void shouldThrowExceptionWhenLongitudeIsOutOfBounds() {
        assertThrows(IncorrectInformationException.class, () ->
        {
            City city = new City("London", 51.507222, 200.1275);
        });
    }
}