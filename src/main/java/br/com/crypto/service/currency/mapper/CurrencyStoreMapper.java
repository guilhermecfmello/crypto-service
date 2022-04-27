package br.com.crypto.service.currency.mapper;

import br.com.crypto.repository.entity.Currency;
import br.com.crypto.service.currency.domain.CurrencyDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CurrencyStoreMapper {

    CurrencyStoreMapper INSTANCE = Mappers.getMapper( CurrencyStoreMapper.class );

    Currency currencyDomainToEntity(CurrencyDomain currencyDomain);

    List<Currency> currencyListDomainToEntity(List<CurrencyDomain> currencyDomainList);

    CurrencyDomain currencyEntityToDomain(Currency currencyEntity);

    List<CurrencyDomain> currencyListEntityToDomain(List<Currency> currencies);
}
