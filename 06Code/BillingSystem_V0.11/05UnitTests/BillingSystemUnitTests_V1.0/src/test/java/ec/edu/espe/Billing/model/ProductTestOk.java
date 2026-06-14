package ec.edu.espe.Billing.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

public class ProductTestOk {

    public static Stream<Arguments> Product() { 
        return Stream.of(
            Arguments.of("PROD01", "Leche", 1.00, 50),
            Arguments.of("PROD02", "Pan", 0.15, 100),
            Arguments.of("PROD03", "Arroz", 0.50, 20),
            Arguments.of("PROD04", "Aceite", 2.50, 15),
            Arguments.of("PROD05", "Atun", 1.20, 30),
            Arguments.of("PROD06", "Fideo", 0.60, 40),
            Arguments.of("PROD07", "Sal", 0.40, 10),
            Arguments.of("PROD08", "Azucar", 0.80, 25),
            Arguments.of("PROD09", "Cafe", 3.00, 8),
            Arguments.of("PROD10", "Galletas", 0.50, 12)
        );
    }

    @ParameterizedTest
    @MethodSource("Product") 
    public void testEachProductData(String id, String name, double unitPrice, int stock) {
        Product instance = new Product();

        instance.setId(id);
        instance.setName(name);
        instance.setUnitPrice(unitPrice);
        instance.setStock(stock);

        assertEquals(id, instance.getId(), "ID mismatch");
        assertEquals(name, instance.getName(), "Name mismatch");
        assertEquals(unitPrice, instance.getUnitPrice(), 0.01, "Price mismatch");
        assertEquals(stock, instance.getStock(), "Stock mismatch");
    }
}