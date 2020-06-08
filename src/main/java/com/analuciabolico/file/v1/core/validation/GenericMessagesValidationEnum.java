package com.analuciabolico.file.v1.core.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenericMessagesValidationEnum {
    INVALID_CPF("invalidCpf.message"),
    GENERIC_ERROR("genericError.message");

    private String key;
}
