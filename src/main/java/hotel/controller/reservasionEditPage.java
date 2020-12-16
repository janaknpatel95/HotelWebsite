package hotel.controller;



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
 * This is for editing user data only edit name phone email address
 * Coming from reservasion edit button on result jsp
 * @author janak
 */

@WebServlet(
        urlPatterns = {"/reservasionEditPage"}
)

public class reservasionEditPage extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("FirstName");
        String lastName = req.getParameter("Lastname");
        String Email = req.getParameter("email");
        String phone = req.getParameter("phone");
        int id = Integer.valueOf(req.getParameter("id1"));






        GenericDao userDao = new GenericDao(User.class);

        User userBeforeUpdate = (User)userDao.getById(id);

        userBeforeUpdate.setFirst_name(firstName);
        userBeforeUpdate.setLast_name(lastName);
        userBeforeUpdate.setEmail(Email);
        userBeforeUpdate.setPhone(phone);

        userDao.saveOrUpdate(userBeforeUpdate);



        logger.debug("User is updated" + userBeforeUpdate);

        RequestDispatcher dispatcher = req.getRequestDispatcher("searchreservasion?param1="+firstName+"&submit=viewAll");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao userDao = new GenericDao(User.class);
        req.setAttribute("user", userDao.getById(Integer.parseInt(req.getParameter("id"))));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/Editreservasion.jsp");
        dispatcher.forward(req, resp);
    }
}