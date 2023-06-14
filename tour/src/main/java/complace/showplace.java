package complace;



import java.io.IOException;
import java.io.PrintWriter;
//import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/showplace")
public class showplace extends HttpServlet {
	
	 /*public showplace(){
		  super();// TODO Auto-generated constructor stub
		} {  
	    }*/
	private static final long serialVersionUID = 1L;

protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	
	PrintWriter pw= resp.getWriter();
	
	  try {
		  List<Place>showDetails=PlaceDBUtil.Show();
		  
			  //List<String>showDetails=PlaceDBUtil.Show();
			  request.setAttribute("showDetails", showDetails);
		  //System.out.println(showDetails);
//		  pw.println(PlaceDBUtil.Show());
	  } catch (Exception e) {
			e.printStackTrace();
		}
	
	  RequestDispatcher dis= request.getRequestDispatcher("place.jsp");
	  
			  //request.getRequestDispatcher("place.jsp").forward(request, resp);
	dis.forward(request, resp);
	  
	 
	}

}


