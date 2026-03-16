package com.agatino.shoppinglist.domain.model;

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
    private final List<ShItem> items = new ArrayList<>();

    // Canonical Constructor
    public ShList(UUID id, String name, List<ShItem> items) {
        this.id = id;
        this.name = name;
        if (items != null) {
            this.items.addAll(items);
        }
    }

    public ShList(String name, List<ShItem> items) {
        this(UUID.randomUUID(), name, items);
    }

    public ShList(String name) {
        this(UUID.randomUUID(), name, Collections.emptyList());
    }

    public void addItem(ShItem item) {
        this.items.add(item);
    }

    public List<ShItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}