/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.Interceptor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entity.Person;
import javax.interceptor.Interceptors;

@Interceptors(Interceptor.class)
public class FindPerson {
    
    
   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "myProject-ejbPU" );
      EntityManager entitymanager = emfactory.createEntityManager();
      Person person = entitymanager.find( Person.class, 1 );

      System.out.println("person ID = " + person.getId());
      System.out.println("person NAME = " + person.getUsername());
      System.out.println("person EMAIL = " + person.getEmail());
            
   }
}