

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Firstpage
 */
@WebServlet("/Firstpage")
public class Firstpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Firstpage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "root", "root");
			if(cn!=null){
				System.out.println("Connection Established Successfully");
			}
			else
				System.out.println("Connection Error");
			System.out.println("hi");
			String currpwd=null;
			Statement st = cn.createStatement();
			String uname = request.getParameter("uname");
			String pwd = request.getParameter("pwd");
			ResultSet rs = st.executeQuery("select * from profile where name='"+uname+"' and pwd='"+pwd+"'");
			while(rs.next()) {
				System.out.println("user :"+rs.getString("name")+"\tpassword :"+rs.getString("pwd"));
				currpwd=rs.getString("pwd");
				out.println("Login Successfull :  "+rs.getString("name"));
				out.println("<br>");
			}
			out.println("<center>Delete Account: <a href='Delete'>"
					+"<input type='submit' value='Delete'>"
					+ "</a></center> " );
			HttpSession hs = request.getSession(true);
			hs.setAttribute("uname", uname);
			hs.setAttribute("pwd", pwd);
			/*if(pwd.equals(currpwd)) {
				
				HttpSession hs = request.getSession(true);
				hs.setAttribute("uname", uname);
				hs.setAttribute("pwd", pwd);
				
				RequestDispatcher rd = request.getRequestDispatcher("/Loggedin");
				rd.include(request, response);
				//response.sendRedirect("Loggedin");
			}
			else {
				System.out.println(" wrong password or username login error");
				out.println("<center>Retry at: <a href='login.html'>"
						+"<input type='submit' value='LogIn'>"
						+ "</a></center> " );
			}*/
			
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		}
		catch(Exception io){
			System.out.println("error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
