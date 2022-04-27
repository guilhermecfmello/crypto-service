package br.com.crypto.service.currency;

import br.com.crypto.repository.CurrencyRepository;
import br.com.crypto.repository.entity.Currency;
import br.com.crypto.service.currency.domain.CurrencyDomain;
import br.com.crypto.service.currency.mapper.CurrencyStoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreateCurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyDomain execute(CurrencyDomain currencyDomain){
        Currency currencySaved = currencyRepository.save(CurrencyStoreMapper.INSTANCE.currencyDomainToEntity(currencyDomain));
        return CurrencyStoreMapper.INSTANCE.currencyEntityToDomain(currencySaved);
    }
}

