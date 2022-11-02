package com.project.rmm_ninjaone.service;

import com.project.rmm_ninjaone.database.DeviceRepository;
import com.project.rmm_ninjaone.model.Device;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * Class to inject the repository and do the logical functions.
 */
@Service
@Slf4j
public class DeviceService {
    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Device saveDeviceEntity(Device device){
        log.info("Save in DeviceService: {}", device);
        return deviceRepository.save(device);
    }

    public Optional<Device> getDeviceEntity(Long id){
        return deviceRepository.findById(id);
    }

    public void deleteDeviceEntity(Long id) {
        deviceRepository.deleteById(id);
    }

    public Integer updateDeviceEntity(Device device) {
        log.info("DeviceService Update: {}", device);
        return deviceRepository.updateDevice(device.getId(), device.getSystem_name());
    }
}
