import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

/*    @Test
    void findGood(){

        chocan.Service test0 = new chocan.Service(01, 01, 2040, 123456, "hello");

        assertTrue(test0.find(123456));

    }

    @Test
    void findBad(){

        chocan.Service test1 = new chocan.Service(01, 01, 2040, 000000, "hello");

        assertTrue(test1.find(123456), "This test is supposed to FAIL");


    }
*/
    @Test
    void dateTime() {

        Calendar calendar = Calendar.getInstance();

        String time;

        time = calendar.get(Calendar.MONTH) + "-"
                + calendar.get(Calendar.DAY_OF_MONTH) + "-"
                + calendar.get(Calendar.YEAR) + " "
                + calendar.get(Calendar.HOUR) + ":"
                + calendar.get(Calendar.MINUTE) + ":"
                + calendar.get(Calendar.SECOND);


        chocan.Service test2 = new chocan.Service();
        test2.dateTime();

        assertEquals(time, test2.dateTime());

    }

    @Test
    void dateOfService() {

        Calendar calendar = Calendar.getInstance();

        String time;

        time = calendar.get(Calendar.MONTH) + "-"
                + calendar.get(Calendar.DAY_OF_MONTH) + "-"
                + calendar.get(Calendar.YEAR);


        chocan.Service test3 = new chocan.Service();
        test3.dateOfService();

        assertEquals(time, test3.dateOfService());
    }
}
