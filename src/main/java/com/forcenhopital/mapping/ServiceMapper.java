package com.forcenhopital.mapping;

import org.mapstruct.Mapper;
import com.forcenhopital.dto.ServiceDto;
import com.forcenhopital.entities.ServiceEntity;

@Mapper
public interface ServiceMapper {

    ServiceDto toService(ServiceEntity service);
    ServiceEntity fromService(ServiceDto serviceDto);
}
