package com.project.rmm_ninjaone.service;


import com.project.rmm_ninjaone.database.ServiceRepository;
import com.project.rmm_ninjaone.model.ServiceDTO;
import lombok.extern.slf4j.Slf4j;
import java.util.Optional;

/**
 * Class to inject the repository and do the logical functions.
 */
@org.springframework.stereotype.Service
@Slf4j
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public ServiceDTO save(ServiceDTO service) {
        log.info("Save in ServiceService: {}", service);
        return this.serviceRepository.save(service);
    }

    public void delete(Long id) {
        log.info("Delete in ServiceService: {}", id);
        this.serviceRepository.deleteById(id);
    }

    public Optional<ServiceDTO> findBy(ServiceDTO idService) {
        return this.serviceRepository.findById(idService.getId());
    }
}
