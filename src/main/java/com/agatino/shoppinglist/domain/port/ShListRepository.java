package com.agatino.shoppinglist.domain.port;

import com.agatino.shoppinglist.controller.ShoppingList.ShListSummaryView;
import com.agatino.shoppinglist.domain.model.ShList;

public interface ShListRepository {
    void save(ShList shList);
    ShListSummaryView[] getAllSummaries();
}
