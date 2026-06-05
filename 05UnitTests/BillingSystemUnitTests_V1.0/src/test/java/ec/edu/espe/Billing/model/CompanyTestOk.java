package ec.edu.espe.Billing.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

public class CompanyTestOk {

    public static Stream<Arguments> companyProvider() {
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
    @MethodSource("companyProvider")
    public void testCompanyDataIntegrity(String id, String name, String address) {
        Company company = new Company();
        company.setCompanyId(id);
        company.setCompanyName(name);
        company.setCompanyAddress(address);
        assertEquals(id, company.getCompanyId(), "The company ID should match the input");
        assertEquals(name, company.getCompanyName(), "The company name should match the input");
        assertEquals(address, company.getCompanyAddress(), "The company address should match the input");
    }
}