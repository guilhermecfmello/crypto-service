package br.com.crypto.controller;

import br.com.crypto.controller.dto.CurrencyDTO;
import br.com.crypto.controller.mapper.CurrencyResponseMapper;
import br.com.crypto.repository.entity.Currency;
import br.com.crypto.service.CreateCurrencyService;
import br.com.crypto.service.DeleteCurrencyService;
import br.com.crypto.service.GetCurrencyService;
import br.com.crypto.service.UpdateCurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CreateCurrencyService createService;

    private final GetCurrencyService getService;

    private final DeleteCurrencyService deleteService;

    private final UpdateCurrencyService updateService;


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

    @DeleteMapping("/currencies/{id}")
    void deleteCurrency(@PathVariable UUID id) {
        deleteService.execute(id);
    }

    //TODO validate json input in case that name or code is null
    // maybe its done through model class
    @PutMapping("/currencies/{id}")
    CurrencyDTO replaceCurrency(@Valid @RequestBody CurrencyDTO newCurrency, @PathVariable UUID id){
        var currency = updateService.execute(id, CurrencyResponseMapper.INSTANCE.currencyDtoToDomain(newCurrency));
        return CurrencyResponseMapper.INSTANCE.currencyDomainToDto(currency);
    }

}
