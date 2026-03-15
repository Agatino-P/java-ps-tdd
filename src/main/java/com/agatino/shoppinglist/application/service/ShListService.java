package com.agatino.shoppinglist.application.service;

import com.agatino.shoppinglist.controller.ShoppingList.ShListSummaryView;
import com.agatino.shoppinglist.domain.ShList;
import com.agatino.shoppinglist.infrastructure.repository.ShListRepository;
import org.springframework.stereotype.Service;

@Service
public class ShListService {

    private final ShListRepository shListRepository;

    public ShListService(ShListRepository shListRepository) {
        this.shListRepository = shListRepository;
    }

    public void add(ShList shList) {
        shListRepository.add(shList);
    }

    public ShListSummaryView[] getAllSummaries() {
        return shListRepository.getAllSummaries();
    }
}
