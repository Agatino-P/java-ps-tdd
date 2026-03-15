package com.agatino.shoppinglist.infrastructure.repositories;

import com.agatino.shoppinglist.controllers.ShoppingList.ShListSummaryView;

public interface ShListRepository {
    ShListSummaryView[] getAllSummaries();
}
