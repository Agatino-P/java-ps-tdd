package com.agatino.shoppinglist.infrastructure.repository;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.UUID;

record ShItemDocument(
        @Field("id") UUID id,
        String name) {
}

