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
 * This is fo cdelating user data or reservasion
 * Coming from delate button on result page
 * @author janak
 */

    @WebServlet(
            urlPatterns = {"/deleteUser"}
    )

    public class DeleteUser extends HttpServlet {

        private final Logger logger = LogManager.getLogger(this.getClass());
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            GenericDao userData = new GenericDao(User.class);



            userData.delete(userData.getById(Integer.parseInt(req.getParameter("id"))));
            logger.debug("User has been delited");

            RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
            dispatcher.forward(req, resp);
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doPost(req, resp);
        }
    }

