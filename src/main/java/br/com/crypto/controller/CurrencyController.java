package br.com.crypto.controller;

import br.com.crypto.controller.dto.CurrencyDTO;
import br.com.crypto.controller.mapper.CurrencyResponseMapper;
import br.com.crypto.repository.entity.Currency;
import br.com.crypto.service.CreateCurrencyService;
import br.com.crypto.service.GetCurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CreateCurrencyService createService;

    private final GetCurrencyService getService;

    @GetMapping("/currencies")
    List<CurrencyDTO> all() {
        return CurrencyResponseMapper.INSTANCE.currencyListDomainToDto(getService.getAll());
    }

    @PostMapping("/currencies")
    CurrencyDTO newCurrency(@RequestBody CurrencyDTO newCurrency) {
        var currencyDomain = CurrencyResponseMapper.INSTANCE.currencyDtoToDomain(newCurrency);
        var currencyDomainSaved = createService.execute(currencyDomain);
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
