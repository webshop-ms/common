package com.webshop.common.dao;

import com.webshop.common.model.entity.Identity;

import java.util.List;

public interface EntityDao<Entity extends Identity> {

    Entity getById(Long id);

    void deleteById(Long id);

    Entity save(Entity entity);

    List<Entity> getAll();

    Entity getByUuid(String uuid);

    void deleteByUuid(String uuid);
}
