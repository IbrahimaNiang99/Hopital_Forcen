package com.forcenhopital.mapping;

import org.mapstruct.Mapper;

import com.forcenhopital.dto.ServiceDto;
import com.forcenhopital.entities.Service;

@Mapper
public interface ServiceMapper {

    ServiceDto toService(Service service);
    Service fromService(ServiceDto serviceDto);
}
