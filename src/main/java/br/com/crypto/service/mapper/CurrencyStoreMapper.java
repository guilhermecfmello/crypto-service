package br.com.crypto.service.mapper;

import br.com.crypto.repository.entity.Currency;
import br.com.crypto.service.domain.CurrencyDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CurrencyStoreMapper {

    CurrencyStoreMapper INSTANCE = Mappers.getMapper( CurrencyStoreMapper.class );

    Currency currencyDomainToEntity(CurrencyDomain currencyDomain);

    CurrencyDomain currencyEntityToDomain(Currency currencyEntity);

}
