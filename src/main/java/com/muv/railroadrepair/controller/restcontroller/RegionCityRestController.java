package com.muv.railroadrepair.controller.restcontroller;

import com.muv.railroadrepair.entity.City;
import com.muv.railroadrepair.entity.Region;
import com.muv.railroadrepair.repository.CityRepository;
import com.muv.railroadrepair.repository.RegionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RegionCityRestController {

    private final RegionRepository regionRepository;
    private final CityRepository cityRepository;

    public RegionCityRestController(RegionRepository regionRepository, CityRepository cityRepository) {
        this.regionRepository = regionRepository;
        this.cityRepository = cityRepository;
    }

    @GetMapping("/regions")
    public List<Region> getRegions() {
        return regionRepository.findAll();
    }

    @GetMapping("/cities/{region}")
    public List<City> getCitiesByRegion(@PathVariable String region) {
        return cityRepository.findAllByRegionName(region);
    }

}
