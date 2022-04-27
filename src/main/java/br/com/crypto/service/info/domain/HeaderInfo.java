package br.com.crypto.service.info.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class HeaderInfo {

    @NonNull
    private String key;

    @NonNull
    private String value;
}
