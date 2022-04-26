package br.com.crypto.controller;

import br.com.crypto.controller.dto.CurrencyDTO;
import br.com.crypto.controller.mapper.CurrencyResponseMapper;
import br.com.crypto.repository.entity.Currency;
import br.com.crypto.service.CreateCurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CreateCurrencyService service;

//    @GetMapping("/currencies")
//    List<CurrencyDTO> all() { return Mapper.currencyEntityListToCurrencyDTOList( repository.findAll()); }

    @PostMapping("/currencies")
    CurrencyDTO newCurrency(@RequestBody CurrencyDTO newCurrency) {
        var currencyDomain = CurrencyResponseMapper.INSTANCE.currencyDtoToDomain(newCurrency);
        var currencyDomainSaved = service.execute(currencyDomain);
        return CurrencyResponseMapper.INSTANCE.currencyDomainToDto(currencyDomainSaved);
    }

    // Single item

    @GetMapping("/currencies/{id}")
    Currency one(@PathVariable UUID id) {
        return null;
//        return repository.findById(id)
//                .orElseThrow(() -> new CurrencyNotFoundException(id));
    }

//    @DeleteMapping("/currencies/{id}")
//    void deleteCurrency(@PathVariable UUID id) {
//        repository.deleteById(id);
//    }

    //TODO validate json input in case that name or code is null
    // maybe its done through model class
//    @PutMapping("/currencies/{id}")
//    CurrencyDTO replaceCurrency(@Valid @RequestBody CurrencyDTO newCurrency, @PathVariable UUID id){
//        repository.findById(id)
//                .orElseThrow(() -> new CurrencyNotFoundException(id));
//
//        Currency currency = repository.save(Mapper.currencyDTOToCurrencyEntity(newCurrency));
//
//        return Mapper.currencyEntityToCurrencyDTO(currency);
//    }

}
