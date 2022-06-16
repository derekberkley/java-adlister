import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("<h1>Hello, World!</h1>");

        HttpSession session = request.getSession();
        session.setAttribute("language", "en-us");
        String languagePref = (String) session.getAttribute("language");
        System.out.println(languagePref);

        if ((boolean) session.getAttribute("isAdmin")) {
            response.sendRedirect("/login");
            return;
        }
    }

//@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
//public class HelloWorldServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        String name = request.getParameter("name");
////        request.setAttribute("Derek", name);
////        request.getRequestDispatcher("/hello.jsp").forward(request, response);
//
//        if (name == null) {
//            name = "World!";
//        } else if (name.equals("bgates")) {
//            response.sendRedirect("https://microsoft.com");
//            return;
//        }
//        out.println("<h1>Hello, " + name + "!</h1>");
//    }

}