package hotel.entity;

import hotel.persistence.GenericDao;
import hotel.test.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

        List<Room> users = genericDao.getByPropertyEqual1("date", date);


        assertEquals(1, users.size());

    }


    /**
     * Verify successful update of a User
     */
    @Test
    void saveOrUpdate() {
        String updateNewUser = "KingBed";
        Room userBeforeUpdate = (Room)genericDao.getById(2);

        userBeforeUpdate.setRoom_name(updateNewUser);

        genericDao.saveOrUpdate(userBeforeUpdate);
        Room userAfterUpdate = (Room) genericDao.getById(2);

        assertTrue(updateNewUser.equals(userAfterUpdate.getRoom_name()));

    }


    /**
     * Insert.
     */
    @Test
    void insert() {

        LocalDate date = LocalDate.of(2020, 12, 8);
        Room newUser = new Room("3queen", "2 queen bed",60.00,2, date);
        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        Room insertedUser = (Room) genericDao.getById(id);
        assertEquals(insertedUser, insertedUser);

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

        List<Room> room = genericDao.getByPropertyLike("room_name", "K");
        assertEquals(1, room.size());



    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<Room> room = genericDao.getAll();
        assertEquals(2, room.size());

    }



}