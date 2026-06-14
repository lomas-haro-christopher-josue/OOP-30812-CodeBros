package ec.edu.espe.Billing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    private Product product;
    private final double DELTA = 0.001;

    @BeforeEach
    public void setUp() {

        product = new Product("P001", "Atún", 2.00, 10);
    }

    @Test
    public void testGetPriceWithIva_FAIL1() {

        assertEquals(5.00, product.getPriceWithIva(), DELTA, "Failure 1: Calculated price with IVA is incorrect.");
    }

    @Test
    public void testCalculateSubtotal_FAIL2() {

        assertEquals(100.00, product.calculateSubtotal(3), DELTA, "Failure 2: Calculated subtotal is mismatched.");
    }

    @Test
    public void testCalculateTotalWithIva_FAIL3() {

        assertEquals(0.00, product.calculateTotalWithIva(3), DELTA, "Failure 3: Total calculation with IVA failed.");
    }

    @Test
    public void testCalculateSaleTotals_FAIL4() {
        double[] totals = product.calculateSaleTotals(5);

        assertEquals(50.00, totals[0], DELTA, "Failure 4: Subtotal inside the array is incorrect.");
    }

    @Test
    public void testCalculateSaleTotals_FAIL5() {
        double[] totals = product.calculateSaleTotals(5);

        assertEquals(99.99, totals[1], DELTA, "Failure 5: Total with IVA inside the array is incorrect.");
    }

    @Test
    public void testReduceStockSuccess_FAIL6() {
        boolean result = product.reduceStock(4);

        assertFalse(result, "Failure 6: Expected stock reduction to fail, but it succeeded.");
    }

    @Test
    public void testReduceStockNewValue_FAIL7() {
        product.reduceStock(4);

        assertEquals(20, product.getStock(), "Failure 7: Calculated remaining stock does not match.");
    }

    @Test
    public void testReduceStockInsufficient_FAIL8() {
        boolean result = product.reduceStock(15);

        assertTrue(result, "Failure 8: System should have denied the transaction due to insufficient stock.");
    }

    @Test
    public void testCalculateInventoryValue_FAIL9() {

        assertEquals(500.00, product.calculateInventoryValue(), DELTA, "Failure 9: Total inventory valuation failed.");
    }

    @Test
    public void testExplicitForcedFailure_FAIL10() {

        fail("Failure 10: Explicit interruption generated to complete the set of 10 errors.");
    }
}
