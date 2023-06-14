package comguide;

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
//import javax.servlet.http.Part;
import javax.servlet.http.Part;

//@WebServlet(name = "FileUploadServlet", urlPatterns = { "/Guideupdate" })
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
@WebServlet("/Guideupdate")
public class Guideupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw= response.getWriter();
//		pw.println("ok");
		
		String name1=request.getParameter("name");
		String description=request.getParameter("description");
		String img=request.getParameter("img");
		String location=request.getParameter("location");
		String contact=request.getParameter("contact");
		String id=request.getParameter("isTitles" );
		
	    Part filePart = request.getPart("img");
	    String fileName = filePart.getSubmittedFileName();
	    for (Part part : request.getParts()) {
//	      part.write("C:\\Users\\achin\\OneDrive\\Desktop\\OOP Project\\travelExpo\\src\\main\\webapp\\pictures\\Place\\" + fileName);
	    	File uploads = new File("E:\\GIT\\travelexpo.github.io\\Guide\\");
		 File file = new File(uploads, fileName);
		 
	      try (InputStream input = filePart.getInputStream()) {
	          Files.copy(input, file.toPath());
	      } catch (Exception e) {
	       System.out.println(e);
	      }
	    }
		
		boolean istrue;
		 istrue= guideDBUtil.updateGuide(id,name1, description, fileName, location,contact);
		
		 if (istrue==true) {
			 pw.println("<script type=\"text/javascript\">\r\n"
			 		+ "      alert('Guide updated successfuly');\r\n"
			 		+ "      location='Adminmain.jsp'\r\n"
			 		+ "    </script>");
//			 RequestDispatcher dis=request.getRequestDispatcher("inputPlace.jsp");
//			 dis.forward(request, response);
		 }
		 else {
			 
			 pw.println("<script type=\"text/javascript\">\r\n"
				 		+ "      alert('Guide upfate unsuccessful');\r\n"
				 		+ "      location='inputPlace.jsp'\r\n"
				 		+ "    </script>");
//			 RequestDispatcher dis=request.getRequestDispatcher("home.jsp");
//			 dis.forward(request, response);
		 }
		
	}

}
