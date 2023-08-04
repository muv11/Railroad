package com.muv.railroadrepair.repository;

import com.muv.railroadrepair.RailroadRepairApplication;
import com.muv.railroadrepair.entity.DepotType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = RailroadRepairApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DepotTypeRepositoryTest {

    @Autowired
    private DepotTypeRepository depotTypeRepository;

    @Test
    void depotTypeList_whenGetSize_thenAmountOfTypesInDB() {
        int amountOfRegions = depotTypeRepository.findAll().size();
        Assertions.assertEquals(5, amountOfRegions);
    }

    /*
     * Numeration in the DB starts from 1
     * And in the list starts from 0
     * Therefore orderNumber is x - 1
     * */
    @Test
    void depotTypeList_whenGetByOrderNumber_thenTypeWithSameID() {
        String name = "Моторвагонное";
        int orderNumber = 2 - 1;
        DepotType type = depotTypeRepository.findAll().get(orderNumber);
        Assertions.assertEquals(name, type.getType());
    }

    @Test
    void depotTypeList_whenGetByWrongOrderNumber_thenTypesAreDifferent() {
        String name = "Моторвагонное";
        int orderNumber = 4 - 1;
        DepotType type = depotTypeRepository.findAll().get(orderNumber);
        Assertions.assertNotEquals(name, type.getType());
    }


}