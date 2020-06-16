package com.analuciabolico.file.v1.core.validation;


import com.analuciabolico.file.v1.BaseUnityTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericMessagesValidationEnumTest extends BaseUnityTest {

    private final String SUCCESS_CREATING_NAME_FILE = "successCreatingNameFile.message";
    private final String ERROR_CREATING_NAME_FILE = "errorCreatingNameFile.message";
    private final String FILE_NOT_FOUND_EXCEPTION = "fileNotFoundException.message";
    private final String DIRECTORY_EMPTY = "directoryEmpty.message";

    @Test
    @DisplayName("Test SUCCESS_CREATING_NAME_FILE")
    void testSuccessCreatingNameFile() {
        assertEquals(SUCCESS_CREATING_NAME_FILE, GenericMessagesValidationEnum.SUCCESS_CREATING_NAME_FILE.getKey());
    }

    @Test
    @DisplayName("Test ERROR_CREATING_NAME_FILE")
    void testErrorCreatingNameFile() {
        assertEquals(ERROR_CREATING_NAME_FILE, GenericMessagesValidationEnum.ERROR_CREATING_NAME_FILE.getKey());
    }

    @Test
    @DisplayName("Test FILE_NOT_FOUND_EXCEPTION")
    void testFileNotFoundException() {
        assertEquals(FILE_NOT_FOUND_EXCEPTION, GenericMessagesValidationEnum.FILE_NOT_FOUND_EXCEPTION.getKey());
    }

    @Test
    @DisplayName("Test DIRECTORY_EMPTY")
    void testDirectoryEmpty() {
        assertEquals(DIRECTORY_EMPTY, GenericMessagesValidationEnum.DIRECTORY_EMPTY.getKey());
    }
}