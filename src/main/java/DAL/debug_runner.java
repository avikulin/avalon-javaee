package DAL;

import DAL.DataEntities.Dictionaries.Country;
import DAL.DataEntities.Registers.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class debug_runner {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityTransaction tx;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("lab1");
        em = emf.createEntityManager();
        tx = em.getTransaction();

        if (em != null) em.close();
        if (emf != null) emf.close();
    }
}
