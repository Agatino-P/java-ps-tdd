package com.agatino.shoppinglist.infrastructure.identity;

import com.agatino.shoppinglist.domain.port.IdProvider;
import com.github.f4b6a3.uuid.UuidCreator;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class UuidCreatorIdProvider implements IdProvider {
    @Override
    public UUID getNewTimeOrderedId() {
        return UuidCreator.getTimeOrderedEpoch();
    }
}