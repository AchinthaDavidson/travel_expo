package customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.packagemanager.dao.OOP_PackageDao;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CustomerDButil cusdb;
	private static OOP_PackageDao DBConObj;
	
	public void init() throws ServletException {	

		cusdb = new CustomerDButil();
		DBConObj = new OOP_PackageDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession UserSession = request.getSession(); 
		int id = (Integer)UserSession.getAttribute("CustomerID"); 
		
		//System.out.println("my id is " + id);
		
		
		  boolean isTrue;
		  
		  isTrue = CustomerDButil.Deletecustomer(id);
		  
		  if(isTrue == true) {
			  
			  UserSession.invalidate();
			  RequestDispatcher dis = request.getRequestDispatcher("register.jsp");
			  dis.forward(request, response); 
		  
		  } else { 
			 
		List<Customer> cusDetails = CustomerDButil.getCustomerDetails(id); request.setAttribute("cusDetails",cusDetails);
		  
		
		  
		  RequestDispatcher dis2 = request.getRequestDispatcher("profile.jsp");
		  dis2.forward(request, response); 
		  }
		 
	}

}
