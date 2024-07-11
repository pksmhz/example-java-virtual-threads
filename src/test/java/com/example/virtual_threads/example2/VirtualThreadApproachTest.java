package com.example.virtual_threads.example2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OsThreadApproachTest {

    @Autowired
    VirtualThreadApproach virtualThreadApproach;

    @Test
    void osThreadApproachTest() {
        Assertions.assertTrue(virtualThreadApproach.execute());
    }
}
