package com.muv.railroadrepair.controller.restcontroller;

import com.muv.railroadrepair.entity.DepotType;
import com.muv.railroadrepair.repository.DepotTypeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/depot_types")
public class DepotTypeRestController {

    private final DepotTypeRepository depotTypeRepository;

    public DepotTypeRestController(DepotTypeRepository depotTypeRepository) {
        this.depotTypeRepository = depotTypeRepository;
    }

    @GetMapping
    public List<DepotType> getDepotTypes() {
        return depotTypeRepository.findAll();
    }

}
