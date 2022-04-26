package br.com.crypto.service;

import br.com.crypto.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteCurrencyService {

    private final CurrencyRepository currencyRepository;

    public void execute(UUID currencyId){
        currencyRepository.deleteById(currencyId);
    }
}
