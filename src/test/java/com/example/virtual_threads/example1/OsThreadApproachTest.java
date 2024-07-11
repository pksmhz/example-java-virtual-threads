package com.example.virtual_threads.example1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OsThreadApproachTest {

    @Autowired
    OsThreadApproach osThreadApproach;

    @Test
    void osThreadApproachTest() {
        Assertions.assertTrue(osThreadApproach.execute());
    }
}
