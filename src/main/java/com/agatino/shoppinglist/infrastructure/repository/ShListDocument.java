package com.agatino.shoppinglist.infrastructure.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.UUID;

@Document("sh_lists")
record ShListDocument(


        @Id UUID id,
        String name,
        List<ShItemDocument> shItems
) {}