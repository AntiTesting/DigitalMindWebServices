package com.example.digitalmindwebservices.service;

import com.example.digitalmindwebservices.entities.Developer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertNull;

@SpringBootTest
class ICompanyServiceUnitTest {
    @Autowired
    private ICompanyService companyService;
    @MockBean
    private IDigitalProfileService digitalProfileService;

    @BeforeEach
    void setUp() throws Exception {
        Mockito.when(digitalProfileService.filterDigitalProfile("1,2,3", "1,2", "1")).thenReturn(Collections.emptyList());
    }

    @Test
    void getFilteredDevelopersFailedTest() throws Exception {
        List<Developer> developerList = companyService.getFilteredDevelopers(5, "1", "1,2", "1,2,3");
        assertNull(developerList);
    }
}