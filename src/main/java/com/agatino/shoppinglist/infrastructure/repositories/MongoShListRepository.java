package com.agatino.shoppinglist.infrastructure.repositories;

import com.agatino.api.controllers.ShoppingList.ShListSummary;
import org.springframework.stereotype.Repository;

@Repository
public class MongoShListRepository implements ShListRepository {

    @Override
    public ShListSummary[] getAllSummaries() {
        // TODO: Implement the actual logic to fetch data from MongoDB
        return new ShListSummary[0];
    }
}
