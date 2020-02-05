

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "root", "root");
		if(cn!=null){
			System.out.println("Connection Established Successfully   2");
		}
		else
			System.out.println("Connection Error   2 ");
		Statement st = cn.createStatement();
		
		System.out.println("Welcome user");
		HttpSession hs = request.getSession(false);
		PrintWriter out =response.getWriter();
		
		out.println("<style>\r\n" + 
				"body {\r\n" + 
				"  background-image: url('copy.jpg');\r\n" + 
				"  background-repeat: no-repeat;\r\n" + 
				"  background-attachment: fixed;\r\n" + 
				"  background-size: 100% 100%;\r\n" + 
				"}\r\n" + 
				"</style>");
		
				
		if(hs!=null) {
			System.out.println("Done");
			String name=hs.getAttribute("uname").toString();
			String pwd=hs.getAttribute("pwd").toString();

			ResultSet rs = st.executeQuery("select * from profile where name='"+name+"' and pwd='"+pwd+"'");
			while(rs.next()){
				
				PreparedStatement pst = cn.prepareStatement("delete from profile where name =?");
				pst.setString(1,name);
				pst.executeUpdate();
				pst.close();
				
      	          out.println("<center>"+name+" User Data deleted successfully </center>");
            }
			 cn.close();
   	      
	            
	          out.println("\"<center>Retry at: <a href='index.html'>\"\r\n" + 
	          								"<input type='submit' value='LogIn'>" + 
	          								"</a></center>");
			
		}
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		}
		catch(Exception io) {
			System.out.println("error 2");
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
