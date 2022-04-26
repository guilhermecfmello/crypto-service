package br.com.crypto.service.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;


//@Builder
@Data
public class CurrencyDomain {

    private UUID id;

    private String name;

    private String code;

    private String createdAt;

//    public void test (){
//        CurrencyDomain.builder().code("CurrencyCode").build();
//    }

}