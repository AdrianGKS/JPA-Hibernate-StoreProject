package br.com.adrian.store.dao;

import br.com.adrian.store.model.Category;
import br.com.adrian.store.model.Product;

import javax.persistence.EntityManager;

public class CategoryDAO {

    private EntityManager manager;

    public CategoryDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void register(Category category) {
        this.manager.persist(category);
    }

    public void update(Category category) {
        this.manager.merge(category);
    }

    public void remove(Category category) {
        category = manager.merge(category);
        this.manager.remove(category);
    }
}
