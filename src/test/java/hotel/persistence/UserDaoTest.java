package hotel.persistence;

import hote.entity.Order;
import hote.entity.User;
import hotel.test.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao dao;
    GenericDao genericDao;

    @BeforeEach
    void setUp() {
        dao = new UserDao();
        genericDao = new GenericDao(Order.class);
        Database database = Database.getInstance();
        database.runSQL("clean.sql");




    }

    /**
     * Verify successful update of a User
     */
    @Test
    void saveOrUpdate() {
        String updateNewUser = "mike";
        User userBeforeUpdate = (User)genericDao.getById(2);
        userBeforeUpdate.setFirst_name(updateNewUser);
        genericDao.saveOrUpdate(userBeforeUpdate);
        User userAfterUpdate = (User)genericDao.getById(2);
        assertEquals(updateNewUser, userAfterUpdate.getFirst_name());
    }
    @Test
    void insert() {
        User newUser = new User("jack", "robertson", "jackrobert");
        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals("jack", insertedUser.getFirst_name());
    }

    @Test
    void delete() {
        genericDao.delete(genericDao.getById(3));
        assertNull(genericDao.getById(3));
    }

    @Test
    void getByPropertyLike() {

        List<User> users = genericDao.getByPropertyLike("last_name", "c");
        assertEquals(3, users.size());
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<User> users = genericDao.getAll();
        assertEquals(4, users.size());
    }
    /**
     * Verify successful insert of a user
     */
    @Test
    void insertWithOrderSuccess() {

        User newUser = new User("Fred", "Flintstone", "fflintstone");
        String orderDecription = "Order 1";
        Order order = new Order(orderDecription, newUser);

        newUser.addOrder(order);



        int id = dao.insert(newUser);


        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals("Fred", insertedUser.getFirst_name());
        assertEquals(1, insertedUser.getOrders().size());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }
}