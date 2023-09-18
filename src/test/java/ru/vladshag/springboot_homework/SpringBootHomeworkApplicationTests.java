package ru.vladshag.springboot_homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootHomeworkApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;
    private static final GenericContainer<?> devApp = new GenericContainer<>("devapp:latest").withExposedPorts(8080);
    private static final GenericContainer<?> prodApp = new GenericContainer<>("prodapp:latest").withExposedPorts(8081);
    @BeforeAll
    public static void setUp() {
        devApp.start();
        prodApp.start();
    }

    @Test
    void contextLoads() {
        ResponseEntity<String> devEntity = restTemplate.getForEntity("http://localhost:" + devApp.getMappedPort(8080) + "/profile", String.class);
        ResponseEntity<String> prodEntity = restTemplate.getForEntity("http://localhost:" + prodApp.getMappedPort(8081)+ "/profile", String.class);
        Assertions.assertEquals(devEntity.getBody(), "Current profile is dev");
        Assertions.assertEquals(prodEntity.getBody(), "Current profile is production");

    }

}