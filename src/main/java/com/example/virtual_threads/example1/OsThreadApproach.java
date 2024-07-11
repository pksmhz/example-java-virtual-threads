package com.example.virtual_threads.example1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;


@Slf4j
@Component
public class OsThreadApproach {

    public boolean execute() {

        long l = System.currentTimeMillis();
        try (ExecutorService executorService = Executors.newFixedThreadPool(200)) {

            IntStream.range(0, 10000).forEach(i -> {
                executorService.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    log.info("Thread ID [{}]", i);
                    return i;
                });
            });
        }

        log.info("OS threads elapsed time: {}", System.currentTimeMillis() - l);
        return true;
    }
}
