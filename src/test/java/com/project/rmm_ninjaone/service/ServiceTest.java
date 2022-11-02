package com.project.rmm_ninjaone.service;

import com.project.rmm_ninjaone.database.DeviceRepository;
import com.project.rmm_ninjaone.database.ServiceRepository;
import com.project.rmm_ninjaone.model.Device;
import com.project.rmm_ninjaone.model.ServiceDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    public static final Long ID = 12345L;

    @Mock
    private ServiceRepository serviceRepository;

    @InjectMocks
    private ServiceService serviceService;

    private ServiceDTO serviceDTOEntity;

    @BeforeEach
    void setup(){
        serviceDTOEntity = new ServiceDTO(ID, "Backup", new BigDecimal(3), new Device(ID, "Windows 10", "WINDOWS_SERVER"));
    }

    @Test
    void saveServiceTest() {
        when(serviceRepository.save(serviceDTOEntity)).thenReturn(serviceDTOEntity);
        assertEquals(serviceDTOEntity, serviceService.save(serviceDTOEntity));
    }

    @Test
    void deleteServiceTest(){
        doNothing().when(serviceRepository).deleteById(ID);
        serviceService.delete(ID);
        Mockito.verify(serviceRepository, times(1)).deleteById(ID);
    }

    @Test
    void getServiceTest() {
        when(serviceRepository.findById(ID)).thenReturn(Optional.of(serviceDTOEntity));
        Optional<ServiceDTO> deviceEntityOptional = serviceService.findBy(serviceDTOEntity);
        ServiceDTO actualEntity = deviceEntityOptional.orElse(null);
        assert actualEntity != null;
        assertEquals(serviceDTOEntity.getServiceName(), actualEntity.getServiceName());
    }
}
