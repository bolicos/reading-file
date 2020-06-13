package com.analuciabolico.file.v1.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeFileEnum {
    DAT(".dat"),
    DONE_DAT(".done.dat");

    String key;
}
