package com.agatino.shoppinglist.infrastructure.repositories;

import com.agatino.shoppinglist.controllers.ShoppingList.ShListSummaryView;
import org.springframework.stereotype.Repository;

@Repository
public class MongoShListRepository implements ShListRepository {

    @Override
    public ShListSummaryView[] getAllSummaries() {
        // TODO: Implement the actual logic to fetch data from MongoDB
        return new ShListSummaryView[0];
    }
}
