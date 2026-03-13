package com.example.api.repositories;

import com.example.api.controllers.ShoppingList.ShListSummary;
import org.springframework.stereotype.Repository;

@Repository
public interface ShListRepository {
    ShListSummary[] getAllSummaries();
}
