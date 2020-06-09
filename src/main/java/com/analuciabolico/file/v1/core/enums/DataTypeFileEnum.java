package com.analuciabolico.file.v1.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DataTypeFileEnum {
    SALESMAN("0001"),
    CUSTOMER("002"),
    SALE("003");

    String key;
}
