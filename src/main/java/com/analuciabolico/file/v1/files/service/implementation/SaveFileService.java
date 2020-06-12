package com.analuciabolico.file.v1.files.service.implementation;

import com.analuciabolico.file.v1.core.enums.MessagesOutputEnum;
import com.analuciabolico.file.v1.core.enums.TypeFileEnum;
import com.analuciabolico.file.v1.core.model.FileData;
import com.analuciabolico.file.v1.core.services.PathsService;
import com.analuciabolico.file.v1.files.model.Customer;
import com.analuciabolico.file.v1.files.model.Item;
import com.analuciabolico.file.v1.files.model.Sale;
import com.analuciabolico.file.v1.files.model.Salesman;
import com.analuciabolico.file.v1.files.service.interfaces.ISaveFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SaveFileService implements ISaveFileService {

    private final PathsService environment;

    public SaveFileService(PathsService environment) {
        this.environment = environment;
    }

    @Override
    public void saveDataToFile(Map<String, FileData> files) {
        files.forEach((key, fileData) -> {
            List<String> content = this.calculateReportData(fileData);

            String nameFile = key.replace(".dat", TypeFileEnum.DONE_DAT.getKey());
            String filePath = this.environment.formatNameFile(nameFile, TypeFileEnum.DONE_DAT);
            File file = new File(filePath);

            try {
                boolean created = false;
                if (!file.exists()) {
                    created = file.createNewFile();
                    log.info("File created with name: " + nameFile + ".");
                }

                FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (String text : content) {
                    bufferedWriter.write(text);
                }

                bufferedWriter.close();
                if (!created) throw new IOException();
            } catch (IOException exception) {
                log.warn("Error created file:" + nameFile + ".");
            }
        });
    }

    private List<String> calculateReportData(FileData fileData) {
        String numberOfCustomers = String.format("%s%n%s%n",
                MessagesOutputEnum.QUANTITY_CUSTOMERS.getKey(),
                this.numberOfCustomers(fileData.getCustomers())
            );
        String numberOfSellers = String.format("%s%n%s%n",
                MessagesOutputEnum.QUANTITY_SELLERS.getKey(),
                this.numberOfSellers(fileData.getSalespeople())
        );
        String mostExpensiveSale = String.format("%s%n%s%n",
                MessagesOutputEnum.MOST_EXPENSIVE_SALE.getKey(),
                this.mostExpensiveSale(fileData.getSales())
        );
        String worstSeller = String.format("%s%n%s%n",
                MessagesOutputEnum.WORST_SELLER.getKey(),
                this.worstSeller(fileData.getSalespeople(), fileData.getSales())
        );

        List<String> list = new ArrayList<>();
        list.add(numberOfCustomers);
        list.add(numberOfSellers);
        list.add(mostExpensiveSale);
        list.add(worstSeller);
        return list;
    }

    private String numberOfCustomers(List<Customer> customers) {
        return String.valueOf(customers.size());
    }

    private String numberOfSellers(List<Salesman> salespeople) {
        return String.valueOf(salespeople.size());
    }

    private List<Long> mostExpensiveSale(List<Sale> sales) {
        Map<Long, Double> salesValues = new HashMap<>();
        sales.forEach(sale -> {
            Double value = sale.getItems().stream().mapToDouble(Item::total).sum();
            salesValues.put(sale.getId(), value);
        });

        OptionalDouble value = salesValues.values().stream().mapToDouble(aDouble -> aDouble).max();

        return value.isPresent() ?
                salesValues.entrySet()
                        .stream()
                        .filter(map -> map.getValue() == value.getAsDouble())
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList()) :
                Collections.emptyList();
    }

    private String worstSeller(List<Salesman> salespeople, List<Sale> sales) {
        return "TEST.";
    }
}
