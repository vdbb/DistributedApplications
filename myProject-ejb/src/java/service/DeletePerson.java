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

public class DeletePerson {
   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "myProject-ejbPU" );
      EntityManager entitymanager = emfactory.createEntityManager( );
      entitymanager.getTransaction().begin();
      
      Person person = entitymanager.find( Person.class, 1 );
      entitymanager.remove( person );
      
      entitymanager.getTransaction().commit();
      entitymanager.close( );
      emfactory.close( );
   }
}