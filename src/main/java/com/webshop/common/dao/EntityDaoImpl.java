package com.webshop.common.dao;

import com.webshop.common.model.model.entity.Identity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class EntityDaoImpl<Entity extends Identity, Repository extends CrudRepository<Entity, Long>>
    implements EntityDao<Entity> {

    protected Repository repository;

    public EntityDaoImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Entity getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Entity save(Entity entity) {
        return repository.save(entity);
    }

    @Override
    public List<Entity> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }
}
