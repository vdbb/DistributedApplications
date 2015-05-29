/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.ScheduleExpression;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

/**
 *
 * @author Stijn
 */
@Stateless
@LocalBean
public class TimerBean {
    
    @Resource
    TimerService ts;
    Timer timer;

    public void startMyTimer() {
        
        //Every hour, every minute, every second
        ScheduleExpression se = new ScheduleExpression().hour("*").minute("*").second("*/10");
        timer = ts.createCalendarTimer(se);
        
    }
    
    @Timeout
    public void myProgTimerMethod() {
        System.out.println("Programmatic Timeout !");
    }
    
    public void cancelMyTimers() {
        for(Object obj: ts.getTimers()) {
            Timer t = (Timer)obj;
            t.cancel();
            System.out.println("Timer cancelled");
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
