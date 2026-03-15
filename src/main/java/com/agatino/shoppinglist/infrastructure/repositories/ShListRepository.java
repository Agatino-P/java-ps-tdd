package com.agatino.api.repositories;

import com.agatino.api.controllers.ShoppingList.ShListSummary;
import org.springframework.stereotype.Repository;

@Repository
public interface ShListRepository {
    ShListSummary[] getAllSummaries();
}
