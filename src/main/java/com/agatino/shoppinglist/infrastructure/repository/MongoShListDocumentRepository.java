package com.agatino.shoppinglist.infrastructure.repository;

import com.agatino.shoppinglist.controller.ShoppingList.ShListSummaryView;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

// Perfectly named: A Spring Data repository specifically for the Document
interface MongoShListDocumentRepository extends MongoRepository<ShListDocument, UUID> {
    @Aggregation(pipeline = """
        { 
            $project: { 
                uuid: '$_id', 
                name: 1, 
                itemsCount: { $size: { $ifNull: ['$shItems', []] } } 
            } 
        }
        """)
    List<ShListSummaryView> getAllSummaries();

}