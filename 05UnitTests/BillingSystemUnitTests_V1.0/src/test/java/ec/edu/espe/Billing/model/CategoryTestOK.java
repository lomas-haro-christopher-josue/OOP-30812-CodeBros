package ec.edu.espe.Billing.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

public class CategoryTestOK {
    
    public static Stream<Arguments> categoryProvider() {
        return Stream.of(
            Arguments.of((Object) new String[]{"CAT-01", "Viveres",      "Productos de primera necesidad"}), 
            Arguments.of((Object) new String[]{"CAT-02", "Bebidas",      "Liquidos y gaseosas"}),
            Arguments.of((Object) new String[]{"CAT-03", "Limpieza",     "Articulos de aseo"}), 
            Arguments.of((Object) new String[]{"CAT-04", "Snacks",       "Papas y galletas"}),   
            Arguments.of((Object) new String[]{"CAT-05", "Lacteos",      "Leche y quesos"})
        );
    }

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

        assertEquals(id, instance.getId());
        assertEquals(name, instance.getName());
        assertEquals(description, instance.getDescription());
    }
}
