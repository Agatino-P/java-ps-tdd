package com.agatino.shoppinglist.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShListTest {
    @Test
    @DisplayName("Should add an item to the shopping list")
    void shouldAddItem() {
        ShList shList = new ShList("Weekly Groceries");
        ShListItem aShListItem =new ShListItem("Milk", 2);

        shList.addItem(aShListItem);

        assertThat(shList.getItems()).hasSize(1);
        assertThat(shList.getItems().get(0).getName()).isEqualTo("Milk");
        assertThat(shList.getItems().get(0).getQty()).isEqualTo(2);
    }

}