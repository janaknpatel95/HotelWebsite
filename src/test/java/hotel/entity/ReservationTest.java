package hotel.entity;

import hotel.persistence.GenericDao;
import hotel.test.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {





    /**
     * The Generic dao.
     */

    GenericDao genericDao;
    GenericDao userDao;
    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("clean.sql");
        genericDao = new GenericDao(Reservation.class);
        userDao =  new GenericDao(User.class);

    }



    @Test
    void insertSuccess() {
        LocalDate date = LocalDate.of(2020, 12, 8);
//        User user = new User();
        User  user = (User) userDao.getById(1);


        Double price = 69.99;
        Reservation newOrder = new Reservation(date, date, price, user);
        user.addReservasion(newOrder);

        int id = userDao.insert(newOrder);

        assertNotEquals(0,id);
        Reservation insertedOrder = (Reservation) genericDao.getById(id);
        assertEquals(price, insertedOrder.getTotal_price());
        assertNotNull(insertedOrder.getUser());
        assertEquals("janak", insertedOrder.getUser().getFirst_name());
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/orderguide/html_single/Hibernate_Order_Guide.html#mapping-model-pojo-equalshashcode
    }


    /**
     * Verify successful update of a User
     */
    @Test
    void saveOrUpdate() {
        Double updateNewUser = 99.99;
        Reservation userBeforeUpdate = (Reservation)genericDao.getById(2);

        userBeforeUpdate.setTotal_price(updateNewUser);

        genericDao.saveOrUpdate(userBeforeUpdate);
        Reservation userAfterUpdate = (Reservation) genericDao.getById(2);

        assertEquals(updateNewUser, userAfterUpdate.getTotal_price());


    }



    /**
     * Verifies a user is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        Double price = 50.0;
        Reservation retrievedUser = (Reservation) genericDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals(price, retrievedUser.getTotal_price());
    }


    /**
     * Delete.
     */
    @Test
    void delete() {
        genericDao.delete(genericDao.getById(2));
        assertNull(genericDao.getById(2));
    }



    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<Reservation> room = genericDao.getAll();
        assertEquals(2, room.size());

    }

}