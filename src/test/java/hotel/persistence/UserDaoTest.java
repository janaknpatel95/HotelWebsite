package hotel.persistence;

import hote.entity.User;
import hotel.test.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao dao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("clean.sql");




        dao = new UserDao();
    }

    /**
     * Verify successful update of a User
     */
    @Test
    void saveOrUpdate() {
        String updateNewUser = "mike";
        User userBeforeUpdate = dao.getById(2);
        userBeforeUpdate.setFirst_name(updateNewUser);
        dao.saveOrUpdate(userBeforeUpdate);
        User userAfterUpdate = dao.getById(2);
        assertEquals(updateNewUser, userAfterUpdate.getFirst_name());
    }
    @Test
    void insert() {
        User newUser = new User("jack", "robertson", "jackrobert");
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals("jack", insertedUser.getFirst_name());
    }

    @Test
    void delete() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    @Test
    void getByPropertyLike() {

        List<User> users = dao.getByPropertyLike("last_name", "c");
        assertEquals(3, users.size());
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(4, users.size());
    }
}