package br.com.crypto.controller.currency;

import br.com.crypto.controller.currency.dto.CurrencyDTO;
import br.com.crypto.controller.currency.mapper.CurrencyResponseMapper;
import br.com.crypto.service.currency.CreateCurrencyService;
import br.com.crypto.service.currency.DeleteCurrencyService;
import br.com.crypto.service.currency.GetCurrencyService;
import br.com.crypto.service.currency.UpdateCurrencyService;
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
    CurrencyDTO one(@PathVariable UUID id) {
        return CurrencyResponseMapper.INSTANCE.currencyDomainToDto(getService.getOne(id));
    }

    @DeleteMapping("/currencies/{id}")
    void deleteCurrency(@PathVariable UUID id) {
        deleteService.execute(id);
    }

    @PutMapping("/currencies/{id}")
    CurrencyDTO replaceCurrency(@Valid @RequestBody CurrencyDTO newCurrency, @PathVariable UUID id){
        var currency = updateService.execute(id, CurrencyResponseMapper.INSTANCE.currencyDtoToDomain(newCurrency));
        return CurrencyResponseMapper.INSTANCE.currencyDomainToDto(currency);
    }

}
