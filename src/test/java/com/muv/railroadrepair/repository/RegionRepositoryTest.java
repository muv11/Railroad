package com.muv.railroadrepair.repository;

import com.muv.railroadrepair.RailroadRepairApplication;
import com.muv.railroadrepair.entity.Region;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = RailroadRepairApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RegionRepositoryTest extends TestContainerBase {

    @Autowired
    private RegionRepository regionRepository;

    @Test
    void regionList_whenGetSize_thenAmountOfRegionsInDB() {
        int amountOfRegions = regionRepository.findAll().size();
        Assertions.assertEquals(89, amountOfRegions);
    }

    /*
    * Numeration in the DB starts from 1
    * And in the list starts from 0
    * Therefore regionNumber is x - 1
    * */
    @Test
    void regionList_whenGetByRegionNumber_thenRegionWithSameID() {
        String name = "Мурманская область";
        int regionNumber = 46 - 1;
        Region region = regionRepository.findAll().get(regionNumber);
        Assertions.assertEquals(name, region.getName());
    }

    @Test
    void regionList_whenGetByWrongRegionNumber_thenRegionsAreDifferent() {
        String name = "Мурманская область";
        Region region = regionRepository.findAll().get(35);
        Assertions.assertNotEquals(name, region.getName());
    }

}