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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import static com.analuciabolico.file.v1.core.common.Constants.NONE;
import static com.analuciabolico.file.v1.core.common.Constants.SUMMARY_SPACING;
import static com.analuciabolico.file.v1.core.common.Constants.TITLE_AND_RESPONSE_SPACING;
import static com.analuciabolico.file.v1.core.validation.GenericMessagesValidationEnum.ERROR_CREATING_NAME_FILE;
import static com.analuciabolico.file.v1.core.validation.GenericMessagesValidationEnum.SUCCESS_CREATING_NAME_FILE;
import static com.analuciabolico.file.v1.core.validation.MessageValidationProperties.getMessage;

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

            String nameFile = key.replace(TypeFileEnum.DAT.getKey(), TypeFileEnum.DONE_DAT.getKey());
            String filePath = this.environment.formatNameFile(nameFile, TypeFileEnum.DONE_DAT);
            File file = new File(filePath);

            try {
                boolean created = false;
                if (!file.exists()) {
                    created = file.createNewFile();
                    log.info(getMessage(SUCCESS_CREATING_NAME_FILE) + nameFile + ".");
                }

                FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (String text : content) {
                    bufferedWriter.write(text);
                }

                bufferedWriter.close();
                if (!created) throw new IOException();
            } catch (IOException exception) {
                log.warn(getMessage(ERROR_CREATING_NAME_FILE) + nameFile + ".");
            }
        });
    }

    public List<String> calculateReportData(FileData fileData) {
        String summary = String.format(SUMMARY_SPACING, MessagesOutputEnum.SUMMARY);
        String numberOfCustomers = String.format(TITLE_AND_RESPONSE_SPACING,
                MessagesOutputEnum.QUANTITY_CUSTOMERS.getKey(),
                this.numberOfCustomers(fileData.getCustomers())
            );
        String numberOfSellers = String.format(TITLE_AND_RESPONSE_SPACING,
                MessagesOutputEnum.QUANTITY_SELLERS.getKey(),
                this.numberOfSellers(fileData.getSalespeople())
        );
        String mostExpensiveSale = String.format(TITLE_AND_RESPONSE_SPACING,
                MessagesOutputEnum.MOST_EXPENSIVE_SALE.getKey(),
                this.mostExpensiveSale(fileData.getSales())
        );
        String worstSeller = String.format(TITLE_AND_RESPONSE_SPACING,
                MessagesOutputEnum.WORST_SELLER.getKey(),
                this.worstSeller(fileData.getSalespeople(), fileData.getSales())
        );

        return List.of(summary, numberOfCustomers, numberOfSellers, mostExpensiveSale, worstSeller);
    }

    public String numberOfCustomers(List<Customer> customers) {
        return String.valueOf(customers.size());
    }

    public String numberOfSellers(List<Salesman> salespeople) {
        return String.valueOf(salespeople.size());
    }

    public List<String> mostExpensiveSale(List<Sale> sales) {
        Map<Long, Double> salesValues = new HashMap<>();
        sales.forEach(sale -> {
            Double value = sale.getItems().stream().mapToDouble(Item::total).sum();
            salesValues.put(sale.getId(), value);
        });

        OptionalDouble value = salesValues.values().stream().mapToDouble(aDouble -> aDouble).max();

        return value.isEmpty() ?
                List.of(NONE) :
                salesValues.entrySet()
                        .stream()
                        .filter(map -> map.getValue() == value.getAsDouble())
                        .map(Map.Entry::getKey)
                        .map(String::valueOf)
                        .collect(Collectors.toList());
    }

    public List<String> worstSeller(List<Salesman> salespeople, List<Sale> sales) {
        Map<String, Integer> sellers = new HashMap<>();
        salespeople.forEach(salesman -> {
            Integer value = Math.toIntExact(sales.stream().filter(sale ->
                        sale.getSalesman().equals(salesman.getName())).count()
                    );
            sellers.put(salesman.getName(), value);
        });

        int worse = sellers.values().stream().mapToInt(aInt -> aInt).min().orElse(-1);

        return worse == -1 ?
                List.of(NONE) :
                sellers.entrySet()
                        .stream()
                        .filter(map -> map.getValue().equals(worse))
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());
    }
}
