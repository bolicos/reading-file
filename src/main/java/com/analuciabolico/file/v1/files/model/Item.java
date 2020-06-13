package com.analuciabolico.file.v1.files.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {

    private Long id;
    private Integer quantity;
    private Double price;

    public Double total() {
        return this.price * this.quantity;
    }

}
