

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Loggedin
 */
@WebServlet("/Loggedin")
public class Loggedin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loggedin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		System.out.println("Welcome user");
		HttpSession hs = request.getSession(false);
		PrintWriter out =response.getWriter();
		
		//String total = getServletConfig().getServletContext().getAttribute("total").toString();
		//String current = getServletConfig().getServletContext().getAttribute("current").toString();
		
		if(hs != null) {
			String uname = hs.getAttribute("uname").toString();
			
			out.println("<br>");
			out.println("Welcome"+uname);
			out.println("<br>");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "root", "root");
				if(cn!=null){
					System.out.println("Connection Established Successfully  1 ");
				}
				else
					System.out.println("Connection Error   1 ");
				
				Random rand=new Random();
				Statement st = cn.createStatement();
				int a=rand.nextInt(5);
				System.out.println("a :"+a);
				ResultSet rs= st.executeQuery("select * from question where qt='"+a+"'");
				while(rs.next()) {
					out.println("Your question is :");
					out.println(rs.getString("quest"));
				}
				
			}
			catch(Exception io) {
				System.out.println("data error");
			}
			out.print("<br>");
			out.print("<a href='Logout' > Logout");
		}
		else {
			out.print("login first");
			request.getRequestDispatcher("login.html").include(request,response);
		}
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
