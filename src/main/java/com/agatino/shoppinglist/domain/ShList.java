package com.agatino.shoppinglist.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ShList {
    @Getter
    private final UUID id;
    @Getter
    private final String name;
    private final List<ShListItem> items = new ArrayList<>();

    public ShList(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public void addItem(ShListItem item) {
        this.items.add(item);
    }

    public List<ShListItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}