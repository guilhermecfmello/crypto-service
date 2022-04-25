package br.com.crypto.service.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CurrencyDomain {

    private UUID id;

    private String name;

    private String code;

    private String createdAt;

    public void test (){
        CurrencyDomain.builder().code("CurrencyCode").build();
    }

}