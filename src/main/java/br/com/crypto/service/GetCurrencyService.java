package br.com.crypto.service;

import br.com.crypto.exception.CurrencyNotFoundException;
import br.com.crypto.repository.CurrencyRepository;
import br.com.crypto.service.domain.CurrencyDomain;
import br.com.crypto.service.mapper.CurrencyStoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetCurrencyService {

    private final CurrencyRepository currencyRepository;

    public List<CurrencyDomain> getAll(){
        return CurrencyStoreMapper.INSTANCE.currencyListEntityToDomain(currencyRepository.findAll());
    }

    public CurrencyDomain getOne(UUID currencyId) {
        var currency = currencyRepository.findById(currencyId)
                .orElseThrow(() -> new CurrencyNotFoundException(currencyId));
        return CurrencyStoreMapper.INSTANCE.currencyEntityToDomain(currency);
    }
}
