package com.analuciabolico.file.v1.core.enums;

import com.analuciabolico.file.v1.core.BaseUnityTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessagesOutputEnumTests extends BaseUnityTest {

    private String SUMMARY_COD = "SUMMARY";
    private String QUANTITY_CUSTOMERS_COD = "Number of customers:";
    private String QUANTITY_SELLERS_COD = "Number of sellers:";
    private String MOST_EXPENSIVE_SALE_COD = "Most expensive sales IDs:";
    private String WORST_SELLER_COD = "Name of the worst salespeople:";

    @Test
    @DisplayName("Test SUMMARY")
    void verifySummary() {
        assertEquals(SUMMARY_COD, MessagesOutputEnum.SUMMARY.getKey());
    }

    @Test
    @DisplayName("Test QUANTITY_CUSTOMERS")
    void verifyQuantityCustomers() {
        assertEquals(QUANTITY_CUSTOMERS_COD, MessagesOutputEnum.QUANTITY_CUSTOMERS.getKey());
    }

    @Test
    @DisplayName("Test QUANTITY_SELLERS")
    void verifyQuantitySellers() {
        assertEquals(QUANTITY_SELLERS_COD, MessagesOutputEnum.QUANTITY_SELLERS.getKey());
    }

    @Test
    @DisplayName("Test MOST_EXPENSIVE_SALE")
    void verifyMostExpensiveSale() {
        assertEquals(MOST_EXPENSIVE_SALE_COD, MessagesOutputEnum.MOST_EXPENSIVE_SALE.getKey());
    }
    @Test
    @DisplayName("Test WORST_SELLER")
    void verifyWorstSeller() {
        assertEquals(WORST_SELLER_COD, MessagesOutputEnum.WORST_SELLER.getKey());
    }

}