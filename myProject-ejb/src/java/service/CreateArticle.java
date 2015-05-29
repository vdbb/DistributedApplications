/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entity.Racket;
import enums.RacketVendor;

public class CreateArticle {

   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "myProject-ejbPU" );
      EntityManager entitymanager = emfactory.createEntityManager( );
      entitymanager.getTransaction().begin();

      
      Racket racket = new Racket(RacketVendor.Adidas, 5.50, 10.60, 100, "My first racket");
      entitymanager.persist( racket );

      
      entitymanager.getTransaction().commit();
      entitymanager.close( );
      emfactory.close( );
   }
}