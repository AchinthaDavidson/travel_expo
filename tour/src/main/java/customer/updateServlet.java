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


@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CustomerDButil cusdb;
	private static OOP_PackageDao DBConObj;
	
	public void init() throws ServletException {	

		cusdb = new CustomerDButil();
		DBConObj = new OOP_PackageDao();
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String id = request.getParameter("cusid"); String name =
		  request.getParameter("name"); String email = request.getParameter("Email");
		  String phone = request.getParameter("mobile"); String pw =
		  request.getParameter("password");
		 
		
		//System.out.println("All strings in update servlet " + id + name + email + phone + pw);
		
		HttpSession UserSession = request.getSession(); 
		String  email1 = (String)UserSession.getAttribute("Email"); 
		//System.out.println("th email in update servlet session" + email1);
		
	
		boolean isTrue;
	
		isTrue = CustomerDButil.Updatecustomer(id, name, email, phone, pw);
		
		if(isTrue == true) {
			
			List<Customer> cusDetails = CustomerDButil.getCustomer(email);
			request.setAttribute("cusDetails", cusDetails);

			RequestDispatcher dis = request.getRequestDispatcher("profile.jsp");
			dis.forward(request, response);
			//System.out.println("updated");
				
		}
		else {
			
			List<Customer> cusDetails = CustomerDButil.getCustomer(email);
			request.setAttribute("cusDetails", cusDetails);
			
			RequestDispatcher dis2 = request.getRequestDispatcher("profile.jsp");
			dis2.forward(request, response);
		//	System.out.println(" not updated");
		}
		
	}

}
