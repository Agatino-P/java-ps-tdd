package com.agatino.shoppinglist.infrastructure.repositories;

import com.agatino.api.controllers.ShoppingList.ShListSummary;

public interface ShListRepository {
    ShListSummary[] getAllSummaries();
}
