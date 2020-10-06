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

    OrderDao dao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("clean.sql");




        dao = new OrderDao();
    }

    @Test
    void getAllOrdersSuccess() {
       List<Order> orders =  dao.getAll();
       assertEquals(7,orders.size());
    }


    @Test
    void getByTdSuccess() {
        Order retrievedOrder = dao.getById(2);
        assertNotNull(retrievedOrder);
        assertEquals("Books", retrievedOrder.getDescription());

    }
    /**
     * Verify successful update of order
     */
    @Test
    void updateSuccess() {
        String description = "Plates, forks, and knives";
        Order orderToUpdate = dao.getById(3);
        orderToUpdate.setDescription(description);
        dao.saveOrUpdate(orderToUpdate);
        Order retrievedOrder = dao.getById(3);
        assertEquals(description, retrievedOrder.getDescription());
    }
    /**
     * Verify successful insert of a order
     */
    @Test
    void insertSuccess() {
    UserDao userDao = new UserDao();
    User user = userDao.getById(1);
        Order newOrder = new Order("Plates", user);
    user.addOrder(newOrder);
        int id = dao.insert(newOrder);

        assertNotEquals(0,id);
        Order insertedOrder = dao.getById(id);
        assertEquals("Plates", insertedOrder.getDescription());
        assertEquals("Joe", insertedOrder.getUser().getFirst_name());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/orderguide/html_single/Hibernate_Order_Guide.html#mapping-model-pojo-equalshashcode
    }

    /**
     * Verify successful delete of order
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    /**
     * Verify successful retrieval of all orders
     */
    @Test
    void getAllSuccess() {
        List<Order> orders = dao.getAll();
        assertEquals(7, orders.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Order> orders = dao.getByPropertyEqual("description", "Books");
        assertEquals(1, orders.size());
        assertEquals(2, orders.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Order> orders = dao.getByPropertyLike("description", "b");
        assertEquals(3, orders.size());
    }
}