package com.agatino.shoppinglist.controllers.ShoppingList;

import java.util.UUID;

public record ShListDto(UUID uuid, String name, ShItemDto[] items) {
    public ShListDto(String name) {
        this(UUID.randomUUID(), name, new ShItemDto[0]);
    }
}