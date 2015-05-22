/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;

/**
 *
 * @author Brecht
 */
@Stateless
public class myBean implements myBeanRemote, myBeanLocal {

    @Override
    public String getRemoteInfo() {
        return "*** REMOTE INFO ***";
    }

    @Override
    public String getLocalInfo() {
        return "*** LOCAL INFO ***";
    }

    
}
