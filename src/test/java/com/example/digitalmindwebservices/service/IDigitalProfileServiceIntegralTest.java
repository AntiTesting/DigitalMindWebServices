package com.example.digitalmindwebservices.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IDigitalProfileServiceIntegralTest {

    @Autowired
    private IDigitalProfileService digitalProfileService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void filterDigitalProfile() throws Exception {
        List<Long> digitalProfileList = digitalProfileService.filterDigitalProfile("1,2,3", "1,2,3", "1,2,4");
        assertEquals(3, digitalProfileList.get(0));
    }
}

