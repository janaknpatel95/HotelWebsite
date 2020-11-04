package hotel.persistence;


import hote.entity.PostalCodesItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiDaoTest {

    @Test
    void getPlace() {

        ApiDao dao = new ApiDao();
        //System.out.println(dao.getPlace().getPostalCodes());
        for ( PostalCodesItem code : dao.getPlace().getPostalCodes()){
            //System.out.println(code.getPlaceName());

            assertEquals("Baraboo", code.getPlaceName());
        }
        //System.out.println(code.getPlaceName());
        //assertEquals("Tatooine", dao.getPlace().getPlaceName().);


    }
}