package com.agatino.shoppinglist.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShListTest {
    @Test
    @DisplayName("Should add an item to the shopping list")
    void shouldAddItem() {
        ShList shList = new ShList("Weekly Groceries");
        ShItem aShItem =new ShItem("Milk", 2);

        shList.addItem(aShItem);

        assertThat(shList.getItems()).hasSize(1);
        assertThat(shList.getItems().getFirst().getName()).isEqualTo("Milk");
        assertThat(shList.getItems().getFirst().getQty()).isEqualTo(2);
    }

}