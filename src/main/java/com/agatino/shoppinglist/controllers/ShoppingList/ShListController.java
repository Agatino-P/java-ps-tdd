package com.agatino.shoppinglist.controllers.ShoppingList;

import com.agatino.shoppinglist.infrastructure.repositories.ShListRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shlist")
public class ShListController {

    private final ShListRepository repository;

    public ShListController(ShListRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public ShListSummaryView[] getAll() {
        return repository.getAllSummaries();
    }
    
    @PostMapping("")
    public ResponseEntity<Void> post(@RequestBody String value) {
        return ResponseEntity.noContent().build();
    }
}
