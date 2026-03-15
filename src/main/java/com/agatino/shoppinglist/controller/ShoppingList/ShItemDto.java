package com.agatino.shoppinglist.controller.ShoppingList;

import java.util.UUID;

public record ShItemDto(UUID uuid, String name, int qty){}
