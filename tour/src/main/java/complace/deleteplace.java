package complace;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteplace")
public class deleteplace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw= response.getWriter();
//		pw.println("ok");
		
		String id=request.getParameter("isTitles" );
		boolean istrue;
		 istrue= PlaceDBUtil.deletePlace(id);
		
		 if (istrue==true) {
			 pw.println("<script type=\"text/javascript\">\r\n"
			 		+ "      alert('place added successful');\r\n"
			 		+ "      location='Adminmain.jsp'\r\n"
			 		+ "    </script>");
//			 RequestDispatcher dis=request.getRequestDispatcher("inputPlace.jsp");
//			 dis.forward(request, response);
		 }
		 else {
			 
			 pw.println("<script type=\"text/javascript\">\r\n"
				 		+ "      alert('place added unsuccessful');\r\n"
				 		+ "      location='deletePlace.jsp'\r\n"
				 		+ "    </script>");
//			 RequestDispatcher dis=request.getRequestDispatcher("home.jsp");
//			 dis.forward(request, response);
		 }
	}

}
