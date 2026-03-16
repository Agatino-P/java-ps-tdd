package com.agatino.shoppinglist.domain.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ShItem {
    @Getter
    private final UUID id;
    @Getter
    private final String name;
    @Getter
    private final int qty;

    public ShItem(String name, int qty) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.qty = qty;
    }
}