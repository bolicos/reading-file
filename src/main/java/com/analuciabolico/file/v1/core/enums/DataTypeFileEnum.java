package com.analuciabolico.file.v1.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum DataTypeFileEnum {
    SALESMAN("001"),
    CUSTOMER("002"),
    SALE("003");

    String key;

    public static Map<DataTypeFileEnum, List<String>> verifyLine(String line, Map<DataTypeFileEnum, List<String>> map) {
        Arrays.asList(DataTypeFileEnum.values()).forEach(dataTypeFileEnum -> {
            if(line.startsWith(dataTypeFileEnum.getKey())) {
                List<String> list = map.get(dataTypeFileEnum);
                list.add(line);
                map.put(dataTypeFileEnum, list);
            }
        });
        return map;
    }
}