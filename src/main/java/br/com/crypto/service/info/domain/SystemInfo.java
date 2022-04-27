package br.com.crypto.service.info.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class SystemInfo {

    private List<HeaderInfo> headerInfo = new ArrayList<>();

    @NonNull
    private final String springVersion;

    @NonNull
    private final String jdkVersion;

    @NonNull
    private final String javaVersion;

    public void addHeaderInfo(HeaderInfo headerInfo){
        this.headerInfo.add(headerInfo);
    }
}
