package com.analuciabolico.file.v1.files.service.implementation;

import com.analuciabolico.file.v1.core.enums.DataTypeFileEnum;
import com.analuciabolico.file.v1.core.model.FileData;
import com.analuciabolico.file.v1.core.services.PathsService;
import com.analuciabolico.file.v1.files.model.Customer;
import com.analuciabolico.file.v1.files.model.Item;
import com.analuciabolico.file.v1.files.model.Sale;
import com.analuciabolico.file.v1.files.model.Salesman;
import com.analuciabolico.file.v1.files.service.interfaces.IFileConverterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.analuciabolico.file.v1.core.validation.GenericMessagesValidationEnum.FILE_NOT_FOUND_EXCEPTION;
import static com.analuciabolico.file.v1.core.validation.MessageValidationProperties.getMessage;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

@Slf4j
@Service
public class FileConverterService implements IFileConverterService {

    private final PathsService environment;

    public FileConverterService(PathsService environment) {
        this.environment = environment;
    }

    public void generateReport(List<String> filesNames) {
    Map<String, FileData> files = new HashMap<>();

    filesNames.forEach(name -> files.put(name, this.getFileData(name)));

    }

    private FileData getFileData(String name) {
        Scanner file = null;
        try {
            String filePath = String.format("%s/%s", environment.getPathAbsolute(), name);
            file = new Scanner(new File(filePath));
        } catch (FileNotFoundException exception) {
           log.warn(getMessage(FILE_NOT_FOUND_EXCEPTION));
        }

        if (file == null) {
            return new FileData();
        } else {
            Map<DataTypeFileEnum, List<String>> map = getDataFilterByType(file);
            file.close();
            return new FileData(
                    this.getCustomers(map.get(DataTypeFileEnum.CUSTOMER)),
                    this.getSalespeople(map.get(DataTypeFileEnum.SALESMAN)),
                    this.getSales(map.get(DataTypeFileEnum.SALE))
            );
        }
    }

    private List<Customer> getCustomers(List<String> text) {
        List<Customer> customerList = new ArrayList<>();
        if (text.isEmpty()) {
            return customerList;
        } else {
            text.forEach(line -> {
                List<String> columns = Arrays.asList(line.split("ç"));
                customerList.add(
                        new Customer(columns.get(2), columns.get(1), columns.get(3))
                );
            });
        }
        return customerList;
    }

    private List<Salesman> getSalespeople(List<String> text) {
        List<Salesman> salesmenList = new ArrayList<>();
        if (text.isEmpty()) {
            return salesmenList;
        } else {
            text.forEach(line -> {
                List<String> columns = Arrays.asList(line.split("ç"));
                salesmenList.add(
                        new Salesman(columns.get(2), columns.get(1), parseDouble(columns.get(3)))
                );
            });
        }
        return salesmenList;
    }

    private List<Sale> getSales(List<String> text) {
        List<Sale> saleList = new ArrayList<>();
        if (text.isEmpty()) {
            return saleList;
        } else {
            text.forEach(line -> {
                List<String> columns = Arrays.asList(line.split("ç"));
                saleList.add(
                        new Sale(parseLong(columns.get(1)), getItems(columns.get(2)), columns.get(3))
                );
            });
        }
        return saleList;
    }

    private List<Item> getItems(String text) {
        List<Item> itemList = new ArrayList<>();
        if (text.isEmpty()) {
            return itemList;
        } else {
            text = text.replace("[", "");
            text = text.replace("]", "");
            List<String> items = Arrays.asList(text.split(","));
            items.forEach(item -> {
                List<String> columns = Arrays.asList(item.split("-"));
                itemList.add(new Item(
                        parseLong(columns.get(0)),
                        parseInt(columns.get(1)),
                        parseDouble(columns.get(2))
                        )
                );
            });
        }
        return itemList;
    }

    private Map<DataTypeFileEnum, List<String>> getDataFilterByType(Scanner text) {
        Map<DataTypeFileEnum, List<String>> data = new HashMap<>();
        data.put(DataTypeFileEnum.SALESMAN, new ArrayList<>());
        data.put(DataTypeFileEnum.CUSTOMER, new ArrayList<>());
        data.put(DataTypeFileEnum.SALE, new ArrayList<>());

        while(text.hasNextLine()){
            String line = text.nextLine();
            data = DataTypeFileEnum.verifyLine(line, data);
        }
        text.close();
        return data;
    }

}
