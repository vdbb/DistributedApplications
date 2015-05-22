/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;


import entity.Person;
import java.util.Date;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Stijn
 */
@Stateful
public class LoginStatefulSessionBean implements LoginStatefulSessionBeanLocal, LoginStatefulSessionBeanRemote {

    String name;
    String email;
    Date birthdate;
    
    @Override
    public void setName(String newName) {
        name = newName;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setEmail(String newEmail) {
        email = newEmail;
    }
    
    @Override
    public void setBirthdate(Date newBirthdate) {
        birthdate = newBirthdate;
    }

    @Override
    public void login(String name, String password) {
        
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "FinalAssignment-ejbPU" );
        EntityManager em = emfactory.createEntityManager();
        
        //use entity manager to retrieve named query

        TypedQuery<Person> queryProductsByName = em.createNamedQuery("Person.findByUsername", Person.class);

        //set dynamic data for query

        queryProductsByName.setParameter("username", name);

        //execute query and get results

        List<Person> persons = queryProductsByName.getResultList();
        
        if(persons.isEmpty()){
            System.out.println("This username doens't exist");
        }
        else {
            Person p = persons.get(0);
            if(p.getPassword().equals(password)) {
                setName(p.getUsername());
                setEmail(p.getEmail());
                setBirthdate(p.getBirthdate());
            }
            else {
                System.out.println("Password is incorrect");
            }
        }
        finish();
       
    }
    
    @Remove
    @Override
    public void finish(){
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
