package hotel.controller;


import Api.SendEmail;
import hote.entity.Reservation;
import hote.entity.Room;
import hote.entity.User;
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
import java.time.LocalDate;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/SearchAvalablity"}
)

public class SearchAvalablity extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String firstName = req.getParameter("FirstName");
//        String lastName = req.getParameter("Lastname");
//        String Email = req.getParameter("email");
//        String phone = req.getParameter("phone");
        LocalDate start = LocalDate.parse(req.getParameter("startDate"));
        LocalDate end = LocalDate.parse(req.getParameter("endDate"));
//        String userName = req.getParameter("userName");


        GenericDao userDao = new GenericDao(Room.class);


//        LocalDate date = LocalDate.of(2020, 12, 06);
//        System.out.println(date);
        List<Room> users = userDao.getByPropertyEqual1("date", start);

        int avalable = 0;
        double price = 0;

        for (Room room : users){

          avalable =    room.getAvalable();

         price = room.getCurrent_price();

        }

        RequestDispatcher dispatcher;


        if(avalable > 0){
            req.setAttribute("StartDate", start);
            req.setAttribute("EndDate", end);
            req.setAttribute("price", price);

            dispatcher = req.getRequestDispatcher("/reservasion.jsp");





        } else {


            dispatcher = req.getRequestDispatcher("/RoomnotAvalable.html");

        }






//        Email for reservasion
//        SendEmail send = new SendEmail();
//        send.getInfo("Your Conformasion for reservasion : ",  "Your name " + firstName + " "+lastName +
//                        "\nStartDate: "+ start + " End Date: " + end + " \n If you want to edit your reservasion please call at property or go back to website" +
//                         "\nYour reservasion is conform \n Thank you for making reservasion with us");
//        logger.info("Email was sent");



//        req.setAttribute("users", userDao.insert(newUser));
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}