package br.com.crypto.mapper;

import br.com.crypto.service.domain.CurrencyDomain;
import org.junit.jupiter.api.Test;
import java.util.UUID;

public class CurrencyMapperTest {

    @Test
    public void shouldMapCurrencyDomainToEntity(){
        CurrencyDomain currencyDomain = new CurrencyDomain();
        currencyDomain.setCode("ADA");
        currencyDomain.setName("Cardano");
        currencyDomain.setId(UUID.fromString("4b8d9fcc-a135-4548-b63d-b88a77014583"));
        currencyDomain.setCreatedAt("2022-04-21 20:45:01.232");
    }

}
