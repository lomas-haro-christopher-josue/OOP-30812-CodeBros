package ec.edu.espe.Billing.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

public class PaymentTestFail {
    
    public static Stream<Arguments> paymentProvider() {
        return Stream.of(
            Arguments.of(20.00, 5.50, 1), 
            Arguments.of(50.00, 0.00, 2),
            Arguments.of(999.99, 1.00, 3), 
            Arguments.of(10.00, 88.88, 1), 
            Arguments.of(5.00,  0.00, 9)   
        );
    }

    private static int currentIndex = 0; 

    @ParameterizedTest
    @MethodSource("paymentProvider")
    public void testEachPaymentData(double moneyPurchased, double change, int paymentMethod) {
        Payment instance = new Payment();
        
        instance.setMoneyPurchased(moneyPurchased);
        instance.setChange(change);
        instance.setPaymentMethod(paymentMethod);

        int i = currentIndex;
        currentIndex++; 

        if (i == 0 || i == 1) {
            assertEquals(moneyPurchased, instance.getMoneyPurchased(), 0.001);
            assertEquals(change, instance.getChange(), 0.001);
            assertEquals(paymentMethod, instance.getPaymentMethod());
        } else if (i == 2) {
           
            assertEquals(-1.00, instance.getMoneyPurchased(), "Forced Failure: Incorrect money purchased.");
        } else if (i == 3) {
          
            assertEquals(-1.00, instance.getChange(), "Forced Failure: Incorrect change calculated.");
        } else if (i == 4) {
  
            assertEquals(-1, instance.getPaymentMethod(), "Forced Failure: Method ID out of range.");
        }
    }
}
