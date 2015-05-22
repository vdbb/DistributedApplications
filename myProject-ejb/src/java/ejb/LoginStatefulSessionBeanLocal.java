/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Stijn
 */
@Local
public interface LoginStatefulSessionBeanLocal {
    
    void setName(String newName);
    
    String getName();
    
    void setEmail(String newEmail);
    
    void setBirthdate(Date newBirthdate);
    
    void login(String name, String password);
    
    void finish();
}
