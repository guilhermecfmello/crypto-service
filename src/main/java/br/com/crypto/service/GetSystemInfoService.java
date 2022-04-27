package br.com.crypto.service;

import br.com.crypto.service.domain.HeaderInfo;
import br.com.crypto.service.domain.SystemInfo;
import org.springframework.boot.system.JavaVersion;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetSystemInfoService {

    public SystemInfo getAll(){
        SystemInfo systemInfo = new SystemInfo(SpringVersion.getVersion(), System.getProperty("java.version"), JavaVersion.getJavaVersion().toString());
        return this.generateStandardHeader(systemInfo);
    }

    private SystemInfo generateStandardHeader(SystemInfo systemInfo){
        systemInfo.addHeaderInfo(new HeaderInfo("SystemName", "Mercado Doge Coin"));
        systemInfo.addHeaderInfo(new HeaderInfo("SystemVersion", "v1.0.0"));
        systemInfo.addHeaderInfo(new HeaderInfo("SystemMaintainer", "Guilherme Mello"));
        return systemInfo;
    }
}


