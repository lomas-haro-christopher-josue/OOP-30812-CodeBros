package ec.edu.espe.Billing.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

/**
 *
 *  * @author Brandon Collahuazo, <CodeBros> , @ESPE
 */
public class SupplierTestFail {

    private static int iterationCounter = 0;

    public static Stream<Arguments> supplier() {
        return Stream.of(
            Arguments.of("1712345678001", "Nestlé Ecuador", "Quito", "022999999", "contacto@nestle.com"),
            Arguments.of("1787654321001", "Granja Avícola Fernández", "Guayaquil", "042888888", "ventas@fernandez.com"),
            Arguments.of("1711111111001", "Pronaca", "Pifo", "022777777", "info@pronaca.com"),
            Arguments.of("1722222222001", "La Holandesa", "Cayambe", "022666666", "ventas@laholandesa.com"),
            Arguments.of("1733333333001", "Agripac", "Guayaquil", "042555555", "info@agripac.com"),
            Arguments.of("1744444444001", "Granja La Pradera", "Ambato", "032444444", "ventas@pradera.com"),
            Arguments.of("1755555555001", "Supermaxi Alimentos", "Quito", "022333333", "info@supermaxi.com"),
            Arguments.of("1766666666001", "El Ordeño", "Machachi", "022222222", "contacto@elordeno.com"),
            Arguments.of("1777777777001", "Hacienda La Gloria", "Latacunga", "032111111", "ventas@lagloria.com"),
            Arguments.of("1788888888001", "Granja San José", "Riobamba", "032000000", "info@sanjose.com")
        );
    }

    @ParameterizedTest
    @MethodSource("supplier")
    public void testEachSupplierData(String ruc, String name, String address, String phone, String email) {
        // Usamos el constructor existente que requiere los 5 parámetros
        Supplier supplier = new Supplier(ruc, name, address, phone, email);

        validateSupplierIteration(iterationCounter++, supplier, ruc, name);
    }

    private void validateSupplierIteration(int iteration, Supplier supplier, String ruc, String name) {
        if (iteration < 2) {
            assertEquals(ruc, supplier.getRuc());
            assertEquals(name, supplier.getCompanyName());
        } else if (iteration == 2) {
            assertEquals("INVALID_RUC", supplier.getRuc(), "Failure: RUC should be invalid");
        } else if (iteration == 3) {
            assertEquals("WRONG_NAME", supplier.getCompanyName(), "Failure: Company name should be invalid");
        } else if (iteration == 4) {
            assertEquals("WRONG_ADDRESS", supplier.getAddress(), "Failure: Address should be invalid");
        } else if (iteration == 5) {
            assertEquals("WRONG_PHONE", supplier.getPhone(), "Failure: Phone should be invalid");
        } else if (iteration == 6) {
            assertEquals("wrong@email.com", supplier.getEmail(), "Failure: Email should be invalid");
        } else {
            assertNotEquals("INCORRECT_COMPANY", supplier.getCompanyName(), "Failure: Company name should not match");
        }
    }
}