package br.com.adrian.store.tests;

import br.com.adrian.store.dao.CategoryDAO;
import br.com.adrian.store.dao.ProductDAO;
import br.com.adrian.store.model.Category;
import br.com.adrian.store.model.Product;
import br.com.adrian.store.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductRegistration {
    public static void main(String[] args) {

        //registerProduct();

        EntityManager manager = JPAUtil.getManager();
        ProductDAO productDAO = new ProductDAO(manager);

        Product p = productDAO.findById(1L);
        System.out.println(p.getPrice());

        List<Product> list = productDAO.findByName("TV Samsung");
        list.forEach(l -> System.out.println(l.getName()));

        BigDecimal price = productDAO.findPriceByName("iPhone 13");
        System.out.println(price);
    }

    private static void registerProduct() {
        Category category = new Category("FOOD");
        Product product = new Product(
                "Forno", "Forno Elétrico",
                new BigDecimal("800"), category);

        EntityManager manager = JPAUtil.getManager();
        ProductDAO productDAO = new ProductDAO(manager);
        CategoryDAO categoryDAO = new CategoryDAO(manager);

        manager.getTransaction().begin();
        categoryDAO.register(category);
        productDAO.register(product);

        manager.getTransaction().commit();
        manager.close();
    }
}
