package ec.edu.espe.Billing.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
/**
 *
 *  * @author Brandon Collahuazo, <CodeBros> , @ESPE
 */
public class ProductTestFail {

    public static Stream<String[]> personProvider() {
        return Stream.of(
                new String[]{"PROD01", "Leche", "1.00", "50"},
                new String[]{"PROD02", "Pan", "0.15", "100"},
                new String[]{"PROD03", "Arroz", "0.50", "20"},
                new String[]{"PROD04", "Aceite", "2.50", "15"},
                new String[]{"PROD05", "Atun", "1.20", "30"},
                new String[]{"PROD06", "Fideo", "0.60", "40"},
                new String[]{"PROD07", "Sal", "0.40", "10"},
                new String[]{"PROD08", "Azucar", "0.80", "25"},
                new String[]{"PROD09", "Cafe", "3.00", "8"},
                new String[]{"PROD10", "Galletas", "0.50", "12"}
        );
    }

    private static int currentIndex = 0;

    @ParameterizedTest
    @MethodSource("personProvider")
    public void testEachProductData(String[] data) {
        Product instance = new Product();

        String id = data[0];
        String name = data[1];
        double unitPrice = Double.parseDouble(data[2]);
        int stock = Integer.parseInt(data[3]);

        instance.setId(id);
        instance.setName(name);
        instance.setUnitPrice(unitPrice);
        instance.setStock(stock);

        int i = currentIndex;
        currentIndex++;

        if (i == 0 || i == 1) {
            assertEquals(id, instance.getId());
            assertEquals(name, instance.getName());
            assertEquals(unitPrice, instance.getUnitPrice(), 0.001);
            assertEquals(stock, instance.getStock());
        } else if (i == 2) {
            assertEquals("FORCED_INCORRECT_ID", instance.getId(), "Forced Failure: ID check broken.");
        } else if (i == 3) {
            assertEquals("INCORRECT_NAME", instance.getName(), "Forced Failure: Name check broken.");
        } else if (i == 4) {
            assertEquals(999.99, instance.getUnitPrice(), 0.001, "Forced Failure: Price check broken.");
        } else if (i == 5) {
            assertEquals(-10, instance.getStock(), "Forced Failure: Stock check broken.");
        } else if (i == 6) {
            assertEquals("INCORRECT_NAME", instance.getName(), "Forced Failure: Name validation crash.");
        } else if (i == 7) {
            assertEquals("0000-FAIL", instance.getId(), "Forced Failure: Invalid ID check.");
        } else if (i == 8) {
            assertEquals(555.55, instance.getUnitPrice(), 0.001, "Forced Failure: Price mismatch.");
        } else if (i == 9) {
            assertEquals(-1, instance.getStock(), "Forced Failure: Final stock crash.");
        }
    }
}
