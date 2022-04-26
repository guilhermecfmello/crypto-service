package br.com.crypto.service;

import br.com.crypto.repository.CurrencyRepository;
import br.com.crypto.service.domain.CurrencyDomain;
import br.com.crypto.service.mapper.CurrencyStoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCurrencyService {

    private final CurrencyRepository currencyRepository;

    public List<CurrencyDomain> getAll(){
        return CurrencyStoreMapper.INSTANCE.currencyListEntityToDomain(currencyRepository.findAll());
    }
}
