package com.webshop.common.service;

import com.webshop.common.model.model.entity.Identity;

import java.util.List;

public interface EntityService<Entity extends Identity> {

    Entity getById(Long id);

    void deleteById(Long id);

    Entity save(Entity entity);

    List<Entity> getAll();

}