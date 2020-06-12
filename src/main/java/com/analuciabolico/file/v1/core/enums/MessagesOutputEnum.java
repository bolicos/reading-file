package com.analuciabolico.file.v1.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessagesOutputEnum {
    QUANTITY_CUSTOMERS("Quantidade de clientes no arquivo de entrada:"),
    QUANTITY_SELLERS("Quantidade de vendedores no arquivo de entrada:"),
    MOST_EXPENSIVE_SALE("ID da venda mais cara:"),
    WORST_SELLER("O pior vendedor:");

    String key;
}
