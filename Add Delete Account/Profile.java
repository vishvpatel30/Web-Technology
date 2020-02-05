

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
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
			System.out.print("hi");
			//Statement st = cn.createStatement();
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			//String phone = ;
			String id = request.getParameter("uname");
			String pwd = request.getParameter("pwd");
			
			String query=("insert into profile values (?,?,?,?,?)");
			
			PreparedStatement pst=cn.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setInt(3, Integer.valueOf(request.getParameter("phone")));
			pst.setString(4, id);
			pst.setString(5, pwd);
			
			pst.executeUpdate(); 
			pst.close(); 
			cn.close(); 
			  
			out.println("<html><body> <center><b> Account Created Successfully"
					+ "<center></b></body></html>"); 
			if(query!=null) {
			HttpSession hs = request.getSession(true);
			hs.setAttribute("name", name);
			hs.setAttribute("pwd", pwd);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Count");
			rd.forward(request, response);
			rd.include(request, response);
			response.sendRedirect("Count");
			}
			
			
			//ResultSet rs = st.executeQuery("INSERT INTO `example`.`profile` (`name`, `email`,`phone`,`id`,`pwd`) VALUES ('name', 'email','phone','id','pwd');");
			/*while(rs.next()) {
				out.println("Login Successfull :  "+rs.getString("name"));
			}*/
			
			
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		catch(Exception se){
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
