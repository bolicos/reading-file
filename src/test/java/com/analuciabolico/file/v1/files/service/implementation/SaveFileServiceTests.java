package com.analuciabolico.file.v1.files.service.implementation;

import com.analuciabolico.file.v1.BaseUnityTest;
import com.analuciabolico.file.v1.core.services.PathsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;

import static com.analuciabolico.file.v1.Constants.MOST_EXPENSIVE_SALE_MESSAGE;
import static com.analuciabolico.file.v1.Constants.NUMBER_OF_CUSTOMERS_MESSAGE;
import static com.analuciabolico.file.v1.Constants.NUMBER_OF_SELLERS_MESSAGE;
import static com.analuciabolico.file.v1.Constants.SUMMARY_MESSAGE;
import static com.analuciabolico.file.v1.Constants.WORST_SELLER_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SaveFileServiceTests extends BaseUnityTest {

    @InjectMocks SaveFileService saveFileService;

    @Mock
    PathsService environment;

    @Test
    @DisplayName("Test getFileData")
    void getFileData()  {
        List<String> fileData = saveFileService.calculateReportData(this.getFileDataObject());

        assertAll("fileData",
                () -> assertEquals(5, fileData.size()),
                () -> assertEquals(SUMMARY_MESSAGE, fileData.get(0)),
                () -> assertEquals(NUMBER_OF_CUSTOMERS_MESSAGE, fileData.get(1)),
                () -> assertEquals(NUMBER_OF_SELLERS_MESSAGE, fileData.get(2)),
                () -> assertEquals(MOST_EXPENSIVE_SALE_MESSAGE, fileData.get(3)),
                () -> assertEquals(WORST_SELLER_MESSAGE, fileData.get(4))
        );
    }

    @Test
    @DisplayName("Test numberOfCustomers")
    void numberOfCustomers() {
        String numberOfCustomers = saveFileService.numberOfCustomers(this.getListCustomers());
        String size = String.valueOf(this.getListCustomers().size());
        assertEquals(size, numberOfCustomers);
    }

    @Test
    @DisplayName("Test numberOfSellers")
    void numberOfSellers() {
        String numberOfSellers = saveFileService.numberOfSellers(this.getListSalespeople());
        String size = String.valueOf(this.getListSalespeople().size());
        assertEquals(size, numberOfSellers);
    }

    @Test
    @DisplayName("Test mostExpensiveSale")
    void mostExpensiveSale() {
        List<String> mostExpensiveSale = saveFileService.mostExpensiveSale(this.getListSales());
        int size = this.getListSales().size();

        assertAll("mostExpensiveSale",
                () -> assertEquals(size, mostExpensiveSale.size()),
                () -> assertEquals("10", mostExpensiveSale.get(0))
        );
    }

    @Test
    @DisplayName("Test mostExpensiveSaleEmpty")
    void mostExpensiveSaleEmpty() {
        List<String> mostExpensiveSale = saveFileService.mostExpensiveSale(Collections.emptyList());

        assertAll("mostExpensiveSale",
                () -> assertEquals(1, mostExpensiveSale.size()),
                () -> assertEquals(this.none(), mostExpensiveSale.get(0))
        );
    }

    @Test
    @DisplayName("Test worstSeller")
    void worstSeller() {
        List<String> worstSeller = saveFileService.worstSeller(this.getListSalespeople(), this.getListSales());

        assertAll("worstSeller",
                () -> assertEquals(1, worstSeller.size()),
                () -> assertEquals("Paulo", worstSeller.get(0))
        );
    }

    @Test
    @DisplayName("Test worstSellerEmpty")
    void worstSellerEmpty() {
        List<String> worstSeller = saveFileService.worstSeller(Collections.emptyList(), Collections.emptyList());

        assertAll("worstSeller",
                () -> assertEquals(1, worstSeller.size()),
                () -> assertEquals(this.none(), worstSeller.get(0))
        );
    }

}