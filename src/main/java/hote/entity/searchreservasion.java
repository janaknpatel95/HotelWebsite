package hote.entity;



import hotel.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/searchreservasion"}
)

public class searchreservasion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("param1");


        GenericDao userDao = new GenericDao(User.class);




        Double price = 50.00;

//            User newUser = new User("Fred", "Flintstone", userName);

//            String roleName = "admin";
//            Role role = new Role(newUser,roleName, userName);
//            Reservation reservation = new Reservation(start, end, price, newUser );
//
//            newUser.addReservasion(reservation);


//        List<User> users = genericDao.getByPropertyLike("last_name", "p");
//        assertEquals(2, users.size());
//        System.out.println(users);


//        for(User user : users){
//
//            System.out.println("This is id   "+user.getId());
//            System.out.println(user.reservations);
//
//
//        }





            req.setAttribute("users", userDao.getByPropertyEqual("first_name", firstName));


//        req.setAttribute("users", userDao.getAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/reservasionResult.jsp");
        dispatcher.forward(req, resp);
    }
}