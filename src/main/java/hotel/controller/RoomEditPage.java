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

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/RoomEditPage"}
)

public class RoomEditPage extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roomName = req.getParameter("roomName");
        String description = req.getParameter("roomDec");
        Double Price = Double.valueOf(req.getParameter("Price"));
        int Avalable = Integer.parseInt(req.getParameter("Avalibility"));
        LocalDate start = LocalDate.parse(req.getParameter("startDate"));
        LocalDate end = LocalDate.parse(req.getParameter("endDate"));



        GenericDao userDao = new GenericDao(Room.class);



//        LocalDate start = LocalDate.of(2020, 12, 06);
//        LocalDate end = LocalDate.of(2020, 12, 10);
//        LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        LocalDate end = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
            // Do your job here with `date`.

            Room newUser = new Room(roomName,description,Price,Avalable,date);
            System.out.println("this is date "+date);
            logger.info(date);

            userDao.insert(newUser);
        }

//        Room newUser = new Room(roomName,description,Price,Avalable,start);


//        Double price = 50.00;

//            Reservation reservation = new Reservation(start, end, price, newUser );
//
//            newUser.addReservasion(reservation);
////        Email for reservasion
//        SendEmail send = new SendEmail();
//        send.getInfo("Your Conformasion for reservasion : ",  "Your name " + firstName + " "+lastName +
//                        "\nStartDate: "+ start + " End Date: " + end + " \n If you want to edit your reservasion please call at property or go back to website" +
//                         "\nYour reservasion is conform \n Thank you for making reservasion with us");
//        logger.info("Email was sent");



//        req.setAttribute("users",userDao.insert(newUser) );
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}