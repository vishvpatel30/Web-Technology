

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Count
 */
@WebServlet("/Count")
public class Count extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Count() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubresponse.setContentType("text/html");
		response.setContentType("text/html");
		System.out.println("Welcome user");
		HttpSession hs = request.getSession(false);
		PrintWriter out =response.getWriter();
		out.println("welcome");
		
		//String total = getServletConfig().getServletContext().getAttribute("total").toString();
		//String current = getServletConfig().getServletContext().getAttribute("current").toString();
		
		if(hs!=null) {
			//String name = hs.getAttribute("name").toString();
			 
			//System.out.println("Welcome"+name+"    total user : "+total+"   current user :"+current);
		
			
			out.print("<a href='Logout' > Logout");
			out.println("<style>\r\n" + 
					"body {\r\n" + 
					"  background-image: url('copy.jpg');\r\n" + 
					"  background-repeat: no-repeat;\r\n" + 
					"  background-attachment: fixed;\r\n" + 
					"  background-size: 100% 100%;\r\n" + 
					"}\r\n" + 
					"</style>");
		}
		else {
			out.print("login first");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
