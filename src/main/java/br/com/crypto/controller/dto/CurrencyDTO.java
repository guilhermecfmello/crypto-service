package br.com.crypto.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
public class CurrencyDTO {
    private UUID id;

    @NotBlank
    private String name;

    @NotBlank
    private String code;

    private String createdAt;

    public CurrencyDTO(){
        this.name = name;
        this.code = code;
    }

}
