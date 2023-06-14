package comguide;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import complace.Place;
import complace.PlaceDBUtil;


@WebServlet("/Showguide")
public class Showguide extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw= response.getWriter();
		
		  try {
			  List<guide>showDetails=guideDBUtil.Show();
			  
				  //List<String>showDetails=PlaceDBUtil.Show();
				  request.setAttribute("showDetails", showDetails);
			  //System.out.println(showDetails);
//			  pw.println(PlaceDBUtil.Show());
		  } catch (Exception e) {
				e.printStackTrace();
			}
		
		  RequestDispatcher dis= request.getRequestDispatcher("showGuide.jsp");
		  
				  //request.getRequestDispatcher("place.jsp").forward(request, resp);
		dis.forward(request, response);
		  
	}

}
