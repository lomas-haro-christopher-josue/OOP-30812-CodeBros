package ec.edu.espe.Billing.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

public class CashierTestOk { 
    
    public static Stream<Arguments> cashierProvider() {
        return Stream.of(
            Arguments.of((Object) new String[]{"CASH-01", "Juan Perez",    "Turno Manana", "Caja Principal", "Activo"}), 
            Arguments.of((Object) new String[]{"CASH-02", "Maria Ines",    "Turno Tarde",  "Caja Secundaria", "Activo"}),
            Arguments.of((Object) new String[]{"CASH-03", "Carlos Andrade","Turno Noche",  "Caja Central",    "Activo"}), 
            Arguments.of((Object) new String[]{"CASH-04", "Ana Gomez",     "Turno Manana", "Caja 4",          "Activo"}),   
            Arguments.of((Object) new String[]{"CASH-05", "Jennyfer L.",   "Turno Tarde",  "Sector Sur",      "Inactivo"}), 
            Arguments.of((Object) new String[]{"CASH-06", "Kevin M.",      "Turno Manana", "Valle",           "Activo"}),   
            Arguments.of((Object) new String[]{"CASH-07", "Luis R.",       "Turno Tarde",  "Cumbayá",         "Inactivo"}), 
            Arguments.of((Object) new String[]{"CASH-08", "Carlos P.",     "Turno Noche",  "El Condado",      "Activo"}),   
            Arguments.of((Object) new String[]{"CASH-09", "Elizabeth S.",  "Turno Manana", "Calderón",        "Activo"}),   
            Arguments.of((Object) new String[]{"CASH-10", "Andres M.",     "Turno Tarde",  "Sangolqui",       "Inactivo"}), 
            Arguments.of((Object) new String[]{"CASH-11", "Roberto V.",    "Turno Manana", "CCI",             "Activo"}),   
            Arguments.of((Object) new String[]{"CASH-12", "Ana P.",        "Turno Tarde",  "Quicentro",       "Inactivo"}), 
            Arguments.of((Object) new String[]{"CASH-13", "Diego C.",      "Turno Manana", "Recreo",          "Activo"}),   
            Arguments.of((Object) new String[]{"CASH-14", "Patricia B.",   "Turno Tarde",  "San Luis",        "Activo"}),   
            Arguments.of((Object) new String[]{"CASH-15", "Fernando T.",   "Turno Noche",  "Portal Shopping","Inactivo"}), 
            Arguments.of((Object) new String[]{"CASH-16", "Gabriela M.",   "Turno Manana", "Scala Shopping", "Activo"}),   
            Arguments.of((Object) new String[]{"CASH-17", "Santiago R.",   "Turno Tarde",  "Villaflora",      "Inactivo"}), 
            Arguments.of((Object) new String[]{"CASH-18", "Lucia A.",      "Turno Manana", "Chimbacalle",     "Activo"}),   
            Arguments.of((Object) new String[]{"CASH-19", "Diana F.",      "Turno Tarde",  "Carcelen",        "Inactivo"}), 
            Arguments.of((Object) new String[]{"CASH-20", "Alejandro M.",  "Turno Noche",  "Pomasqui",        "Activo"})    
        );
    }

    
    @ParameterizedTest
    @MethodSource("cashierProvider")
    public void testEachCashierData(String[] data) {
        Cashier instance = new Cashier();
        
        String id = data[0];
        String name = data[1];
        String userName = data[2];
        String password = data[3];

        instance.setId(id);
        instance.setName(name);
        instance.setUserName(userName);
        instance.setPassword(password);

        assertEquals(id, instance.getId());
        assertEquals(name, instance.getName()); 
        assertEquals(userName, instance.getUserName());
        assertEquals(password, instance.getPassword());
    }
}