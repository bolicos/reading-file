package com.analuciabolico.file.v1.core.validation;

import com.analuciabolico.file.v1.BaseUnityTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.analuciabolico.file.v1.core.validation.GenericMessagesValidationEnum.GENERIC_ERROR;
import static com.analuciabolico.file.v1.core.validation.MessageValidationProperties.getMessage;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageValidationPropertiesTest extends BaseUnityTest {

    private final String GENERIC_ERROR_MESSAGE = "Internal server error.";

    @Test
    @DisplayName("Test GENERIC_ERROR")
    void getMessageTest() {
        String message = getMessage(GENERIC_ERROR);
        assertEquals(GENERIC_ERROR_MESSAGE, message);
    }
}