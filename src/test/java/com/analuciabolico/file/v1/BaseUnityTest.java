package com.analuciabolico.file.v1;

import com.analuciabolico.file.v1.core.enums.DataTypeFileEnum;
import com.analuciabolico.file.v1.core.model.FileData;
import com.analuciabolico.file.v1.files.model.Customer;
import com.analuciabolico.file.v1.files.model.Sale;
import com.analuciabolico.file.v1.files.model.Salesman;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.analuciabolico.file.v1.Constants.*;
import static com.analuciabolico.file.v1.Tags.RUN_FAST;

@Tag(RUN_FAST)
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class BaseUnityTest {

    protected String getLineCustomer() {
        return CUSTOMER_LINE;
    }

    protected String getLineSalesman() {
        return SALESMAN_LINE;
    }

    protected String getLineSale() {
        return SALE_LINE;
    }

    protected String getLineItem() {
        return ITEM_LINE;
    }

    protected Map<DataTypeFileEnum, List<String>> getMapEmpty() {
        Map<DataTypeFileEnum, List<String>> map = new HashMap<>();
        map.put(DataTypeFileEnum.CUSTOMER, new ArrayList<>());
        map.put(DataTypeFileEnum.SALESMAN, new ArrayList<>());
        map.put(DataTypeFileEnum.SALE, new ArrayList<>());
        return map;
    }

    protected Map<DataTypeFileEnum, List<String>> getMap() {
        return Map.of(
                DataTypeFileEnum.CUSTOMER, List.of(this.getLineCustomer()),
                DataTypeFileEnum.SALESMAN, List.of(this.getLineSalesman()),
                DataTypeFileEnum.SALE, List.of(this.getLineSale())
        );
    }

    protected String getPathAbsoluteInput() {
        return "temp";
    }

    protected List<String> getListStringCustomers() {
        return List.of(getLineCustomer());
    }

    protected List<String> getListStringCustomersFile() {
        return List.of(CUSTOMER_LINE, CUSTOMER_LINE_2);
    }

    protected List<Customer> getListCustomers() {
        return List.of(CUSTOMER_1, CUSTOMER_2);
    }

    protected List<String> getListStringSalespeople() {
        return List.of(getLineSalesman());
    }

    protected List<String> getListStringSalespeopleFile() {
        return List.of(SALESMAN_LINE, SALESMAN_LINE_2);
    }

    protected List<Salesman> getListSalespeople() {
        return List.of(SALESMAN_1, SALESMAN_2);
    }

    protected List<String> getListStringSales() {
        return List.of(getLineSale());
    }

    protected List<String> getListStringSalesFile() {
        return List.of(SALE_LINE);
    }

    protected List<Sale> getListSales() {
        return List.of(SALE_1);
    }

    protected Scanner getScannerDefault() throws IOException {
        return new Scanner(new ClassPathResource(NAME_FILE_ABSOLUTE).getFile());
    }

    protected String getStringNameFileAbsolute() throws IOException {
        return new ClassPathResource(NAME_FILE_ABSOLUTE).getFile().getAbsolutePath();
    }

    protected String getNameFile() {
        return NAME_FILE;
    }

    protected FileData getFileDataObject() {
        return new FileData(getListCustomers(), getListSalespeople(), getListSales());
    }

    protected String none() {
        return NONE;
    }

}
