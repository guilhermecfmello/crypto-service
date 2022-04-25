package br.com.crypto.controller.mapper;

import br.com.crypto.controller.dto.CurrencyDTO;
import br.com.crypto.service.domain.CurrencyDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CurrencyResponseMapper {

    CurrencyResponseMapper INSTANCE = Mappers.getMapper( CurrencyResponseMapper.class );

    CurrencyDomain currencyDtoToDomain(CurrencyDTO currencyDTO);

    CurrencyDTO currencyDomainToDto(CurrencyDomain currencyDomain);

}
