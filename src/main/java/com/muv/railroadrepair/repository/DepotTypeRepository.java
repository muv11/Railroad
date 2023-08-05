package com.muv.railroadrepair.repository;

import com.muv.railroadrepair.entity.DepotType;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepotTypeRepository {

    private final EntityManager entityManager;

    public DepotTypeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<DepotType> findAll() {
        return entityManager.createQuery("SELECT type FROM DepotType type", DepotType.class).getResultList();
    }

}
