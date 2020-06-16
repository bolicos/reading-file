package com.analuciabolico.file.v1.core.common;

import com.analuciabolico.file.v1.BaseUnityTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConstantsTests extends BaseUnityTest {

    @InjectMocks
    private Constants constants;

    private String NONE = "None";
    private String SUMMARY_SPACING = "%s%n%n";
    private String READING_ARCHIVE = "Reading file: ";
    private String TITLE_AND_RESPONSE_SPACING = "%s%n%s%n";

    @Test
    @DisplayName("Test NONE")
    void noneTest() {
        assertEquals(this.NONE, this.none());
    }

    @Test
    @DisplayName("Test SUMMARY_SPACING")
    void summarySpacing() {
        assertEquals(this.SUMMARY_SPACING, constants.SUMMARY_SPACING);
    }

    @Test
    @DisplayName("Test READING_ARCHIVE")
    void readingArchive() {
        assertEquals(this.READING_ARCHIVE, constants.READING_ARCHIVE);
    }

    @Test
    @DisplayName("Test TITLE_AND_RESPONSE_SPACING")
    void titleAndResponseSpacing() {
        assertEquals(this.TITLE_AND_RESPONSE_SPACING, constants.TITLE_AND_RESPONSE_SPACING);
    }

}