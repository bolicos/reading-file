package com.analuciabolico.file.v1.files.service.implementation;

import com.analuciabolico.file.v1.core.BaseUnityTest;
import com.analuciabolico.file.v1.core.enums.DataTypeFileEnum;
import com.analuciabolico.file.v1.core.model.FileData;
import com.analuciabolico.file.v1.core.services.PathsService;
import com.analuciabolico.file.v1.files.model.Customer;
import com.analuciabolico.file.v1.files.model.Item;
import com.analuciabolico.file.v1.files.model.Sale;
import com.analuciabolico.file.v1.files.model.Salesman;
import com.analuciabolico.file.v1.files.service.interfaces.ISaveFileService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.analuciabolico.file.v1.core.Constants.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

class FileConverterServiceTests extends BaseUnityTest {

    @InjectMocks FileConverterService fileConverterService;

    @Mock PathsService environment;
    @Mock ISaveFileService saveFileService;


    @Test
    @DisplayName("Test getFileData")
    void getFileData() throws IOException {
        doReturn(getStringNameFileAbsolute()).when(environment).formatNameFile(any(), any());
        FileData fileData = fileConverterService.getFileData(getNameFile());

        assertAll("fileData",
                () -> assertEquals(2, fileData.getCustomers().size()),
                () -> assertEquals(2, fileData.getSalespeople().size()),
                () -> assertEquals(1, fileData.getSales().size())
        );
    }

    @Test
    @DisplayName("Test getCustomers")
    void getCustomers() {
        List<Customer> customers = fileConverterService.getCustomers(this.getListStringCustomers());
        assertAll("customers",
                () -> assertEquals(1, customers.size()),
                () -> assertEquals(CUSTOMER_1_NAME, customers.get(0).getName()),
                () -> assertEquals(CUSTOMER_1_CNPJ, customers.get(0).getCnpj()),
                () -> assertEquals(CUSTOMER_1_BUSINESS_AREA, customers.get(0).getBusinessArea())
        );
    }

    @Test
    @DisplayName("Test getSalespeople")
    void getSalespeople() {
        List<Salesman> salespeople = fileConverterService.getSalespeople(this.getListStringSalespeople());
        assertAll("salespeople",
                () -> assertEquals(1, salespeople.size()),
                () -> assertEquals(SALESMAN_1_NAME, salespeople.get(0).getName()),
                () -> assertEquals(SALESMAN_1_CPF, salespeople.get(0).getCpf()),
                () -> assertEquals(SALESMAN_1_SALARY, salespeople.get(0).getSalary())
        );
    }

    @Test
    @DisplayName("Test getSales")
    void getSales() {
        List<Sale> sales = fileConverterService.getSales(this.getListStringSales());
        assertAll("salespeople",
                () -> assertEquals(1, sales.size()),
                () -> assertEquals(SALE_1_ID, sales.get(0).getId()),
                () -> assertEquals(SALE_1_SALESMAN, sales.get(0).getSalesman()),
                () -> assertEquals(3, sales.get(0).getItems().size())
        );
        List<Item> items = sales.get(0).getItems();
        assertAll("items",
                ()  -> assertEquals(SALE_1_ITEM_1.getId(), items.get(0).getId()),
                ()  -> assertEquals(SALE_1_ITEM_1.getPrice(), items.get(0).getPrice()),
                ()  -> assertEquals(SALE_1_ITEM_1.getQuantity(), items.get(0).getQuantity()),
                ()  -> assertEquals(SALE_1_ITEM_2.getId(), items.get(1).getId()),
                ()  -> assertEquals(SALE_1_ITEM_2.getPrice(), items.get(1).getPrice()),
                ()  -> assertEquals(SALE_1_ITEM_2.getQuantity(), items.get(1).getQuantity()),
                ()  -> assertEquals(SALE_1_ITEM_3.getId(), items.get(2).getId()),
                ()  -> assertEquals(SALE_1_ITEM_3.getPrice(), items.get(2).getPrice()),
                ()  -> assertEquals(SALE_1_ITEM_3.getQuantity(), items.get(2).getQuantity())
        );
    }

    @Test
    @DisplayName("Test getItems")
    void getItems() {
        List<Item> items = fileConverterService.getItems(this.getLineItem());
        assertAll("items",
                () -> assertEquals(3, items.size()),
                ()  -> assertEquals(SALE_1_ITEM_1.getId(), items.get(0).getId()),
                ()  -> assertEquals(SALE_1_ITEM_1.getPrice(), items.get(0).getPrice()),
                ()  -> assertEquals(SALE_1_ITEM_1.getQuantity(), items.get(0).getQuantity())
        );
    }

    @Test
    @DisplayName("Test getDataFilterByType")
    void getDataFilterByType() throws IOException {
        Map<DataTypeFileEnum, List<String>> items = fileConverterService.getDataFilterByType(this.getScannerDefault());
        assertAll("items",
                () -> assertEquals(3, items.size()),
                () -> assertEquals(this.getListStringCustomersFile(), items.get(DataTypeFileEnum.CUSTOMER)),
                () -> assertEquals(this.getListStringSalespeopleFile(), items.get(DataTypeFileEnum.SALESMAN)),
                () -> assertEquals(this.getListStringSalesFile(), items.get(DataTypeFileEnum.SALE))
        );
    }

}