package com.analuciabolico.file.v1.core.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenericMessagesValidationEnum {
    SUCCESS_CREATING_NAME_FILE("successCreatingNameFile.message"),
    ERROR_CREATING_NAME_FILE("errorCreatingNameFile.message"),
    FILE_NOT_FOUND_EXCEPTION("fileNotFoundException.message"),
    DIRECTORY_EMPTY("directoryEmpty.message");

    private String key;
}
