package chocan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProviderTest {
    private Data aProvider;
    private Service aService;

    ProviderTest() {
        aProvider = new Provider("First", "Last", "NE 9th St", "Portland", "OR", 97007, 123456789,false);
        aService = null;
    }

    @Test
    void testAddServiceGood() {
        // Test adding multiple services using dynamic binding
        aService = new Service (112819, 1400, 113019, 1234589, 123457886, 812, 10, "N/A");
        assertTrue(aProvider.addService(aService,"Customer1", 246803587));
        aService = new Service (112919, 1400, 123019, 1234444, 123457886, 812, 10, "N/A");
        assertTrue(aProvider.addService(aService,"Customer2", 24688879));

    }

    @Test
    void testAddServiceBad() {
        // testing inserting a service where the object is null
        assertFalse(aProvider.addService(aService,"Customer1", 246803587));
    }

/*
    @Test
    void testServiceReportBad() {
        // Testing building the service portion of the service report if provider does not have any services
        // in the service list
        Provider person = new Provider();
        String [] services = person.serviceReport();
        String [] nothing = null;
        assertEquals(nothing, services);
    }*/
/*
    @Test
    void testServiceReportGood() {

        aService = new Service (113444, 1400, 113019, 1234589, 123457886, 812, 10, "N/A");
        Provider person = new Provider();
        String [] expected = new String[6];

        person.addService(aService, "Customer", 123456789);
        String [] output = person.serviceReport();
        expected[0] = "Date of service: 113444";
        expected[1] = "Current date and time: 113444 1400";
        expected[2] = "Member name: Customer";
        expected[3] = "Member number: 123456789";
        expected[4] = "Service code: 812";
        expected[5] = "Fee to be paid: 10\n";

        assertEquals(expected.length, output.length);
        for (int i = 0; i < output.length; ++i) {
            assertEquals(expected[i], output[i]);
        }
    }*/
}