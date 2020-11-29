package hote.entity;



import hotel.persistence.ApiDao;
import hotel.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/apiHtml"}
)

public class ApiHtml extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String param1 = req.getParameter("param1");
        ApiDao dao = new ApiDao();

        for ( PostalCodesItem code : dao.getPlace().getPostalCodes()){
//System.out.println(code.getPlaceName());

            req.setAttribute("apis", code.toString());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/Api.jsp");
            dispatcher.forward(req, resp);
        }



    }
}