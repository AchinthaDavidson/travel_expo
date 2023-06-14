package customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.packagemanager.dao.OOP_PackageDao;
import complace.DBConnect;
import sessionHandler.userSessionHandler;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static CustomerDButil cusdb;
	private static OOP_PackageDao DBConObj;
	
	public void init() throws ServletException {	

		cusdb = new CustomerDButil();
		DBConObj = new OOP_PackageDao();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");	
		showPage(request,response);

	}

	//show admin page  int method ---------------------------------------------------------------------------------------------------------
	private void showPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 

		//variables
		int CustomerID = 0;
		String Email = request.getParameter("Email");
		String Password = request.getParameter("Pw");
		PrintWriter out = response.getWriter();
		HttpSession UserSession = request.getSession();

		//getting vlidater details from validater class DBConObj
		int validater = CustomerDButil.validateEmailInt(Email, Password);

		//creating new object from sessionhandler classs
		//userSessionHandler newSessionDetailsObj = new userSessionHandler(); 

		//assiging data into session handle object
		/*
		 * newSessionDetailsObj.setSessionEmail(Email);
		 * newSessionDetailsObj.setSessionID(UserSession.getId());
		 * newSessionDetailsObj.setSessionPass(Password);
		 * userSessionHandler.setSessionCreateTime(UserSession.getCreationTime());
		 * 
		 * System.out.println(newSessionDetailsObj.getSessionCreateTime());
		 * System.out.println(newSessionDetailsObj.getSessionID());
		 */
		
		
		/*	int CustomerID = 0;
		 *	HttpSession UserSession = request.getSession();
		  	try {
				
				CustomerID = DBConObj.GetCustomerID(Email, Password);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			UserSession.setAttribute("CustomerID",CustomerID);

		 * 
		 * */
		if(validater == 10) {

			try {
				
				CustomerID = DBConObj.GetCustomerID(Email, Password);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//setting session attributes

			UserSession.setAttribute("CustomerID",CustomerID);
			UserSession.setAttribute("Email", Email);
			UserSession.setAttribute("Password",Password);
			UserSession.setAttribute("SessionID", UserSession.getId());


			//getting customer id according to details
			//CustomerID = CustomerDButil.userIDReturnMethod(Email, Password);
			//System.out.println(CustomerID);





			//forwarding request
			RequestDispatcher dispatcher = request.getRequestDispatcher("Adminmain.jsp");
			dispatcher.forward(request, response);

		}
		else if (validater == 5)
		{

			try {

				CustomerID = DBConObj.GetCustomerID(Email, Password);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//setting session attributes

			UserSession.setAttribute("CustomerID",CustomerID);
			UserSession.setAttribute("Email", Email);
			UserSession.setAttribute("Password",Password);
			UserSession.setAttribute("SessionID", UserSession.getId());

			//getting customer id according to details
			//CustomerID = CustomerDButil.userIDReturnMethod(Email, Password);
			//	System.out.println(CustomerID);

			//forwarding request
			RequestDispatcher dis4 = request.getRequestDispatcher("home.jsp");
			dis4.forward(request, response);


		} else if (validater == 0) {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Your username or Password is incorrect');");
			out.println("location='Login.jsp'");
			out.println("</script>");
		}

	}
}








