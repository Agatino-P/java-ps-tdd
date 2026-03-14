package com.agatino.api.controllers.ShoppingList;

import java.util.UUID;

public record ShListSummary(UUID uuid, String name, int itemsCount) {
}
