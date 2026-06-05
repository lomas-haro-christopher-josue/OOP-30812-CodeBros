package ec.edu.espe.Billing.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

public class CategoryTestFail {
    
    public static Stream<Arguments> categoryProvider() {
        return Stream.of(
            Arguments.of((Object) new String[]{"CAT-01", "Viveres",      "Productos de primera necesidad"}), 
            Arguments.of((Object) new String[]{"CAT-02", "Bebidas",      "Liquidos y gaseosas"}),
            Arguments.of((Object) new String[]{"CAT-ERR", "Error Forzado", "Descripcion falsa"}), 
            Arguments.of((Object) new String[]{"CAT-03",  "FailName",      "Test descripcion"}),   
            Arguments.of((Object) new String[]{"CAT-04",  "Limpieza",      "Stress test"})
        );
    }

    private static int currentIndex = 0; 

    @ParameterizedTest
    @MethodSource("categoryProvider")
    public void testEachCategoryData(String[] data) {
        Category instance = new Category();
        
        String id = data[0];
        String name = data[1];
        String description = data[2]; 

        instance.setId(id);
        instance.setName(name);
        instance.setDescription(description);

        int i = currentIndex;
        currentIndex++; 

        if (i == 0 || i == 1) {
            assertEquals(id, instance.getId());
            assertEquals(name, instance.getName());
            assertEquals(description, instance.getDescription());
        } else if (i == 2) {
            assertEquals("FORCED_INCORRECT_ID", instance.getId(), "Forced Failure: ID broken.");
        } else if (i == 3) {
            assertEquals("INCORRECT_NAME", instance.getName(), "Forced Failure: Name broken.");
        } else if (i == 4) {
            assertEquals("INCORRECT_DESCRIPTION", instance.getDescription(), "Forced Failure: Desc broken.");
        }
    }
}
