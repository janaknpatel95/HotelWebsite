package hotel.controller;



import hotel.entity.User;
import hotel.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This is only for admin so he can see how many reservasion is comming
 * request comming fro adminreservasion.jsp
 * @author janak
 */
@WebServlet(
        urlPatterns = {"/searchreservasionAdmin"}
)

public class searchreservasionAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("param1");


        GenericDao userDao = new GenericDao(User.class);




            req.setAttribute("users", userDao.getAll());



        RequestDispatcher dispatcher = req.getRequestDispatcher("/reservasionResult.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doPost(req, resp);
        }
}