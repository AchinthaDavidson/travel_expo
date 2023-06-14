package comguide;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
//import javax.servlet.http.;
import javax.servlet.RequestDispatcher;

//@WebServlet(name = "FileUploadServlet", urlPatterns = { "/guideinsert" })
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
@WebServlet("/guideinsert")
public class guideinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw= response.getWriter();
		
		String name1=request.getParameter("name");
		String description=request.getParameter("description");
		String img=request.getParameter("img");
		String location=request.getParameter("location");
		String contact=request.getParameter("contact");
		
		
		Part filePart = request.getPart("img");
	    String fileName = filePart.getSubmittedFileName();
	    for (Part part : request.getParts()) {
//	      part.write("C:\\Users\\achin\\OneDrive\\Desktop\\OOP Project\\travelExpo\\src\\main\\webapp\\pictures\\Place\\" + fileName);
	    	File uploads = new File("E:\\GIT\\travelexpo.github.io\\Guide\\");
		 File file = new File(uploads, fileName);
		 
	      try (InputStream input = filePart.getInputStream()) {
	          Files.copy(input, file.toPath());
	      } catch (Exception e) {
	       
	      }
	    }
//	    
		 
		
		
		
//		System.out.println(location);
//		System.out.println("sfsfws");
		
		boolean istrue;
		 istrue= guideDBUtil.insertguide(name1, description, fileName, location,contact);
		
		 if (istrue==true) {
			 pw.println("<script type=\"text/javascript\">\r\n"
			 		+ "      alert('Guide added successful');\r\n"
			 		+ "      location='Adminmain.jsp'\r\n"
			 		+ "    </script>");
//			 RequestDispatcher dis=request.getRequestDispatcher("inputPlace.jsp");
//			 dis.forward(request, response);
		 }
		 else {
			 
			 pw.println("<script type=\"text/javascript\">\r\n"
				 		+ "      alert('Guide added unsuccessful');\r\n"
				 		+ "      location='inputPlace.jsp'\r\n"
				 		+ "    </script>");
//			 RequestDispatcher dis=request.getRequestDispatcher("home.jsp");
//			 dis.forward(request, response);
		 }
		
	}

}
