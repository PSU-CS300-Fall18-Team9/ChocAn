import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    @Test
    void toString() {
    }

    @Test
    void createServiceRec() {
        chocan.Service test2 = new chocan.Service();
        test2.createServiceRec(10,01,2000,123456, "test comment");
        assertNotNull(test2);
    }

    @Test
    void timeForm() {
        chocan.Service test = new chocan.Service();
        test.timeForm();
    }
}