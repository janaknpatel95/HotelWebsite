package hotel.controller;



import hotel.entity.Role;
import hotel.entity.User;
import hotel.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This is fo creating user with role for sign up page
 * @author janak
 */

@WebServlet(
        urlPatterns = {"/signPage"}
)

public class signPage extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("FirstName");
        String lastName = req.getParameter("Lastname");
        String Email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String userName = req.getParameter("userName");
        String Password = req.getParameter("psw");

        GenericDao userDao = new GenericDao(User.class);

        User newUser = new User(firstName,lastName,userName,Email,Password,phone);



            String roleName = "admin";
            Role role = new Role(newUser,roleName, userName);

            newUser.addRole(role);


        logger.info("Role has been created" + newUser + roleName);


        req.setAttribute("users", userDao.insert(newUser));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}