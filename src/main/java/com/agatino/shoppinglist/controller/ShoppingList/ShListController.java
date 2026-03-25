package com.agatino.shoppinglist.controller.ShoppingList;

import com.agatino.shoppinglist.application.service.ShListService;
import com.agatino.shoppinglist.domain.model.ShItem;
import com.agatino.shoppinglist.domain.model.ShList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/shlist")
public class ShListController {

    private final ShListService shListService;

    public ShListController(ShListService shListService) {
        this.shListService = shListService;
    }

    @GetMapping()
    public List<ShListSummaryView> getAll() {
        return shListService.getAllSummaries();
    }
    
    @PostMapping("")
    public ResponseEntity<Void> post(@RequestBody CreateShListDto shListDto) {

        shListService.save(toShList(shListDto));
        return ResponseEntity.noContent().build();
    }

    //in a better future, we'll use vavr to handle mapping errors
    private static ShList toShList(CreateShListDto shListDto) {
        var shItems= Arrays.stream(shListDto.items())
                .map(ShListController::toShItem)
                .toList();
        return new ShList(shListDto.name(),shItems);
    }

    private static ShItem toShItem(ShItemDto shItemDto)   {
        return new ShItem(shItemDto.name(),shItemDto.qty());
    }
}
