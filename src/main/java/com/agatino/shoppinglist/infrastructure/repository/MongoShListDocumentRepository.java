package com.agatino.shoppinglist.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.UUID;

// Perfectly named: A Spring Data repository specifically for the Document
interface MongoShListDocumentRepository extends MongoRepository<ShListDocument, UUID> {
}