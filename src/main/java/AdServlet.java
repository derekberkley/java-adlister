import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdServlet", urlPatterns = "/ads")
public class AdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        //testing code to append to the list
        Ad testAd = new Ad(8L, 600L, "test ad title", "test ad description");
        AdsInterface adsDAO = DAOFactory.getAdsDao();
        List<Ad> allAds = adsDAO.allAds();
        adsDAO.insertAd(testAd);


        req.setAttribute("allAds", DAOFactory.getAdsDao().allAds());
        req.getRequestDispatcher("/ads/index.jsp").forward(req, res);
    }

}