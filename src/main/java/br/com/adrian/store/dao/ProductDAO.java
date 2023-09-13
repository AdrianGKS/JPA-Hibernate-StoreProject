package br.com.adrian.store.dao;

import br.com.adrian.store.model.Category;
import br.com.adrian.store.model.Product;
import br.com.adrian.store.tests.ProductRegistration;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductDAO {

    private EntityManager manager;

    public ProductDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void register(Product product) {
        this.manager.persist(product);
    }

    public void update(Product product) {
        this.manager.merge(product);
    }

    public void remove(Product product) {
        product = manager.merge(product);
        this.manager.remove(product);
    }

    public Product findById(Long id) {
        return manager.find(Product.class, id);
    }

    public List<Product> findAll() {
        String jpql = "select p from Product p";
        return manager.createQuery(jpql, Product.class).getResultList();
    }

    public List<Product> findByName(String name) {
        String jpql=  "select p from Product p where p.name = ?1";
        return manager.createQuery(jpql, Product.class)
                .setParameter(1, name)
                .getResultList();
    }

    public List<Product> findByCategoryName(String name) {
        String jpql=  "select p from Product p where p.category.name = ?1";
        return manager.createQuery(jpql, Product.class)
                .setParameter(1, name)
                .getResultList();
    }

    public BigDecimal findPriceByName(String name) {
        String jpql = "select p.price from Product p where p.name = ?1";
        return manager.createQuery(jpql, BigDecimal.class)
                .setParameter(1, name)
                .getSingleResult();
    }
}
