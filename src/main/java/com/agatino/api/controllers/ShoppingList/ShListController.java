package com.agatino.api.controllers.ShoppingList;

import com.agatino.shoppinglist.infrastructure.repositories.ShListRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shlist")
public class ShListController {

    private final ShListRepository repository;

    public ShListController(ShListRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public ShListSummary[] GetAll() {
        return repository.getAllSummaries();
    }
}
