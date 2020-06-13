package com.analuciabolico.file.v1.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessagesOutputEnum {
    SUMMARY("SUMMARY"),
    QUANTITY_CUSTOMERS("Number of customers:"),
    QUANTITY_SELLERS("Number of sellers:"),
    MOST_EXPENSIVE_SALE("Most expensive sales IDs:"),
    WORST_SELLER("Name of the worst salespeople:");

    String key;
}
