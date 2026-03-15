package com.agatino.shoppinglist.controller.ShoppingList;

import java.util.UUID;

public record ShListSummaryView(UUID uuid, String name, int itemsCount) {
}

