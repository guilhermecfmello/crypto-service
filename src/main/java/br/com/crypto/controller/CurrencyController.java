package br.com.crypto.controller;

import br.com.crypto.dto.CurrencyDTO;
import br.com.crypto.entity.Currency;
import br.com.crypto.exception.CurrencyNotFoundException;
import br.com.crypto.repository.CurrencyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class CurrencyController {

    private final CurrencyRepository repository;

    CurrencyController(CurrencyRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/currencies")
    List<CurrencyDTO> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/currencies")
    Currency newCurrency(@RequestBody CurrencyDTO newCurrency) {
        return repository.save(newCurrency.toEntity());
    }

    // Single item

    @GetMapping("/currencies/{id}")
    Currency one(@PathVariable UUID id) {

        return repository.findById(id)
                .orElseThrow(() -> new CurrencyNotFoundException(id));
    }

    @DeleteMapping("/currencies/{id}")
    void deleteCurrency(@PathVariable UUID id) {
        repository.deleteById(id);
    }

    //TODO validate json input in case that name or code is null
    // maybe its done through model class
    @PutMapping("/currencies/{id}")
    Currency replaceCurrency(@RequestBody Currency newCurrency, @PathVariable UUID id){
        Currency currencyEntity = repository.findById(id)
                .orElseThrow(() -> new CurrencyNotFoundException(id));
        CurrencyDTO currencyDTO = new CurrencyDTO(newCurrency);

        return repository.save(currencyDTO.toEntity());
    }

}
