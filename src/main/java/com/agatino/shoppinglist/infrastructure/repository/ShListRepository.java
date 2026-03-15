package com.agatino.shoppinglist.infrastructure.repository;

import com.agatino.shoppinglist.controller.ShoppingList.ShListSummaryView;
import com.agatino.shoppinglist.domain.ShList;

public interface ShListRepository {
    ShListSummaryView[] getAllSummaries();
    void add(ShList shList);
}
