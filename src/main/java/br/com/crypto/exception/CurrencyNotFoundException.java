package br.com.crypto.exception;

import java.util.UUID;

public class CurrencyNotFoundException extends RuntimeException{
    public CurrencyNotFoundException(UUID id) {
        super(String.format("Crypto %d not found", id));
    }
}
