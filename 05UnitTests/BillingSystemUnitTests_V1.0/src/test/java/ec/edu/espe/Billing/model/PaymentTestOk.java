package ec.edu.espe.Billing.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

public class PaymentTestOk {
    
    public static Stream<Arguments> paymentProvider() {
        return Stream.of(
         
            Arguments.of(20.00, 5.50, 1), 
            Arguments.of(50.00, 0.00, 2),
            Arguments.of(15.75, 0.75, 3), 
            Arguments.of(100.00, 12.30, 1),   
            Arguments.of(8.50,  0.00, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("paymentProvider")
    public void testEachPaymentData(double moneyPurchased, double change, int paymentMethod) {
        Payment instance = new Payment();
        
    
        instance.setMoneyPurchased(moneyPurchased);
        instance.setChange(change);
        instance.setPaymentMethod(paymentMethod);

        assertEquals(moneyPurchased, instance.getMoneyPurchased(), 0.001);
        assertEquals(change, instance.getChange(), 0.001);
        assertEquals(paymentMethod, instance.getPaymentMethod());
    }
}