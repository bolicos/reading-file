package com.analuciabolico.file.v1.files.service.implementation;

import com.analuciabolico.file.v1.core.enums.DataTypeFileEnum;
import com.analuciabolico.file.v1.core.model.FileData;
import com.analuciabolico.file.v1.core.services.PathsService;
import com.analuciabolico.file.v1.files.model.Customer;
import com.analuciabolico.file.v1.files.model.Sale;
import com.analuciabolico.file.v1.files.model.Salesman;
import com.analuciabolico.file.v1.files.service.interfaces.IFileConverterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.analuciabolico.file.v1.core.validation.GenericMessagesValidationEnum.FILE_NOT_FOUND_EXCEPTION;
import static com.analuciabolico.file.v1.core.validation.MessageValidationProperties.getMessage;

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
        return file == null ?
                new FileData() :
                new FileData(
                        this.getCustomers(getDataFilterByType(file, DataTypeFileEnum.CUSTOMER)),
                        this.getSalespeople(getDataFilterByType(file, DataTypeFileEnum.SALESMAN)),
                        this.getSales(getDataFilterByType(file, DataTypeFileEnum.SALE))
                );
    }

    private List<Customer> getCustomers(List<String> text) {
        List<Customer> customerList = new ArrayList<>();
        return null;
    }

    private List<Salesman> getSalespeople(List<String> text) {
        return null;
    }

    private List<Sale> getSales(List<String> text) {
        return null;
    }

    private List<String> getDataFilterByType(Scanner text, DataTypeFileEnum dataTypeFileEnum) {
        List<String> list = new ArrayList<>();
        while(text.hasNextLine()){
            String line = text.nextLine();
            if(line.startsWith(dataTypeFileEnum.getKey())) list.add(line);
        }
        return list;
    }

}
