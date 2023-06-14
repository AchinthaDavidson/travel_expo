package customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.packagemanager.dao.OOP_PackageDao;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static CustomerDButil cusdb;
	private static OOP_PackageDao DBConObj;
	
	public void init() throws ServletException {	

		cusdb = new CustomerDButil();
		DBConObj = new OOP_PackageDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("Name");
		String email = request.getParameter("Email");
		String telephone = request.getParameter("Mobile");
		String pw = request.getParameter("psw");
		int CustomerID = 0;
		HttpSession UserSession = request.getSession();
		
		 	
		  	try {
				
				CustomerID = DBConObj.GetCustomerID(email,pw);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			UserSession.setAttribute("CustomerID",CustomerID);

		boolean isTrue;
		
		isTrue = CustomerDButil.InsertCustomer(name, email, telephone, pw);
		
		if(isTrue == true) {
			
			List <Customer> cusDetails = CustomerDButil.getCustomer(email);
			request.setAttribute("cusDetails", cusDetails);
			//System.out.println(email);
			
			try {

				CustomerID = DBConObj.GetCustomerID(email, pw);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//setting session attributes

			//UserSession.setAttribute("CustomerID",CustomerID);
			UserSession.setAttribute("Email", email);
			UserSession.setAttribute("Password",pw);
			UserSession.setAttribute("SessionID", UserSession.getId());
			
			
			
			RequestDispatcher dis2 = request.getRequestDispatcher("home.jsp");
			dis2.forward(request, response);
			
			/*RequestDispatcher dis = request.getRequestDispatcher("profile.jsp");
			dis.forward(request, response);*/
		
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("register.jsp");
			dis2.forward(request, response);
		}
	}
}
