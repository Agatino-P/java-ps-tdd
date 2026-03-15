package com.agatino.shoppinglist.controllers.ShoppingList;

import java.util.UUID;

public record ShListDto(UUID uuid, String name, ShItemDto[] items){}
