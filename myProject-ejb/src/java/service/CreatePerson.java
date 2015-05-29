/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entity.Person;
import java.time.LocalDateTime;
import java.util.Date;

public class CreatePerson {

   public static void main( String[ ] args ) {
   
       
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "myProject-ejbPU" );
      
      EntityManager entitymanager = emfactory.createEntityManager( );
      entitymanager.getTransaction().begin();

      Person person = new Person( ); 
      person.setId(1);
      person.setUsername("username" );
      person.setPassword("password");
      person.setEmail("e@ma.il" );
      person.setBirthdate(LocalDateTime.of(1950, 2, 3, 13, 30));
      
      entitymanager.persist( person );

      entitymanager.getTransaction().commit();
      entitymanager.close( );
      emfactory.close( );
   }
}