package com.muv.railroadrepair.repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

public class TestContainerBase {

    static final PostgreSQLContainer<?> POSTGRE_SQL_CONTAINER;

    static {
        POSTGRE_SQL_CONTAINER = new PostgreSQLContainer<>("postgres:15")
                .withDatabaseName("test_db")
                .withUsername("test")
                .withPassword("1234")
                .withInitScript("sql/region.sql")
                .withInitScript("sql/city.sql")
                .withInitScript("sql/depot_type.sql");
    }

    @DynamicPropertySource
    static void databaseProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", POSTGRE_SQL_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", POSTGRE_SQL_CONTAINER::getUsername);
        registry.add("spring.datasource.password", POSTGRE_SQL_CONTAINER::getPassword);
    }

    @BeforeAll
    static void beforeAll() {
        POSTGRE_SQL_CONTAINER.start();
    }

    @AfterAll
    static void afterAll() {
        POSTGRE_SQL_CONTAINER.stop();
    }

}
