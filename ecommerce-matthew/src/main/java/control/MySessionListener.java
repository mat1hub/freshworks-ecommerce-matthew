package control;

import java.sql.Connection;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import dao.customer.CustomerDAO;
import service.CustomerService;
import service.CustomerServiceImpl;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
@WebListener
public class MySessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se)  { 
         System.out.println("session created....");
         HttpSession session=se.getSession();
 		session.setMaxInactiveInterval(6000);
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
         System.out.println("session destroyed....");
         HttpSession session=se.getSession();
         Object o=session.getAttribute("uname");
         if(o!=null) {
        	 String uname=o.toString();
        	 
        	 CustomerService cs=CustomerServiceImpl.getServiceImpl();
        	 cs.updateFlag(0, uname);
         }
    }
	
}
