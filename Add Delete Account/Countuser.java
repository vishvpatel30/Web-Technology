	

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Countuser
 *
 */
@WebListener
public class Countuser implements HttpSessionListener {

    /**
     * Default constructor. 
     */
	static int total=0;
	static int current=0;
    public Countuser() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
		// TODO Auto-generated method stub
    	total++;
    	current++;
    	se.getSession().getServletContext().setAttribute("total", total);
    	se.getSession().getServletContext().setAttribute("current", current);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	current--;
    	se.getSession().getServletContext().setAttribute("current", current);
    }
	
}
