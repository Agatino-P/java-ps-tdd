package com.agatino.shoppinglist.infrastructure.repository;
import com.agatino.shoppinglist.controller.ShoppingList.ShListSummaryView;
import com.agatino.shoppinglist.domain.model.ShItem;
import com.agatino.shoppinglist.domain.model.ShList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MongoShListRepository  {

    private final MongoShListDocumentRepository documentRepository;

    public void save(ShList shList) {
        ShListDocument document = toShListDocument( shList);
        documentRepository.save(document);
    }

    public ShListSummaryView[] getAllSummaries() {
        return new ShListSummaryView[0];
    }

    private ShItemDocument toShItemDocuments(ShItem shItem){
        return new ShItemDocument(shItem.getId(), shItem.getName());
    }

    private ShListDocument toShListDocument(ShList shList){
        List<ShItemDocument> shItemDocuments=shList.getItems().stream().map(this::toShItemDocuments).toList();
        return new ShListDocument(shList.getId(), shList.getName(),shItemDocuments);
    }

}
