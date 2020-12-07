package hote.entity;

import hotel.persistence.GenericDao;
import hotel.test.Database;
import hote.entity.User;
import hotel.test.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class RoomTest {





    /**
     * The Generic dao.
     */

    GenericDao genericDao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("clean.sql");
        genericDao = new GenericDao(Room.class);


    }






    @Test
    void getByPropertyEqualSuccess() {

        LocalDate date = LocalDate.of(2020, 12, 06);
        System.out.println(date);
        List<Room> users = genericDao.getByPropertyEqual1("date", date);

        System.out.println("this is "+users);
        assertEquals(1, users.size());
//        assertEquals(1, users.get(0).getId());
//        logger.info(users);
//        User retrievedUser = (User) genericDao.getById(users.get(0).getId());
//        assertEquals("admin", retrievedUser.getUserRoles().toString());
//        System.out.print(retrievedUser.getUserRoles());

        // For loop works too!
//        for(User userRole : users) {
//            logger.info(userRole.userRoles);
//        }
    }



    @Test
    void insert() {

//        LocalDate start = LocalDate.of(2020, 12, 06);
//        LocalDate end = LocalDate.of(2020, 12, 10);
////        LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
////        LocalDate end = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//
//        for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
//            // Do your job here with `date`.
//            System.out.println(date);
//        }


//        LocalDate date;
//        Room newUser = new Room("2Qeen", "2bed", 49.99, 2, date);
//        int id = genericDao.insert(newUser);
//        assertNotEquals(0,id);
//        User insertedUser = (User)genericDao.getById(id);
//        assertEquals(insertedUser, insertedUser);
//        System.out.println(insertedUser);
    }


    void getByPropertyLike() {

//        List<User> users = genericDao.getByPropertyLike("last_name", "p");
//        assertEquals(2, users.size());
//


    }
}