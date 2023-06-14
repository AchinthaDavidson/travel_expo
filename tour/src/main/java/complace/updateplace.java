package complace;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//@WebServlet(name = "FileUploadServlet", urlPatterns = { "/updateplace" })
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB

	)
@WebServlet("/updateplace")

public class updateplace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw= response.getWriter();
//		pw.println("ok");
		
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		String img=request.getParameter("img");
		String location=request.getParameter("location");
		String id=request.getParameter("isTitles" );
		
		Part filePart = request.getPart("img");
	    String fileName = filePart.getSubmittedFileName();
	    for (Part part : request.getParts()) {
//	      part.write("C:\\Users\\achin\\OneDrive\\Desktop\\OOP Project\\travelExpo\\src\\main\\webapp\\pictures\\Place\\" + fileName);
	    	File uploads = new File("E:\\GIT\\travelexpo.github.io\\Place\\");
		 File file = new File(uploads, fileName);
		 
	      try (InputStream input = filePart.getInputStream()) {
	          Files.copy(input, file.toPath());
	      } catch (Exception e) {
	       
	      }
	    }
		
	    System.out.println(id);
	    
		boolean istrue;
		 istrue= PlaceDBUtil.updatePlace(id,name, description, fileName, location);
		
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
				 		+ "      location='inputPlace.jsp'\r\n"
				 		+ "    </script>");
//			 RequestDispatcher dis=request.getRequestDispatcher("home.jsp");
//			 dis.forward(request, response);
		 }
		
	}

}
