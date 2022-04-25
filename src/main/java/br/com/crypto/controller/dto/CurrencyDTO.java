package br.com.crypto.controller.dto;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class CurrencyDTO {
    private UUID id;

    @NotBlank
    private String name;

    @NotBlank
    private String code;

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCreatedat(String createdat) {
        this.createdat = createdat;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getCreatedat() {
        return createdat;
    }

    private String createdat;

    public CurrencyDTO(){
        this.name = name;
        this.code = code;
    }

}
