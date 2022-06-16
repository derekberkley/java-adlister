import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //TODO: When a user visits /logout, they should be logged out of your application and redirected to the login page.
        req.getSession().invalidate();
        req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, res);
    }
}