package com.muv.railroadrepair.repository;

import com.muv.railroadrepair.RailroadRepairApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = RailroadRepairApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CityRepositoryTest {

    @Autowired
    private CityRepository cityRepository;

    @Test
    void cityList_whenGetSize_thenAmountOfCitiesInDB() {
        int amountOfCities = cityRepository.findAll().size();
        Assertions.assertEquals(1230, amountOfCities);
    }

    @Test
    void cityList_whenGetSizeByRegion_thenAmountOfCitiesInDB() {
        String region = "Свердловская область";
        int amountOfCities = cityRepository.findAllByRegionName(region).size();
        Assertions.assertEquals(47, amountOfCities);
    }

}