package ec.edu.espe.Billing.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

/**
 * Test class for Company verifying failure scenarios with food industry data.
 */
public class CompanyTestFail {

    private static int iterationCounter = 0;

    public static Stream<Arguments> company() {
        return Stream.of(
            Arguments.of("1791234567001", "Alimentos Polar", "Quito"),
            Arguments.of("1798765432001", "Granja Avícola San Antonio", "Guayaquil"),
            Arguments.of("1791111111001", "Industrias Alimenticias Danec", "Machachi"),
            Arguments.of("1792222222001", "Granjas del Valle", "Cayambe"),
            Arguments.of("1793333333001", "Alimentos Proceal", "Cuenca"),
            Arguments.of("1794444444001", "Granja La Esperanza", "Loja"),
            Arguments.of("1795555555001", "Alimentos Procesados S.A.", "Ambato"),
            Arguments.of("1796666666001", "Granja Integral Los Andes", "Tulcan"),
            Arguments.of("1797777777001", "Alimentos Nutri", "Latacunga"),
            Arguments.of("1798888888001", "Granja El Roble", "Riobamba")
        );
    }

    @ParameterizedTest
    @MethodSource("company")
    public void testEachCompanyData(String id, String name, String address) {
        Company company = new Company();
        company.setCompanyId(id);
        company.setCompanyName(name);
        company.setCompanyAddress(address);

        validateCompanyIteration(iterationCounter++, company, id, name, address);
    }

    private void validateCompanyIteration(int iteration, Company company, String id, String name, String address) {
        if (iteration < 2) {
            assertEquals(id, company.getCompanyId());
            assertEquals(name, company.getCompanyName());
            assertEquals(address, company.getCompanyAddress());
        } else if (iteration == 2) {
            assertEquals("INVALID_ID", company.getCompanyId(), "Failure: ID should be invalid");
        } else if (iteration == 3) {
            assertEquals("WRONG_NAME", company.getCompanyName(), "Failure: Name should be invalid");
        } else if (iteration == 4) {
            assertEquals("WRONG_ADDRESS", company.getCompanyAddress(), "Failure: Address should be invalid");
        } else {
            // Force general failure for remaining cases
            assertNotEquals("INCORRECT_COMPANY", company.getCompanyName(), "Failure: Name should not match");
        }
    }
}