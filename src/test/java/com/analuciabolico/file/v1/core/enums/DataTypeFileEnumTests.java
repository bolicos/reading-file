package com.analuciabolico.file.v1.core.enums;

import com.analuciabolico.file.v1.core.BaseUnityTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static com.analuciabolico.file.v1.core.enums.DataTypeFileEnum.verifyLine;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class DataTypeFileEnumTests extends BaseUnityTest {

    private String SALESMAN_COD = "001";
    private String CUSTOMER_COD = "002";
    private String SALE_COD = "003";

    @Test
    @DisplayName("Very Line CUSTOMER")
    void verifyLineCustomer() {
        Map<DataTypeFileEnum, List<String>> map = verifyLine(this.getLineCustomer(), this.getMapEmpty());
        assertAll("map",
                () -> assertEquals(1, map.get(DataTypeFileEnum.CUSTOMER).size()),
                () -> assertEquals(this.getLineCustomer(), map.get(DataTypeFileEnum.CUSTOMER).get(0))
        );
    }

    @Test
    @DisplayName("Very Line SALESMAN")
    void verifyLineSalesman() {
        Map<DataTypeFileEnum, List<String>> map = verifyLine(this.getLineSalesman(), this.getMapEmpty());
        assertAll("map",
                () -> assertEquals(1, map.get(DataTypeFileEnum.SALESMAN).size()),
                () -> assertEquals(this.getLineSalesman(), map.get(DataTypeFileEnum.SALESMAN).get(0))
        );
    }

    @Test
    @DisplayName("Very Line SALE")
    void verifyLineSale() {
        Map<DataTypeFileEnum, List<String>> map = verifyLine(this.getLineSale(), this.getMapEmpty());
        assertAll("map",
                () -> assertEquals(1, map.get(DataTypeFileEnum.SALE).size()),
                () -> assertEquals(this.getLineSale(), map.get(DataTypeFileEnum.SALE).get(0))
        );
    }

    @Test
    @DisplayName("Test SALESMAN")
    void verifySalesman() {
        assertEquals(SALESMAN_COD, DataTypeFileEnum.SALESMAN.getKey());
    }

    @Test
    @DisplayName("Test CUSTOMER")
    void verifyCustomer() {
        assertEquals(CUSTOMER_COD, DataTypeFileEnum.CUSTOMER.getKey());
    }

    @Test
    @DisplayName("Test SALE")
    void verifySale() {
        assertEquals(SALE_COD, DataTypeFileEnum.SALE.getKey());
    }

}