package hotel.entity;

import hotel.persistence.GenericDao;
import hotel.test.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {



    /**
     * genericDao
     */
    //UserRoleDao dao;
    GenericDao genericDao;
    GenericDao genericDaoUser;


    /**
     * Creating the dao successfully.
     */
    @BeforeEach
    void setUp() {
        //dao = new UserRoleDao();
        genericDao = new GenericDao(Role.class);
        genericDaoUser = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("clean.sql");

    }

    /**
     * Verifies Gets all user roles successfully.
     */
    @Test
    void getAllUserRoles() {
        List<Role> userRoles = genericDao.getAll();
        assertEquals(2, userRoles.size());
    }

    /**
     * Verifies Gets by id successfully.
     */
    @Test
    void getById() {
        Role retrievedOrderUserRole = (Role)genericDao.getById(1);
        assertNotNull(retrievedOrderUserRole);
        assertEquals("admin", retrievedOrderUserRole.getRoleName());
    }

    /**
     * Verifies Insert successfully.
     */
    @Test
    void insert() {
        User user = (User)genericDaoUser.getById(1);
        String roleName = "admin";
        String UserName = "mayay";

        Role newUserRoles = new Role(user, roleName,"jack");
        user.addRole(newUserRoles);
        int id = genericDao.insert(newUserRoles);
        assertNotEquals(0, id);

        Role insertedUser = (Role)genericDao.getById(id);
        assertNotNull(insertedUser);
        assertEquals(roleName, insertedUser.getRoleName());
        assertNotNull(insertedUser.getUser());
        assertEquals("janak", insertedUser.getUser().getFirst_name());


    }

    /**
     * Verifies Delete successfully.
     */
    @Test
    void delete() {
        genericDao.delete(genericDao.getById(2));
        assertNull(genericDao.getById(2));
    }

    /**
     * Verifies Save or update successfully.
     */
    @Test
    void saveOrUpdate() {
        String newUserRole = "user";
        Role userRoleToUpdate = (Role)genericDao.getById(2);
        userRoleToUpdate.setRoleName(newUserRole);
        genericDao.saveOrUpdate(userRoleToUpdate);
        Role retrievednewUserRole = (Role)genericDao.getById(2);
        assertEquals(newUserRole, retrievednewUserRole.getRoleName());
        String expectedUserRole = "user";
        String actualUserRole = retrievednewUserRole.getRoleName();
        assertTrue(expectedUserRole.equals(actualUserRole));
    }

    /**
     * Verifies Gets by property equal successfully.
     * "roleName" from instance UserRole class
     */
    @Test
    void getByPropertyEqual() {
        List<Role> role = genericDao.getByPropertyEqual("roleName", "admin");
        assertEquals(2, role.size());
        assertEquals(2, role.get(1).getId());
    }


    /**
     * Verifies Gets by property like successfully.
     */
    @Test
    void getByPropertyLike() {
        List<Role> userRoles = genericDao.getByPropertyLike("roleName", "n");
        assertEquals(2, userRoles.size());
    }





}