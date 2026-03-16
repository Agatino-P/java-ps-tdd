package com.agatino.shoppinglist.application.service;

import com.agatino.shoppinglist.controller.ShoppingList.ShListSummaryView;
import com.agatino.shoppinglist.domain.model.ShList;
import com.agatino.shoppinglist.infrastructure.repository.MongoShListRepository;
import org.springframework.stereotype.Service;

@Service
public class ShListService {

    private final MongoShListRepository shListRepository;

    public ShListService(MongoShListRepository shListRepository) {
        this.shListRepository = shListRepository;
    }

    public void save(ShList shList) {
        shListRepository.save(shList);
    }

    public ShListSummaryView[] getAllSummaries() {
        return shListRepository.getAllSummaries();
    }
}
