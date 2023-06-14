package com.packagemanager.web;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.packagemanager.bean.OOP_Package;
import com.packagemanager.dao.OOP_PackageDao;


/**
 * Servlet implementation class OOP_PackageServlet
 */
@WebServlet("/")
public class OOP_PackageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private OOP_PackageDao packageDaoObj;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {	
		packageDaoObj = new OOP_PackageDao();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String action = request.getServletPath();

		//main switch for all actions
		switch(action) {

		//new user case
		case "/new":

			showNewForm(request,response);

			break;

			//insert case
		case "/insert":

			try {

				
				insertPackage(request,response);
				//updateCost(request,response);

			}catch(SQLException e) {

				System.out.println(e);
			}

			break;

			//delete case
		case "/delete":

			try {

				deletePackage(request,response);
			//	listPackage(request,response);
			//	listPackagewithcostupdater(request,response);

			}catch(SQLException e) {

				System.out.println(e);
			}	

			break;	

			//edit case
		case "/edit":

			try {

				showEditor(request,response);

			}catch(SQLException e) {

				System.out.println(e);
			}	

			break;	


			//update case
		case "/update":

			try {
				updatePackage(request,response);

			}catch(SQLException e) {

				System.out.println(e);
			}	

			break;
			
		case "/logout":

			try {
				logoutmethod(request,response);

			}catch(Exception e) {

				System.out.println(e);
			}	

			break;
			
		case "/backtohomemethod":

			try {
				
				backtohomemethod(request,response);

			}catch(Exception e) {

				System.out.println(e);
			}	

			break;


		case "/list":

			try {
				
				listPackagewithcostupdater(request,response);

				//listPackage(request,response);
				//updateCost(request,response);

			}catch(SQLException e) {

				System.out.println(e);
			}			

			break;


		case "/showpackage":

			try {
				
				listPackagewithcostupdater(request,response);

			//	listPackage(request,response);
			//	updateCost(request,response);

			}catch(SQLException e) {

				System.out.println(e);
			}			

			break;


			//handles deafult like home


		default:
			try {


				showHomePage(request,response);

			}catch(Exception e) {

				System.out.println(e);
			}	


			break;

		}//end of switch

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	//show new form  methods ---------------------------------------------------------------------------------------------------------
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 

		RequestDispatcher dispatcher = request.getRequestDispatcher("package-insert.jsp");
		dispatcher.forward(request, response);
	}


	//logout  methods ---------------------------------------------------------------------------------------------------------
	private void logoutmethod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 

		HttpSession UserSession = request.getSession(); 

		UserSession.invalidate();
		RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");	
		dispatcher.forward(request, response);
	}

	//back to home methods ---------------------------------------------------------------------------------------------------------
	private void backtohomemethod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 


		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");	
		dispatcher.forward(request, response);
	}

		
	//show new form  methods ---------------------------------------------------------------------------------------------------------
	private void showHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 

		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}


	//insert user method ------------------------------------------------------------------------------------------------------
	private void insertPackage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{

		String name = request.getParameter("name");
		String locations = request.getParameter("locations");	
		OOP_Package pkg = new OOP_Package(name,locations);

		HttpSession UserSession = request.getSession(); 
		String Email = (String) UserSession.getAttribute("Email"); 
		String Password = (String)UserSession.getAttribute("Password");

		int customerID = packageDaoObj.GetCustomerID(Email,Password);
		int packageID =  packageDaoObj.insertPackageMethod2(pkg,name,locations);

		packageDaoObj.updateCusPakTable(customerID ,packageID);

		response.sendRedirect("list");

		return;	 

	}

	//delete user method-------------------------------------------------------------------

	private void deletePackage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{

		int id = Integer.parseInt(request.getParameter("id"));

		try {
			
			packageDaoObj.deletePackage(id);

		}catch(Exception e) {
			e.printStackTrace();
		}

		  response.sendRedirect("list");
	}


	//edit package method --------------------------------------------------------------------------------------------------

private void showEditor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{

		int id = Integer.parseInt(request.getParameter("id"));
				
		OOP_Package currentpkg;

		try {
			
	
			currentpkg = packageDaoObj.selectPackage(id);		
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("package-update.jsp");
			//RequestDispatcher dispatcher = request.getRequestDispatcher("package-form.jsp");
			
	
			request.setAttribute("currentPackage",currentpkg);
			dispatcher.forward(request,response);

		}catch(Exception e) {

			e.printStackTrace();
		}

	}
	



	//update package method -----------------------------------------------------------------------------------------------------------

	private void updatePackage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{

		try {

			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String locations = request.getParameter("locations");
			
			System.out.println("This is packge id in servlrt update methods  " + id);
			System.out.println("This is packge name in servlrt update methods" +  name );
			System.out.println("This is packge locations in servlrt update methods" + locations);
		

			OOP_Package pkg = new OOP_Package(id,name,locations);
			
			packageDaoObj.updatePackage(pkg);
			response.sendRedirect("list");		
		}
		catch(Exception e) {	
			
			e.printStackTrace();
		}		
	}

	
	//selectAllPackagesAccordingToCustomerWithCostUpdater
	
	private void listPackagewithcostupdater(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{

		try {


			HttpSession UserSession = request.getSession(); String Email = (String)
					UserSession.getAttribute("Email"); String Password = (String)
					UserSession.getAttribute("Password");


					//List <OOP_Package> listPackage =  packageDaoObj.selectAllPackages();  

					List <OOP_Package> listPackage =  packageDaoObj.selectAllPackagesAccordingToCustomerWithCostUpdater(Email,Password);
					  
					for(OOP_Package pkg:listPackage) {
	                        
	                        pkg.detailsPrinter();
	                        
	                    }
					request.setAttribute("listPackage", listPackage);
					
				//	request.getRequestDispatcher("package-list.jsp");
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("package-list.jsp");
					dispatcher.forward(request, response);

		}catch(Exception e) {

			e.printStackTrace();
		}
	}


}    
