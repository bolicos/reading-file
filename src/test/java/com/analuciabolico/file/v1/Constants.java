package com.analuciabolico.file.v1;

import com.analuciabolico.file.v1.files.model.Customer;
import com.analuciabolico.file.v1.files.model.Item;
import com.analuciabolico.file.v1.files.model.Sale;
import com.analuciabolico.file.v1.files.model.Salesman;

import java.util.List;

import static java.lang.Long.parseLong;

public class Constants {

    public static final String SALESMAN_LINE = "001ç1234567891234çPedroç50000";
    public static final String SALESMAN_LINE_2 = "001ç3245678865434çPauloç40000.99";
    public static final String CUSTOMER_LINE = "002ç2345675434544345çJose da SilvaçRural";
    public static final String CUSTOMER_LINE_2 = "002ç2345675433444345çEduardo PereiraçRural";
    public static final String SALE_LINE = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro";
    public static final String ITEM_LINE = "[1-10-100,2-30-2.50,3-40-3.10]";

    public static final String CUSTOMER_1_NAME = "Jose da Silva";
    public static final String CUSTOMER_1_CNPJ = "2345675434544345";
    public static final String CUSTOMER_1_BUSINESS_AREA = "Rural";

    public static final String SALESMAN_1_NAME = "Pedro";
    public static final String SALESMAN_1_CPF = "1234567891234";
    public static final Double SALESMAN_1_SALARY = 50000.0;

    public static final Long SALE_1_ID = parseLong("10");
    public static final String SALE_1_SALESMAN = "Pedro";
    public static final Item SALE_1_ITEM_1 = new Item(1L, 10, 100.0);
    public static final Item SALE_1_ITEM_2 = new Item(2L, 30, 2.50);
    public static final Item SALE_1_ITEM_3 = new Item(3L, 40, 3.10);

    public static final Salesman SALESMAN_1 = new Salesman("Pedro", "1234567891234", 50000.0);
    public static final Salesman SALESMAN_2 = new Salesman("Paulo", "3245678865434", 40000.99);

    public static final Customer CUSTOMER_1 = new Customer("Jose da Silva", "2345675434544345", "Rural");
    public static final Customer CUSTOMER_2 = new Customer("Eduardo Pereira", "2345675433444345", "Rural");

    public static final Sale SALE_1 = new Sale(10L, List.of(SALE_1_ITEM_1, SALE_1_ITEM_2, SALE_1_ITEM_3), "Pedro");

    public static final String NAME_FILE = "example.dat";
    public static final String NAME_FILE_ABSOLUTE = "data/in/example.dat";

    public static final String SUMMARY_MESSAGE = "SUMMARY\n\n";
    public static final String NUMBER_OF_CUSTOMERS_MESSAGE = "Number of customers:\n2\n";
    public static final String NUMBER_OF_SELLERS_MESSAGE = "Number of sellers:\n2\n";
    public static final String MOST_EXPENSIVE_SALE_MESSAGE = "Most expensive sales IDs:\n[10]\n";
    public static final String WORST_SELLER_MESSAGE = "Name of the worst salespeople:\n[Paulo]\n";

    public static final String NONE = "None";
}
