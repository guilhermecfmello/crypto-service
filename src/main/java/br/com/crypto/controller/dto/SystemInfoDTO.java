package br.com.crypto.controller.dto;

import br.com.crypto.service.domain.HeaderInfo;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class SystemInfoDTO {

    private List<HeaderInfo> header;

    @NonNull
    private final String springVersion;

    @NonNull
    private final String jdkVersion;

    @NonNull
    private final String javaVersion;

}
