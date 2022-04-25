package br.com.crypto.service;

import br.com.crypto.repository.CurrencyRepository;
import br.com.crypto.service.domain.CurrencyDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateCurrencyService {
    private final CurrencyRepository currencyRepository;

    public CurrencyDomain execute(CurrencyDomain currencyDomain){
        return null;
    }
}
