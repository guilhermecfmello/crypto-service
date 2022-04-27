package br.com.crypto.controller.info.mapper;

import br.com.crypto.controller.info.dto.SystemInfoDTO;
import br.com.crypto.service.info.domain.SystemInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SystemInfoResponseMapper {

    SystemInfoResponseMapper INSTANCE = Mappers.getMapper( SystemInfoResponseMapper.class );

    @Mapping(source = "headerInfo", target = "header")
    SystemInfoDTO systemInfoDomainToDto(SystemInfo systemInfo);

}
