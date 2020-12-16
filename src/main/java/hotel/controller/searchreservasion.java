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
 * This is for search reser vasion with first name
 * request coming from reservasionsearch.jsp
 * @author janak
 */
@WebServlet(
        urlPatterns = {"/searchreservasion"}
)

public class searchreservasion extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("param1");


        GenericDao userDao = new GenericDao(User.class);




            req.setAttribute("users", userDao.getByPropertyEqual("first_name", firstName));



        RequestDispatcher dispatcher = req.getRequestDispatcher("/reservasionResult.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doPost(req, resp);
        }
}