package com.example.digitalmindwebservices.service.cross;

import com.example.digitalmindwebservices.repository.cross.IDatabaseDigitalProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IDatabaseDigitalProfileServiceTest {

    @Autowired
    IDatabaseDigitalProfileService iDatabaseDigitalProfileService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void filterDatabase() throws Exception {
        List<Long> list = iDatabaseDigitalProfileService.filterDatabase("1,2,3");
        System.out.println(list);
    }
}