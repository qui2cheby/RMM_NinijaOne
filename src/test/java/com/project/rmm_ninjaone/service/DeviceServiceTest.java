package com.project.rmm_ninjaone.service;

import com.project.rmm_ninjaone.database.DeviceRepository;
import com.project.rmm_ninjaone.model.Device;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeviceServiceTest {
    public static final Long ID = 12345L;

    @Mock
    private DeviceRepository deviceRepository;

    @InjectMocks
    private DeviceService deviceService;

    private Device deviceEntity;
    private Device deviceEntityModify;

    @BeforeEach
    void setup(){
        deviceEntity = new Device(ID, "Windows 10", "WINDOWS_SERVER");
        deviceEntityModify = new Device(ID, "Windows 11", "WINDOWS_SERVER");
    }

    @Test
    void saveDeviceTest() {
        when(deviceRepository.save(deviceEntity)).thenReturn(deviceEntity);
        assertEquals(deviceEntity, deviceService.saveDeviceEntity(deviceEntity));
    }

    @Test
    void updateDeviceTest() {
        when(deviceRepository.save(deviceEntityModify)).thenReturn(deviceEntityModify);
        assertEquals(deviceEntityModify, deviceService.saveDeviceEntity(deviceEntityModify));
    }

    @Test
    void deleteDevice(){
        doNothing().when(deviceRepository).deleteById(ID);
        deviceService.deleteDeviceEntity(ID);
        Mockito.verify(deviceRepository, times(1)).deleteById(ID);
    }

    @Test
    void getDevice() {
        when(deviceRepository.findById(ID)).thenReturn(Optional.of(deviceEntity));
        Optional<Device> deviceEntityOptional = deviceService.getDeviceEntity(ID);
        Device actualEntity = deviceEntityOptional.orElse(null);
        assert actualEntity != null;
        assertEquals(deviceEntity.getSystem_name(), actualEntity.getSystem_name());
    }
}
