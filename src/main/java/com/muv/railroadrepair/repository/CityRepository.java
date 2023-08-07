package com.muv.railroadrepair.repository;

import com.muv.railroadrepair.entity.City;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityRepository {

    private final EntityManager entityManager;

    public CityRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<City> findAllByRegionName(String name) {
        return entityManager.createQuery("SELECT city FROM City city WHERE regionById.name = :name", City.class)
                .setParameter("name", name)
                .getResultList();
    }
}
