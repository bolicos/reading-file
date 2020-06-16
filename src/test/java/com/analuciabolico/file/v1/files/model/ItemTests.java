package com.analuciabolico.file.v1.files.model;

import com.analuciabolico.file.v1.BaseUnityTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTests extends BaseUnityTest {

    @Test
    @DisplayName("Test item")
    void total() {
        Item item = new Item(1L, 10, 5.5);
        assertEquals(55, item.total());
    }
}