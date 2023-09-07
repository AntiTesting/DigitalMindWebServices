package com.example.digitalmindwebservices.service;

import com.example.digitalmindwebservices.service.cross.IDatabaseDigitalProfileService;
import com.example.digitalmindwebservices.service.cross.IFrameworkDigitalProfileService;
import com.example.digitalmindwebservices.service.cross.IProgrammingLanguageDigitalProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IDigitalProfileServiceUnitTest {
    @Autowired
    IDigitalProfileService digitalProfileService;

    @MockBean
    IDatabaseDigitalProfileService databaseDigitalProfileService;

    @MockBean
    IFrameworkDigitalProfileService frameworkDigitalProfileService;

    @MockBean
    IProgrammingLanguageDigitalProfileService programmingLanguageDigitalProfileService;

    @BeforeEach
    void setUp() throws Exception {
        Mockito.when(databaseDigitalProfileService.filterDatabase("3,4,5")).thenReturn(List.of(new Long[]{3L, 5L, 7L}));
        Mockito.when(frameworkDigitalProfileService.filterFramework("1,2,3")).thenReturn(List.of(new Long[]{3L, 5L, 8L}));
        Mockito.when(programmingLanguageDigitalProfileService.filterProgrammingLanguage("1,5,8")).thenReturn(List.of(new Long[]{3L, 5L, 9L}));
    }

    @Test
    void filterDigitalProfile() throws Exception {
        List<Long> result = digitalProfileService.filterDigitalProfile("3,4,5", "1,2,3", "1,5,8");
        List<Long> expectedList = List.of(new Long[]{3L, 5L});
        assertEquals(expectedList, result);
    }
}