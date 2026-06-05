package ec.edu.espe.Billing.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

public class CustomerTestFail {

    private static int iterationCounter = 0;

    public static Stream<Arguments> customer() {
        return Stream.of(
            Arguments.of(123456789, "Brandon", "Quito", "brandon@gmail.com"),
            Arguments.of(111111111, "Didier", "Ambato", "didier@gmail.com"),
            Arguments.of(122222222, "Carlos", "Latacunga", "carlos@gmail.com"),
            Arguments.of(133333333, "Ana", "Ibarra", "ana@gmail.com"),
            Arguments.of(144444444, "Sofia", "Loja", "sofia@gmail.com"),
            Arguments.of(155555555, "Luis", "Cuenca", "luis@gmail.com"),
            Arguments.of(166666666, "Maria", "Tulcan", "maria@gmail.com"),
            Arguments.of(177777777, "Jose", "Manta", "jose@gmail.com"),
            Arguments.of(188888888, "Lucia", "Portoviejo", "lucia@gmail.com"),
            Arguments.of(199999999, "Pedro", "Machala", "pedro@gmail.com")
        );
    }

    @ParameterizedTest
    @MethodSource("customer")
    public void testEachCustomerData(int ruc, String name, String address, String gmail) {
        Customer customer = new Customer();
        customer.setRuc(ruc);
        customer.setName(name);
        customer.setAddress(address);
        customer.setGmailCustomer(gmail);

        if (iterationCounter == 0 || iterationCounter == 1) {
            assertEquals(ruc, customer.getRuc(), "RUC should match");
            assertEquals(name, customer.getName(), "Name should match");
        } else if (iterationCounter == 2) {
            assertEquals(999999999, customer.getRuc(), "Failure: RUC should be invalid");
        } else if (iterationCounter == 3) {
            assertEquals("WRONG_NAME", customer.getName(), "Failure: Name should be invalid");
        } else if (iterationCounter == 4) {
            assertEquals("WRONG_ADDRESS", customer.getAddress(), "Failure: Address should be invalid");
        } else if (iterationCounter == 5) {
            assertEquals("wrong@email.com", customer.getGmailCustomer(), "Failure: Gmail should be invalid");
        } else {
            assertNotEquals("UNEXPECTED_NAME", customer.getName(), "Failure: Name should not match");
        }

        iterationCounter++;
    }
}