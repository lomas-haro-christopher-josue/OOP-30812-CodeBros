package ec.edu.espe.Billing.model;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
/**
 *
 *  * @author Brandon Collahuazo, <CodeBros> , @ESPE
 */
public class PersonTestFail {
  
    public static Stream<String[]> personProvider() {
        return Stream.of(
            new String[]{"1712345678", "Brandon", "Collahuazo", "Quito Centro", "0987654321"}, 
            new String[]{"0501234567", "Micaela", "Suarez",     "Quito Norte",  "0991122334"},
            new String[]{"0099999999", "Error",   "Forzado",    "Calle Falsa",  "9999999999"}, 
            new String[]{"1700000001", "FailName", "Test",      "Av. Real",     "0900000001"}, 
            new String[]{"1700000002", "Jennyfer", "Stress",    "Sector Sur",   "0900000002"}, 
            new String[]{"1700000003", "Kevin",    "Error",     "Valle",        "0900000003"}, 
            new String[]{"1700000004", "Luis",     "Wrong",     "Cumbayá",      "0900000004"}, 
            new String[]{"1700000005", "Maria",    "Bug",       "Tumbaco",      "0900000005"}, 
            new String[]{"1700000006", "Carlos",   "Crash",     "El Condado",   "0900000006"}, 
            new String[]{"1700000007", "Elizabeth", "Fault",    "Calderón",     "0900000007"} 
        );
    }

    private static int currentIndex = 0; 
    @ParameterizedTest
    @MethodSource("personProvider")
    public void testEachPersonData(String[] data) {
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

        int i = currentIndex;
        currentIndex++; 

        if (i == 0 || i == 1) {
            assertEquals(id, instance.getId());
            assertEquals(name, instance.getName());
            assertEquals(lastName, instance.getLastName());
            assertEquals(address, instance.getAddress());
            assertEquals(phone, instance.getPhone());
        } else if (i == 2) {
            assertEquals("FORCED_INCORRECT_ID", instance.getId(), "Forced Failure: ID check broken.");
        } else if (i == 3) {
            assertEquals("INCORRECT_NAME", instance.getName(), "Forced Failure: Name check broken.");
        } else if (i == 4) {
            assertEquals("INCORRECT_LASTNAME", instance.getLastName(), "Forced Failure: Last Name check broken.");
        } else if (i == 5) {
            assertEquals("INCORRECT_ADDRESS", instance.getAddress(), "Forced Failure: Address check broken.");
        } else if (i == 6) {
            assertEquals("INCORRECT_PHONE", instance.getPhone(), "Forced Failure: Phone check broken.");
        } else if (i == 7) {
            assertEquals("ANOTHER_FAKE_NAME", instance.getName(), "Forced Failure: Name validation crash.");
        } else if (i == 8) {
            assertEquals("0000-FAIL", instance.getId(), "Forced Failure: Invalid ID check.");
        } else if (i == 9) {
            assertEquals("SANGOLQUI", instance.getAddress(), "Forced Failure: Location mismatch.");
        }
    }
}