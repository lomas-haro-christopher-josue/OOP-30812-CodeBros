package ec.edu.espe.Billing.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
/**
 *
 *  * @author Brandon Collahuazo, <CodeBros> , @ESPE
 */
public class PersonTestOk {

    public static Stream<String[]> personProvider() {
        return Stream.of(
                new String[]{"1712345678", "Brandon", "Collahuazo", "Quito Centro", "0987654321"},
                new String[]{"0501234567", "Micaela", "Suarez", "Quito Norte", "0991122334"},
                new String[]{"1723456789", "Carlos", "Andrade", "Calle Falsa", "0995566778"},
                new String[]{"1700000001", "Christian", "Lomas", "Av. Real", "0900000001"},
                new String[]{"1700000002", "Jennyfer", "Lopez", "Sector Sur", "0900000002"},
                new String[]{"1700000003", "Kevin", "Toapanta", "Valle", "0900000003"},
                new String[]{"1700000004", "Luis", "Mendoza", "Cumbayá", "0900000004"},
                new String[]{"1700000005", "Maria", "Chavez", "Tumbaco", "0900000005"},
                new String[]{"1700000006", "Carlos", "Castro", "El Condado", "0900000006"},
                new String[]{"1700000007", "Elizabeth", "Cumbajin", "Calderón", "0900000007"}
        );
    }

    @ParameterizedTest
    @MethodSource("validPersonProvider")
    public void testValidPersonData(String[] data) {
        Person instance = new Person();

        String id = data[0];
        String name = data[1];
        String lastName = data[2];
        String address = data[3];
        String phone = data[4];

        instance.setId(id);
        instance.setName(name);
        instance.setLastName(lastName);
        instance.setAddress(address);
        instance.setPhone(phone);

        assertEquals(id, instance.getId(), "ID verification failed.");
        assertEquals(name, instance.getName(), "Name verification failed.");
        assertEquals(lastName, instance.getLastName(), "Last name verification failed.");
        assertEquals(address, instance.getAddress(), "Address verification failed.");
        assertEquals(phone, instance.getPhone(), "Phone verification failed.");
    }
}
