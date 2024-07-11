package com.example.virtual_threads.example2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;


@Slf4j
@Component
public class VirtualThreadApproach {

    public boolean execute() {

        long l = System.currentTimeMillis();
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 10000).forEach(i -> {
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    log.info("Thread ID [{}]", i);
                    return i;
                });
            });
        }

        log.info("Virtual threads elapsed time: {}", System.currentTimeMillis() - l);
        return true;
    }
}
