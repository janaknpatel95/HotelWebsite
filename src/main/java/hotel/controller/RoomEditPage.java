package hotel.controller;


import hotel.entity.Room;
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
 * This is for only admin so he can change price avalabe room
 * @author janak
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




        for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
            // Do your job here with `date`.

            Room newUser = new Room(roomName,description,Price,Avalable,date);

            logger.info(date);

            userDao.insert(newUser);
        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}