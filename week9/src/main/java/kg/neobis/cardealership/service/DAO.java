package kg.neobis.cardealership.service;

import kg.neobis.cardealership.exception.EntityNotFoundException;

import java.util.List;

public interface DAO<Entity, Model, key> {
    List<Model> entityListToModelList(Iterable<Entity> entities);
    List<Model> getAll();
    Model getById(key id) throws EntityNotFoundException;
    void add(Entity entity);
    Entity update(Model model, key id) throws EntityNotFoundException;
    key delete(key id) throws EntityNotFoundException;
}
