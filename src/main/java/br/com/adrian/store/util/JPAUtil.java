package br.com.adrian.store.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("store");

    public static EntityManager getManager() {
        return FACTORY.createEntityManager();
    }

}
