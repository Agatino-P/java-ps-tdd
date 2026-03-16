package com.agatino.shoppinglist.infrastructure.repository;

import java.util.List;
import java.util.UUID;

public record ShListEntity(UUID id, String name, List<ShListDocument> items) {
}
