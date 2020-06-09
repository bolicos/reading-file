package com.analuciabolico.file.v1.files.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.analuciabolico.file.v1.core.validation.GenericMessagesValidationEnum.DIRECTORY_EMPTY;
import static com.analuciabolico.file.v1.core.validation.MessageValidationProperties.getMessage;

@Slf4j
@Component
public class Scheduler {

    @Value("${directory.input.name}")
    private String directory;

    @Value("${directory.linux.variable}")
    private String linux;

    @Value("${directory.windows.variable}")
    private String windows;

    @Scheduled(fixedRate = 10000)
    public void checkerFiles() {
        String os = System.getProperty("os.name");
        String url = os.equalsIgnoreCase("Linux") ? System.getenv(linux) : System.getenv(windows);

        File folder = new File(url + directory);
        FilenameFilter filter = (dir, name) -> name.endsWith(".dat");
        String[] arrayFiles = folder.list(filter);

        List<String> files = arrayFiles == null ? Collections.emptyList() : Arrays.asList(arrayFiles);

        if (files.isEmpty()) log.info(getMessage(DIRECTORY_EMPTY));
        else files.forEach(this::validateConversion);
    }

    private void validateConversion(String file) {
        log.info(file);
    }
}