/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.68
 * Generated at: 2022-11-13 15:02:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1668174596762L));
    _jspx_dependants.put("jar:file:/C:/Users/achin/OneDrive/Desktop/travel_expo/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/tour/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153365282000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://fonts.googleapis.com/css2?family=Lobster+Two:ital@1&display=swap\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<link href=\"https://wijethungaia.github.io/travelexpo.github.io/CSS/home.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<!-- top topic -->\r\n");
      out.write("	<div class=\"image\">\r\n");
      out.write("  <div class=\"topic\">\r\n");
      out.write("    <center>\r\n");
      out.write("      <img src=\"https://it21209352.github.io/css/pictures/logo.png\" width=\"90\" height=\"80\" style=\"margin-top:-1;\">\r\n");
      out.write("      <label>Traval Expo</label>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"topic1\">\r\n");
      out.write("    <h1 style=\"font-size:100px;font-family: 'Lobster Two', cursive;\">\r\n");
      out.write("   <span>Discover</span>\r\n");
      out.write("              <span>Story-worthy </span>\r\n");
      out.write("              <span>travel moments</span>\r\n");
      out.write("\r\n");
      out.write("    </h1>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"login\">\r\n");
      out.write("    <!-- <button type=\"button\" name=\"button\">Login</button> -->\r\n");
      out.write("    <div class=\"dropdown\">\r\n");
      out.write("      <img class=\"\" style=\"margin-left: 50px;\"\r\n");
      out.write("        src=\"https://it21209352.github.io/css/pictures/user.png\" alt=\"logo\"\r\n");
      out.write("        height=\"60\" width=\"60\">\r\n");
      out.write("\r\n");
      out.write("      <div class=\"dropdown-content\">\r\n");
      out.write("        <a href=\"homeservlet\">Account</a>\r\n");
      out.write("        \r\n");
      out.write("        <a href=\"AboutUs.html\">About us</a>\r\n");
      out.write("        <a href=\"logout\">LOGOUT</a>\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <img src=\"https://wijethungaia.github.io/travelexpo.github.io/Place/home.jpg\" alt=\"\" class=\"image1\"></center>\r\n");
      out.write("  \r\n");
      out.write("</div>\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("		<!-- MAIN (Center website) -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("		<!-- catogaries -->\r\n");
      out.write("		<div class=\"Cateories\">\r\n");
      out.write("			â\r\n");
      out.write("			<div class=\"row1\">\r\n");
      out.write("				<div class=\"column1\">\r\n");
      out.write("					<a href=\"showplace\"> <img\r\n");
      out.write("						src=\"https://it21209352.github.io/css/pictures/location.png\"\r\n");
      out.write("						alt=\"...\" height=\"70%\" width=\"15%\">\r\n");
      out.write("						<h2 style=\"color: lightgreen;\">Best Places for visit</h2>\r\n");
      out.write("						<p style=\"color: white; align: justify;\">Siygiria, Nuwara\r\n");
      out.write("							Eliya, Pinnewala Elephant Orphanage, Trincomalee, Udawalawe\r\n");
      out.write("							National Park, Sinharaja Forest Reserve, and many more. Because\r\n");
      out.write("							of the artistic diversity of places to visit in Sri Lanka, it has\r\n");
      out.write("							become a very popular destination for tourists.</p>\r\n");
      out.write("					</a>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"column1\">\r\n");
      out.write("					<a href=\"showpackage\"> <img\r\n");
      out.write("						src=\"https://it21209352.github.io/css/pictures/places.png\"\r\n");
      out.write("						alt=\"...\" height=\"70%\" width=\"15%\">\r\n");
      out.write("						<h2 style=\"color: lightgreen;\"> Crete your own\r\n");
      out.write("							Package</h2>\r\n");
      out.write("						<p style=\"color: white; align: justify;\">Pick places you like\r\n");
      out.write("							to visit. Choose your guide.Leave the rest to us.</p>\r\n");
      out.write("					</a>\r\n");
      out.write("				</div>\r\n");
      out.write("				<!-- <div class=\"column1\">\r\n");
      out.write("					<a href=\"#\"> <img\r\n");
      out.write("						src=\"https://it21209352.github.io/css/pictures/hotels.png\"\r\n");
      out.write("						alt=\"...\" height=\"80%\" width=\"20%\">\r\n");
      out.write("						<h2 style=\"color: lightgreen;\">Book a hotel</h2>\r\n");
      out.write("						<p style=\"color: white; align: justify;\">hotels are vary\r\n");
      out.write("							according to your choice. In packages hotels assigned according\r\n");
      out.write("							to the places that you travel. these are some hotels that famous\r\n");
      out.write("							around specific places.pal wild coast tented lodge , kaju green\r\n");
      out.write("							eco lodges , taj samudra hotel , gladari hotel and many more.</p>\r\n");
      out.write("					</a>\r\n");
      out.write("				</div> -->\r\n");
      out.write("				<div class=\"column1\">\r\n");
      out.write("					<a href=\"Showguide\"> <img\r\n");
      out.write("						src=\"https://wijethungaia.github.io/travelexpo.github.io/Place/user.png\" alt=\"...\"\r\n");
      out.write("						height=\"80%\" width=\"20%\">\r\n");
      out.write("						<h2 style=\"color: lightgreen;\">Find guide for you</h2>\r\n");
      out.write("						<p style=\"color: white; align: justify;\">Giudes are assigned\r\n");
      out.write("							to every package that you pick and also you can select specific\r\n");
      out.write("							tour guide as you like.</p>\r\n");
      out.write("					</a>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("<!-- video -->\r\n");
      out.write("		 <table border=\"0\" width=\"100%\">\r\n");
      out.write("			<tr height=\"400\">\r\n");
      out.write("				<td><video autoplay muted loop id=\"myVideo\" z-index=\"0\">\r\n");
      out.write("						<source\r\n");
      out.write("							src=\"https://it21209352.github.io/css/pictures/Sri Lanka Tourism.mp4\"\r\n");
      out.write("							type=\"video/mp4\">\r\n");
      out.write("					</video></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table> \r\n");
      out.write("\r\n");
      out.write("		<!-- random image -->\r\n");
      out.write("		<div class=\"Cateories\" style=\"background-color: white;\">\r\n");
      out.write("			â\r\n");
      out.write("			<div class=\"row1\">\r\n");
      out.write("				<div class=\"column1 cimg\">\r\n");
      out.write("					<a href=\"#\">\r\n");
      out.write("						<p align=\"justify\" style=\"margin-top: 30%; font-size: 20px;padding-top:20%\">\r\n");
      out.write("							The tropical climate, beautiful beaches and incredible food of\r\n");
      out.write("							Sri Lanka are just some of the many reasons to include the South\r\n");
      out.write("							Asian country on your travel wish list.\r\n");
      out.write("						</p>\r\n");
      out.write("					</a>\r\n");
      out.write("				</div>\r\n");
      out.write("\r\n");
      out.write("				<div class=\"column1 cimg\">\r\n");
      out.write("					<a href=\"#\"> <img\r\n");
      out.write("						src=\"https://it21209352.github.io/css/pictures/sigiriya.jpg\"\r\n");
      out.write("						alt=\"...\">\r\n");
      out.write("\r\n");
      out.write("					</a>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"column1 cimg\">\r\n");
      out.write("					<a href=\"#\"> <img\r\n");
      out.write("						src=\"https://it21209352.github.io/css/pictures/9arch.jpg\"\r\n");
      out.write("						alt=\"...\" height=250px> <img\r\n");
      out.write("						src=\"https://it21209352.github.io/css/pictures/wildlife.jpg\"\r\n");
      out.write("						alt=\"...\">\r\n");
      out.write("					</a>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("		<!-- footer -->\r\n");
      out.write("		<div class=\"footer\">\r\n");
      out.write("			<BR>\r\n");
      out.write("			<h3>THANK YOU FOR CHOOSING Travel EXPO</h3>\r\n");
      out.write("			<p>We offer a wide range of tour programs from Northeast to down\r\n");
      out.write("				south covering Nature, Culture, wildlife, National Parks,\r\n");
      out.write("				Ecotourism, and many more areas to fulfil our clientsâ\r\n");
      out.write("				requirements</p>\r\n");
      out.write("\r\n");
      out.write("			<ul class=\"socials\">\r\n");
      out.write("				<li><a href=\"#\"> <img\r\n");
      out.write("						src=\"https://it21209352.github.io/css/pictures//FB.png\"\r\n");
      out.write("						height=\"50px\" width=\"25px\">\r\n");
      out.write("				</a></li>\r\n");
      out.write("				<li><a\r\n");
      out.write("					href=\"https://api.whatsapp.com/send/?phone=94718922774&text&app_absent=0\">\r\n");
      out.write("						<img src=\"https://it21209352.github.io/css/pictures//WA.png\"\r\n");
      out.write("						height=\"50px\" width=\"50px\">\r\n");
      out.write("				</a></li>\r\n");
      out.write("				<li><a href=\"#\"><img\r\n");
      out.write("						src=\"https://it21209352.github.io/css/pictures//Tweet.png\"\r\n");
      out.write("						height=\"50px\" width=\"50px\" alt=\"\"></a></li>\r\n");
      out.write("				<li><a href=\"#\"><img\r\n");
      out.write("						src=\"https://it21209352.github.io/css/pictures//Locat.png\"\r\n");
      out.write("						height=\"50px\" width=\"50px\" height=\"100px\" width=\"100px\" alt=\"\"></a></li>\r\n");
      out.write("				<li><a href=\"#\"><img\r\n");
      out.write("						src=\"https://it21209352.github.io/css/pictures//inter.png\"\r\n");
      out.write("						height=\"50px\" width=\"50px\" alt=\"\"></a></li>\r\n");
      out.write("\r\n");
      out.write("			</ul>\r\n");
      out.write("			<div class=\"footer-bottom\">\r\n");
      out.write("				<p>\r\n");
      out.write("					copyright &copy;2022 <a href=\"#\">Project Group 12</a>\r\n");
      out.write("				</p>\r\n");
      out.write("			</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
