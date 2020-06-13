package com.analuciabolico.file.v1.files.service.interfaces;

import com.analuciabolico.file.v1.core.model.FileData;

import java.util.Map;

public interface ISaveFileService {
    void saveDataToFile(Map<String, FileData> files);
}
