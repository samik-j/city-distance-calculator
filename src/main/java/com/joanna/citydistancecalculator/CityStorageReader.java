package com.joanna.citydistancecalculator;

import java.util.Map;

public interface CityStorageReader {

    Map<String, City> read() throws Exception;

}
