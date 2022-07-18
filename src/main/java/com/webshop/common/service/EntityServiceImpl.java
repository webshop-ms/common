package com.webshop.common.service;

import com.webshop.common.dao.EntityDao;
import com.webshop.common.model.model.entity.Identity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class EntityServiceImpl<Entity extends Identity, Dao extends EntityDao<Entity>> implements EntityService<Entity> {

    protected Dao dao;

    public EntityServiceImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public Entity getById(Long id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Override
    public Entity save(Entity entity) {
        return dao.save(entity);
    }

    @Override
    public List<Entity> getAll() {
        return StreamSupport.stream(dao.getAll().spliterator(), false)
            .collect(Collectors.toList());
    }

}