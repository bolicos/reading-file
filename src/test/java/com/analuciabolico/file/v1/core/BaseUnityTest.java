package com.analuciabolico.file.v1.core;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static com.analuciabolico.file.v1.core.Tags.RUN_FAST;

@Tag(RUN_FAST)
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class BaseUnityTest {

}
