package br.com.crypto.controller;

import br.com.crypto.controller.dto.SystemInfoDTO;
import br.com.crypto.controller.mapper.SystemInfoResponseMapper;
import br.com.crypto.service.GetSystemInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SystemInfoController {

    private final GetSystemInfoService getSystemInfoService;

    @GetMapping("/info")
    public SystemInfoDTO getAllInfo(){

        return SystemInfoResponseMapper.INSTANCE.systemInfoDomainToDto(getSystemInfoService.getAll());
    }
}
