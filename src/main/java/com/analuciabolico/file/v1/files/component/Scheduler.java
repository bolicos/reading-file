package com.analuciabolico.file.v1.files.component;

import com.analuciabolico.file.v1.core.services.PathsService;
import com.analuciabolico.file.v1.files.service.interfaces.IFileConverterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.analuciabolico.file.v1.core.validation.GenericMessagesValidationEnum.DIRECTORY_EMPTY;
import static com.analuciabolico.file.v1.core.validation.MessageValidationProperties.getMessage;

@Slf4j
@Component
public class Scheduler {

    private final PathsService environment;
    private final IFileConverterService fileConverterService;

    public Scheduler(PathsService environment, IFileConverterService fileConverterService) {
        this.environment = environment;
        this.fileConverterService = fileConverterService;
    }

    @Scheduled(fixedRate = 10000)
    public void checkerFiles() {
        File folder = new File(environment.getPathAbsolute());
        FilenameFilter filter = (dir, name) -> name.endsWith(".dat");
        String[] arrayFiles = folder.list(filter);

        List<String> files = arrayFiles == null ? Collections.emptyList() : Arrays.asList(arrayFiles);

        if (files.isEmpty()) log.info(getMessage(DIRECTORY_EMPTY));
        else {
            List<String> list = files.stream().filter(this::validateConversion).collect(Collectors.toList());
            fileConverterService.generateReport(list);
        }
    }

    private boolean validateConversion(String file) {
        log.info(file);
        return true;
    }
}