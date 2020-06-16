package com.analuciabolico.file.v1.core.enums;

import com.analuciabolico.file.v1.BaseUnityTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TypeFileEnumTests extends BaseUnityTest {

    private String DAT_COD = ".dat";
    private String DONE_DAT_COD = ".done.dat";

    @Test
    @DisplayName("Test DAT")
    void verifyDat() {
        assertEquals(DAT_COD, TypeFileEnum.DAT.getKey());
    }

    @Test
    @DisplayName("Test DONE_DAT")
    void verifyDoneDat() {
        assertEquals(DONE_DAT_COD, TypeFileEnum.DONE_DAT.getKey());
    }

}