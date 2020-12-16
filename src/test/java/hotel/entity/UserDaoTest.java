package hotel.entity;

//import hote.entity.Order;
import hotel.entity.User;
import hotel.persistence.GenericDao;
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
        String updateNewUser = "jac";
        User userBeforeUpdate = (User)genericDao.getById(2);

        userBeforeUpdate.setFirst_name(updateNewUser);

        genericDao.saveOrUpdate(userBeforeUpdate);
        User userAfterUpdate = (User)genericDao.getById(2);

        assertTrue(updateNewUser.equals(userAfterUpdate.getFirst_name()));

    }

    /**
     * Verifies a user is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {

        User retrievedUser = (User) genericDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("janak", retrievedUser.getFirst_name());
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
//        System.out.println(insertedUser);
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
//        System.out.println(users);
    }


    /**
     * Verify successful insert of a user
     */
    @Test
    void insertWithOrderSuccess() {

        User newUser = new User("mike","robertson","mikerobert","janak@some.com","98848584");


        LocalDate date = LocalDate.of(2020, 12, 8);
//        User user = new User();



        Double price = 69.99;

        Reservation reservation = new Reservation(date, date, price, newUser);

        newUser.addReservasion(reservation);



        int id = genericDao.insert(newUser);


        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals(insertedUser, insertedUser);
        assertEquals(1, insertedUser.getReservations().size());
//        // Could continue comparing all values, but
//        // it may make sense to use .equals()
//        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }
}