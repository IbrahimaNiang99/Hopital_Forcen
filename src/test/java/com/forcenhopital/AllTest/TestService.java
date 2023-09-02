package com.forcenhopital.AllTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.forcenhopital.dto.ServiceDto;
import com.forcenhopital.mapping.ServiceMapper;
import com.forcenhopital.services.ServiceService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestService {
    
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private ServiceMapper serviceMapper;

    // TESTER L'OPERATION D'AJOUT
    @Test
    public void ajoutService(){
        ServiceDto serviceDto = new ServiceDto();
        serviceDto.setNomService("Cardiologie");

        ServiceDto service = serviceService.ajoutService(serviceDto);
        Assertions.assertNotNull(service);        
        Assertions.assertEquals(serviceDto, service);

    }
}
