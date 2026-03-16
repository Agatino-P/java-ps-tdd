package com.agatino.shoppinglist.domain.port;

import java.util.UUID;

public interface IdProvider {
    UUID getNewTimeOrderedId();
}