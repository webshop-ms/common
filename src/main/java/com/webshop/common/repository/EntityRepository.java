package com.webshop.common.repository;

import com.webshop.common.model.entity.Identity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EntityRepository<Entity extends Identity> extends CrudRepository<Entity, Long> {

    Entity findByUuid(UUID uuid);

    void deleteByUuid(UUID uuid);

}
