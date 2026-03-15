package com.agatino.shoppinglist.controllers.ShoppingList;

import java.util.UUID;

public record ShItemDto(UUID uuid, String name, int qty){}
