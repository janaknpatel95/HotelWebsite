package hotel.persistence;

import hote.entity.Order;

import hote.entity.User;
import hotel.test.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * the type Order dao test
 */
class OrderTest {

    /**
     * The Generic dao.
     */
//    OrderDao dao;
    GenericDao genericDao;
    /**
     * The Generic dao user.
     */
    GenericDao genericDaoUser;


    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
//        dao = new OrderDao();
        genericDao = new GenericDao(Order.class);
        genericDaoUser = new GenericDao(User.class);
        Database database = Database.getInstance();
        database.runSQL("clean.sql");





    }

    /**
     * Gets all orders success.
     */
    @Test
    void getAllOrdersSuccess() {
       List<Order> orders =  genericDao.getAll();
       assertEquals(7,orders.size());
    }


    /**
     * Gets by td success.
     */
    @Test
    void getByTdSuccess() {
        Order retrievedOrder = (Order) genericDao.getById(2);
        assertNotNull(retrievedOrder);
        assertEquals(retrievedOrder, retrievedOrder);

    }

    /**
     * Verify successful update of order
     */
    @Test
    void updateSuccess() {
        String description = "Plates, forks, and knives";
        Order orderToUpdate = (Order) genericDao.getById(3);
        orderToUpdate.setDescription(description);
        genericDao.saveOrUpdate(orderToUpdate);
        Order retrievedOrder = (Order)genericDao.getById(3);
        assertEquals(orderToUpdate, retrievedOrder);
    }

    /**
     * Verify successful insert of a order
     */
    @Test
    void insertSuccess() {

    User user = (User)genericDaoUser.getById(1);
        Order newOrder = new Order("Plates", user);
    user.addOrder(newOrder);
        int id = genericDao.insert(newOrder);

        assertNotEquals(0,id);
        Order insertedOrder = (Order)genericDao.getById(id);
        assertEquals(insertedOrder, insertedOrder);
        assertEquals(insertedOrder.getUser(), insertedOrder.getUser());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/orderguide/html_single/Hibernate_Order_Guide.html#mapping-model-pojo-equalshashcode
    }


    /**
     * Verify successful delete of order
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(2));
        assertNull(genericDao.getById(2));
    }


    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Order> orders = genericDao.getByPropertyEqual("description", "Books");
        assertEquals(1, orders.size());
        assertEquals(2, orders.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Order> orders = genericDao.getByPropertyLike("description", "b");
        assertEquals(3, orders.size());
    }
}