package br.com.crypto.exception;

public class CurrencyNotFoundException extends RuntimeException{
    public CurrencyNotFoundException(Long id) {
        super(String.format("Crypto %d not found", id));
    }
}
