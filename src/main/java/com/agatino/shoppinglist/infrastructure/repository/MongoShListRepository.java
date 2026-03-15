package com.agatino.shoppinglist.infrastructure.repository;

import com.agatino.shoppinglist.controller.ShoppingList.ShListSummaryView;
import com.agatino.shoppinglist.domain.ShList;
import org.springframework.stereotype.Repository;

@Repository
public class MongoShListRepository implements ShListRepository {

    @Override
    public ShListSummaryView[] getAllSummaries() {
        // TODO: Implement the actual logic to fetch data from MongoDB
        return new ShListSummaryView[0];
    }

    @Override
    public void add(ShList shList) {

    }
}
