package customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/homeservlet")
public class homeservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		  HttpSession UserSession = request.getSession(); 
		  String Email = (String) UserSession.getAttribute("Email"); 
		 
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		List<Customer> cusdet = CustomerDButil.dicustomerdetails(Email);
		
		if(cusdet != null){
			
			List<Customer> cusdet1 = CustomerDButil.dicustomerdetails(Email);
			request.setAttribute("cusDetails", cusdet1);
		//	System.out.println(cusdet1);
			RequestDispatcher dis2 = request.getRequestDispatcher("profile.jsp");
			dis2.forward(request, response);

		}
		else {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('data is not passed');");
			out.println("location='home.jsp'");
			out.println("</script>");
		}
		
	}
}
