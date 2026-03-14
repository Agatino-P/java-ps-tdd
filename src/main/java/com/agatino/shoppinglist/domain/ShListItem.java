package com.agatino.shoppinglist.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ShListItem {
    private final UUID id;
    private final String name;
    private final int qty;

    public ShListItem(String name, int qty) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.qty = qty;
    }
}