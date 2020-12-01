package hotel.persistence;

//import hote.entity.Order;
import hote.entity.Reservation;
import hote.entity.User;
import hotel.test.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
class UserDaoTest {

    /**
     * The Generic dao.
     */
//    UserDao dao;
    GenericDao genericDao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
//        dao = new UserDao();
        Database database = Database.getInstance();
        database.runSQL("clean.sql");
        genericDao = new GenericDao(User.class);





    }

    /**
     * Verify successful update of a User
     */
    @Test
    void saveOrUpdate() {
        String updateNewUser = "jackk";
        User userBeforeUpdate = (User)genericDao.getById(2);
        userBeforeUpdate.setFirst_name(updateNewUser);
        genericDao.saveOrUpdate(userBeforeUpdate);
        User userAfterUpdate = (User)genericDao.getById(2);
        assertEquals(userBeforeUpdate.getFirst_name(), userAfterUpdate.getFirst_name());

    }


    /**
     * Insert.
     */
    @Test
    void insert() {
        User newUser = new User("jack", "robertson", "jackrobert", "some@some.com", "60800000000", "101 8th st", "hi");
        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals(insertedUser, insertedUser);
        System.out.println(insertedUser);
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
     * Gets by property like.
     */
    @Test
    void getByPropertyLike() {

        List<User> users = genericDao.getByPropertyLike("last_name", "p");
        assertEquals(2, users.size());



    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<User> users = genericDao.getAll();
        assertEquals(2, users.size());
        System.out.println(users);
    }


    /**
     * Verify successful insert of a user
     */
//    @Test
//    void insertWithOrderSuccess() {
//
//        User newUser = new User("Fred", "Flintstone", "fflintstone");
//        String orderDecription = "Order 1";
//        Order order = new Order(orderDecription, newUser);
//
//        newUser.addOrder(order);
//
//
//
//        int id = genericDao.insert(newUser);
//
//
//        assertNotEquals(0,id);
//        User insertedUser = (User)genericDao.getById(id);
//        assertEquals(insertedUser, insertedUser);
//        assertEquals(1, insertedUser.getOrders().size());
//        // Could continue comparing all values, but
//        // it may make sense to use .equals()
//        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
//    }
}