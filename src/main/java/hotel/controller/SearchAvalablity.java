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
import java.util.List;

/**
 * This is for search avablity of room if you do not have room avalable if will give you error
 * coming from index.html to search reservasion avalable
 * @author janak
 */

@WebServlet(
        urlPatterns = {"/SearchAvalablity"}
)

public class SearchAvalablity extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LocalDate start = LocalDate.parse(req.getParameter("startDate"));
        LocalDate end = LocalDate.parse(req.getParameter("endDate"));

        GenericDao userDao = new GenericDao(Room.class);



        List<Room> users = userDao.getByPropertyEqual1("date", start);

        int avalable = 0;
        double price = 0;

        for (Room room : users){

          avalable =    room.getAvalable();

         price = room.getCurrent_price();

        }

        RequestDispatcher dispatcher;

        //Cheking for avalable room if not avalable then send error if avalabel then send to make reservasion
        if(avalable > 0){
            req.setAttribute("StartDate", start);
            req.setAttribute("EndDate", end);
            req.setAttribute("price", price);

            dispatcher = req.getRequestDispatcher("/reservasion.jsp");





        } else {


            dispatcher = req.getRequestDispatcher("/RoomnotAvalable.html");

        }






        dispatcher.forward(req, resp);
    }
}