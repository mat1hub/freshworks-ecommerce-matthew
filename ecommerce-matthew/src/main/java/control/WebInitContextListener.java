package control;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class WebInitContextListener
 *
 */
@WebListener
public class WebInitContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public WebInitContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("context destroyed...");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	try {
         System.out.println("context initialized....");
         ServletContext application=sce.getServletContext();
         String path=application.getRealPath("/WEB-INF/dbconfig.properties"); 
         String path2=application.getRealPath("/WEB-INF/config.properties");
         Properties p=new Properties();
         p.load(new FileInputStream(path2));
         application.setAttribute("prop",p);
         
         Properties prop=new Properties();
         prop.load(new FileInputStream(path));
         String driver=prop.getProperty("driver");
         //application.setInitParameter("driver", driver);
         Class.forName(driver);
         ConnectionUtility.url=prop.getProperty("url");
         ConnectionUtility.username= prop.getProperty("username");
         ConnectionUtility.password= prop.getProperty("password");
         
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
	
}
