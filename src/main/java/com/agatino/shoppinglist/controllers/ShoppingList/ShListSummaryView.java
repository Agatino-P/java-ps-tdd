package com.agatino.shoppinglist.controllers.ShoppingList;

import java.util.UUID;

public record ShListSummaryView(UUID uuid, String name, int itemsCount) {
}

