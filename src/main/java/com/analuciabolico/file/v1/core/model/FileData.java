package com.analuciabolico.file.v1.core.model;

import com.analuciabolico.file.v1.files.model.Customer;
import com.analuciabolico.file.v1.files.model.Sale;
import com.analuciabolico.file.v1.files.model.Salesman;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Generated
@NoArgsConstructor
@AllArgsConstructor
public class FileData implements Serializable {

    private List<Customer> customers;
    private List<Salesman> salespeople;
    private List<Sale> sales;

}
