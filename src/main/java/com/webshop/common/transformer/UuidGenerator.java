package com.webshop.common.transformer;

import org.hibernate.Session;
import org.hibernate.tuple.ValueGenerator;

import java.util.UUID;

public class UuidGenerator implements ValueGenerator<UUID> {
    @Override
    public UUID generateValue(Session session, Object o) {
        return UUID.randomUUID();
    }
}
