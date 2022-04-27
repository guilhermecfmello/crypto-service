package br.com.crypto.controller.info;

import br.com.crypto.controller.info.dto.SystemInfoDTO;
import br.com.crypto.controller.info.mapper.SystemInfoResponseMapper;
import br.com.crypto.service.info.GetSystemInfoService;
import lombok.RequiredArgsConstructor;
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
