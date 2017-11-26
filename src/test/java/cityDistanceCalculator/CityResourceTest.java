package cityDistanceCalculator;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CityResourceTest {

    @Test
    public void shouldCalculateDistance() throws IOException, CityNotFoundException {
        // given
        CityResource cityResource = createCityResource();

        // when
        double result = cityResource.getDistanceBetween("London", "Warsaw");

        // then
        assertEquals(1453, result, 5);
    }

    @Test
    public void shouldThrowCityNotFoundException() throws CityNotFoundException, IOException {
        // given
        CityResource cityResource = createCityResource();

        // then
        assertThrows(CityNotFoundException.class, () ->
        {
            cityResource.getDistanceBetween("London", "Wroclaw");
        });
    }

    private CityResource createCityResource() throws IOException {
        FileReader reader = mock(FileReader.class);

        List<City> cities = Arrays.asList(
                new City("London", 51.507222, -0.1275),
                new City("Warsaw", 52.233333, 21.016667));

        when(reader.readFile()).thenReturn(cities);

        return new CityResource(reader);
    }
}