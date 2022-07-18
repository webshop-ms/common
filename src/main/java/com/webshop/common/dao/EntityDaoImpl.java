package com.webshop.common.dao;

import com.webshop.common.model.model.entity.Identity;
import com.webshop.common.repository.EntityRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class EntityDaoImpl<Entity extends Identity, Repository extends EntityRepository<Entity>>
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

    @Override
    public Entity getByUuid(String uuid) {
        return repository.findByUuid(UUID.fromString(uuid));
    }

    @Override
    public void deleteByUuid(String uuid) {
        repository.deleteByUuid(UUID.fromString(uuid));
    }
}
