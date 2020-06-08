package com.analuciabolico.file.v1.files.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Scheduled(fixedRate = 10000)
    public void checkerFiles() {
        System.out.println("Fixed Rate scheduler 10s: ");
    }
}