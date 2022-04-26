package br.com.crypto.controller.mapper;

import br.com.crypto.controller.dto.CurrencyDTO;
import br.com.crypto.service.domain.CurrencyDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface CurrencyResponseMapper {

    CurrencyResponseMapper INSTANCE = Mappers.getMapper( CurrencyResponseMapper.class );

    CurrencyDomain currencyDtoToDomain(CurrencyDTO currencyDTO);

    List<CurrencyDomain> currencyListDtoToDomain(List<CurrencyDTO> currencyDTOList);

    CurrencyDTO currencyDomainToDto(CurrencyDomain currencyDomain);

    List<CurrencyDTO> currencyListDomainToDto(List<CurrencyDomain> currencyDomainList);
}
