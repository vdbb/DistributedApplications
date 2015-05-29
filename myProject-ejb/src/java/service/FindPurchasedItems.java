/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Article;
import entity.Person;
import entity.Purchase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Brecht
 */
public class FindPurchasedItems {

   public static void main( String[ ] args ) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myProject-ejbPU");
        EntityManager em = emf.createEntityManager();

        Person person = em.find( Person.class, 7 );

        System.out.println("person ID = " + person.getId());
        System.out.println("person NAME = " + person.getUsername());
        System.out.println("person EMAIL = " + person.getEmail());

        for(Purchase p: person.getPurchases()){
            System.out.println("Purchase_id: "+p.getId());
            for(Article a: p.getArticles()){
                System.out.println(a.toString());
            }
        }
     
      
      
    }
    
}
