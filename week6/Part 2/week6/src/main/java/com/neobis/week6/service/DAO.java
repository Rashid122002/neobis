package com.neobis.week6.service;

import java.util.List;

public interface DAO<Entity, Model, key> {
    List<Model> entityListToModelList(Iterable<Entity> entities);
    List<Model> getAll();
    Model getById(key id);
    void add(Entity entity);
    Entity update(Model model, key id);
    Long delete(key id);
}
