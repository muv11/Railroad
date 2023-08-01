package com.muv.railroadrepair.repository;

import com.muv.railroadrepair.entity.Region;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegionRepository {

    private final EntityManager entityManager;

    public RegionRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Region> findAll() {
        return entityManager.createQuery("SELECT region FROM Region region", Region.class).getResultList();
    }
}
