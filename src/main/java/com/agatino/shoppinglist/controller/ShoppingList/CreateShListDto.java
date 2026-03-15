package com.agatino.shoppinglist.controller.ShoppingList;

public record CreateShListDto(String name, ShItemDto[] items) {
    public CreateShListDto(String name) {
        this(name, new ShItemDto[0]);
    }
}