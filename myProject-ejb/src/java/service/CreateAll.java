package service;

import entity.Person;
import entity.Purchase;
import entity.Racket;
import entity.Shoe;
import entity.Tennisball;
import enums.BallType;
import enums.RacketVendor;
import enums.ShoeBrand;
import enums.TerrainType;
import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateAll {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myProject-ejbPU");
        EntityManager em = emf.createEntityManager();

        Person p = new Person("name", "password", "email", new Date(2015, 1, 1));
        Purchase purchase1 = new Purchase(LocalDate.now());
        Purchase purchase2 = new Purchase(LocalDate.now());
        Racket r1 = new Racket(RacketVendor.Adidas, 5.50, 10.60, 100, "My first racket");
        Racket r2 = new Racket(RacketVendor.Dunlop, 7, 2, 50, "My second racket");
        Tennisball t = new Tennisball(2, BallType.Gasfilled, 1, "Normal ball");
        Shoe s = new Shoe(ShoeBrand.Diadora, 45, TerrainType.Gravel, Color.BLACK, 75, "New shoes!");

        purchase1.addArticle(t);
        purchase1.addArticle(r1);
        purchase2.addArticle(r2);

        p.addPurchase(purchase2);
        p.addPurchase(purchase1);
        
        try {
            em.getTransaction().begin();

            em.persist(r1);
            em.persist(r2);
            em.persist(t);
            em.persist(s);
            
            em.persist(purchase1);
            em.persist(purchase2);
            
            em.persist(p);

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("exception");
            System.out.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }

}
