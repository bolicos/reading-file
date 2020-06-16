package com.analuciabolico.file.v1.files.component;

import com.analuciabolico.file.v1.BaseUnityTest;
import com.analuciabolico.file.v1.core.enums.TypeFileEnum;
import com.analuciabolico.file.v1.core.services.PathsService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

class SchedulerTests extends BaseUnityTest {

    @InjectMocks private Scheduler scheduler;
    @Mock private PathsService environment;

    @Test
    @Disabled
    @DisplayName("Test Scheduler")
    void scheduler() {
        doReturn(getPathAbsoluteInput()).when(environment).getPathAbsoluteInput();
        scheduler.checkerFiles();

        assertEquals(".dat", TypeFileEnum.DAT.getKey());
    }
}