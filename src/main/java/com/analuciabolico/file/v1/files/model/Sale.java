package com.analuciabolico.file.v1.files.model;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Generated
@NoArgsConstructor
@AllArgsConstructor
public class Sale implements Serializable {

    private Long id;
    private List<Item> items;
    private String salesman;

}
