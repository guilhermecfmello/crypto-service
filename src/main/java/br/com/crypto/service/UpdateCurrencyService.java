package br.com.crypto.service;

import br.com.crypto.exception.CurrencyNotFoundException;
import br.com.crypto.repository.CurrencyRepository;
import br.com.crypto.repository.entity.Currency;
import br.com.crypto.service.domain.CurrencyDomain;
import br.com.crypto.service.mapper.CurrencyStoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateCurrencyService {

    private final CurrencyRepository currencyRepository;
    //TODO throw exception correctly
    public CurrencyDomain execute(UUID currencyId, CurrencyDomain currency){

        CurrencyDomain currencyDomain = CurrencyStoreMapper.INSTANCE.currencyEntityToDomain(currencyRepository.findById(currencyId)
                .orElseThrow(() -> new CurrencyNotFoundException(currencyId)));
        currencyDomain.setName(currency.getName());
        currencyDomain.setCode(currency.getCode());
        return CurrencyStoreMapper.INSTANCE.currencyEntityToDomain(currencyRepository.save(CurrencyStoreMapper.INSTANCE.currencyDomainToEntity(currencyDomain)));
    }
}
