package hote.entity;






//import edu.matc.entity.User;
//import edu.matc.persistence.UserData;

    import hotel.persistence.GenericDao;

    import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    /**
     * Add or edit the user
     * @author pwaite
     */

    @WebServlet(
            urlPatterns = {"/deleteUser"}
    )

    public class DeleteUser extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            GenericDao userData = new GenericDao(User.class);
//            UserData userData = new UserData();

            System.out.println("This is int"+Integer.valueOf(req.getParameter("id")));
            userData.delete(userData.getById(Integer.parseInt(req.getParameter("id"))));
//            genericDao.delete(genericDao.getById(2));
            System.out.println("This is int"+Integer.valueOf(req.getParameter("id")));
            RequestDispatcher dispatcher = req.getRequestDispatcher("searchUser?searchTerm=&submit=viewAll");
            dispatcher.forward(req, resp);
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doPost(req, resp);
        }
    }

